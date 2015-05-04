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
import be.flo.project.service.AccountService;
import be.flo.project.service.SessionService;
import be.flo.project.util.ErrorMessageEnum;
import be.flo.project.util.exception.MyRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import play.db.jpa.Transactional;
import play.mvc.Result;

/**
 * Created by florian on 25/03/15.
 * This class is used to connect / register / logout an account.
 * Functions doesn't required an authentication.
 */
@org.springframework.stereotype.Controller
public class LoginRestController extends AbstractRestController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private EmailController emailController;

    /**
     * try to connect the user to an account with the password / email
     * expected the LoginDTO as Json data
     * Return an exception is the email / password doesn't correspond of any account
     *
     * @return a Login is the credential are valid and store the account into the context.
     * Create also a session
     */
    @Transactional
    public Result login() {

        //extract DTO
        LoginDTO dto = extractDTOFromRequest(LoginDTO.class);

        //control account
        Account account = accountService.findByEmail(dto.getEmail());
//TODO
//        if (account == null || !accountService.controlPassword(dto.getPassword(), account)) {
//            //if there is no account for this email or the password doesn't the right, throw an exception
//            throw new MyRuntimeException(ErrorMessage.LOGIN_WRONG_PASSWORD_LOGIN);
//        }

        //session
        sessionService.saveOrUpdate(new Session(account, securityController.getSource(ctx())));

        //storage
        securityController.storeAccount(ctx(), account);

        //build result
        LoginSuccessDTO result = new LoginSuccessDTO();
        result.setMyself(dozerService.map(account, AccountDTO.class));
        if (dto.getKeepSessionOpen()) {
            result.setAuthenticationKey(account.getAuthenticationKey());
        }
        return ok(result);
    }

    /**
     * Register a new account with data contain into the RegistrationDTO
     *
     * @return Return an exception if the email is already used
     * Create a account, session, store the account into the session and return a LoginSuccess if already is ok
     */
    @Transactional
    public Result registration() {

        RegistrationDTO dto = extractDTOFromRequest(RegistrationDTO.class);

        //Control email
        if (accountService.findByEmail(dto.getEmail()) != null) {
            throw new MyRuntimeException(ErrorMessageEnum.EMAIL_ALREADY_USED);
        }

        //account
        Account account = dozerService.map(dto, Account.class);
        account.setId(null);
        if (account.getLang() == null) {
            account.setLang(lang());
        }
        account.getRoles().add(new Role(account, RoleEnum.USER));


        if (dto.getLang() != null) {
            changeLang(dto.getLang().getCode());
        }

        //send email
        emailController.sendApplicationRegistrationEmail(account);

        accountService.saveOrUpdate(account);

        //session
        sessionService.saveOrUpdate(new Session(account, securityController.getSource(ctx())));

        LoginSuccessDTO result = new LoginSuccessDTO();
        result.setMyself(dozerService.map(account, AccountDTO.class));
        result.setAuthenticationKey(account.getAuthenticationKey());

        //storage
        securityController.storeAccount(ctx(), account);

        return ok(result);

    }

    /**
     * remove the account of the context
     *
     * @return a redirection to the home page
     */
    @Transactional
    public Result logout() {
        securityController.logout(ctx());
        return redirect("/");
    }


}
