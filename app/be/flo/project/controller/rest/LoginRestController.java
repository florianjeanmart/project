package be.flo.project.controller.rest;

import be.flo.project.controller.EmailController;
import be.flo.project.controller.technical.security.role.RoleEnum;
import be.flo.project.dto.AccountDTO;
import be.flo.project.dto.LoginSuccessDTO;
import be.flo.project.dto.post.LoginDTO;
import be.flo.project.dto.post.RegistrationDTO;
import be.flo.project.model.entities.Account;
import be.flo.project.model.entities.Role;
import be.flo.project.model.entities.Session;
import org.springframework.beans.factory.annotation.Autowired;
import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.Http;
import play.mvc.Result;
import be.flo.project.service.AccountService;
import be.flo.project.service.SessionService;
import be.flo.project.service.impl.AccountServiceImpl;
import be.flo.project.service.impl.SessionServiceImpl;
import be.flo.project.util.ErrorMessage;
import be.flo.project.util.exception.MyRuntimeException;

/**
 * Created by florian on 25/03/15.
 */
@org.springframework.stereotype.Controller
public class LoginRestController extends AbstractRestController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private EmailController emailController;

    @Transactional
    public Result login() {

        LoginDTO dto = extractDTOFromRequest(LoginDTO.class);

        Account account = accountService.findByEmail(dto.getEmail());

        if (account == null || !accountService.controlPassword(dto.getPassword(), account)) {
            throw new MyRuntimeException(ErrorMessage.LOGIN_WRONG_PASSWORD_LOGIN);
        }

        LoginSuccessDTO result = new LoginSuccessDTO();
        result.setMyself(dozerService.getMapper().map(account, AccountDTO.class));
        if (dto.getKeepSessionOpen()) {
            result.setAuthenticationKey(account.getAuthenticationKey());
        }

        //session
        sessionService.saveOrUpdate(new Session(account, securityController.getSource(ctx())));

        //storage
        securityController.storeAccount(ctx(), account);

        return ok(result);
    }

    @Transactional
    public Result registration(){

        RegistrationDTO dto = extractDTOFromRequest(RegistrationDTO.class);

        //Control email
        if (accountService.findByEmail(dto.getEmail()) != null) {
            throw new MyRuntimeException(ErrorMessage.EMAIL_ALREADY_USED);
        }

        //account

        Account account = dozerService.getMapper().map(dto,Account.class);
        account.setId(null);
        if(account.getLang() == null){
            account.setLang(lang());
        }
        account.getRoles().add(new Role(account,RoleEnum.USER));


        if (dto.getLang() != null) {
            changeLang(dto.getLang().getCode());
        }

        //send email
        emailController.sendApplicationRegistrationEmail(account);

        accountService.saveOrUpdate(account);

        //session
        sessionService.saveOrUpdate(new Session(account,securityController.getSource(ctx())));

        LoginSuccessDTO result = new LoginSuccessDTO();
        result.setMyself(dozerService.getMapper().map(account, AccountDTO.class));
        result.setAuthenticationKey(account.getAuthenticationKey());

        //storage
        securityController.storeAccount(ctx(),account);


        Logger.info("sesssssssion:" + ctx().session().get("email"));

        return ok(result);

    }

    @Transactional
    public Result logout(){
        securityController.logout(ctx());
        return redirect("/");
    }


}
