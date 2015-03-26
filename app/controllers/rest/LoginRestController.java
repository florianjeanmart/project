package controllers.rest;

import controllers.EmailController;
import converter.AccountToLoginSuccessConverter;
import dto.LoginSuccessDTO;
import dto.post.LoginDTO;
import dto.post.RegistrationDTO;
import models.entities.Account;
import models.entities.Session;
import play.Logger;
import play.i18n.Lang;
import play.mvc.Result;
import services.AccountService;
import services.SessionService;
import services.impl.AccountServiceImpl;
import services.impl.SessionServiceImpl;
import util.ErrorMessage;
import util.exception.MyRuntimeException;

/**
 * Created by florian on 25/03/15.
 */
public class LoginRestController extends AbstractRestController {

    private AccountService accountService = new AccountServiceImpl();
    private SessionService sessionService = new SessionServiceImpl();
    private EmailController emailController = new EmailController();

    public Result login() {

        LoginDTO dto = extractDTOFromRequest(LoginDTO.class);

        Account account = accountService.findByEmail(dto.getEmail());

        if (account == null || !accountService.controlPassword(dto.getPassword(), account)) {
            throw new MyRuntimeException(ErrorMessage.LOGIN_WRONG_PASSWORD_LOGIN);
        }

        //result
        AccountToLoginSuccessConverter converter = new AccountToLoginSuccessConverter();

        LoginSuccessDTO result = converter.convert(account);

        //session
        sessionService.saveOrUpdate(new Session(account, true));

        //storage
        securityController.storeAccount(ctx(), account);

        return ok(result);
    }

    public Result registration(){

        RegistrationDTO dto = extractDTOFromRequest(RegistrationDTO.class);

        //Control email
        if (accountService.findByEmail(dto.getEmail()) != null) {
            throw new MyRuntimeException(ErrorMessage.EMAIL_ALREADY_USED);
        }

        //account
        Account account = new Account();
        account.setMale(dto.getMale());
        account.setEmail(dto.getEmail());
        account.setFirstname(dto.getFirstname());
        account.setLastname(dto.getLastname());
        account.setIsAdmin(true);
        account.setKeepSessionOpen(dto.getKeepSessionOpen());
        account.setLanguage(dto.getLang());
        account.setPassword(dto.getPassword());

        if (dto.getLang() != null) {
            Lang lang = Lang.forCode(dto.getLang());
            if(lang!=null) {
                account.setLanguage(dto.getLang());
                changeLang(lang.code());
            }
        }
        if(account.getLanguage()==null){
            account.setLanguage(lang().code());
        }

        //send email
        emailController.sendApplicationRegistrationEmail(account);

        accountService.saveOrUpdate(account);

        //session
        sessionService.saveOrUpdate(new Session(account,true));


        //result
        AccountToLoginSuccessConverter converter = new AccountToLoginSuccessConverter();

        LoginSuccessDTO success = converter.convert(account);

        //storage
        securityController.storeAccount(ctx(),account);

        return ok(success);

    }


    public Result logout(){
        securityController.logout(ctx());
        return redirect("/");
    }


}
