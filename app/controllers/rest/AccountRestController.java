package controllers.rest;

import com.avaje.ebean.annotation.Transactional;
import controllers.technical.security.SecurityRestController;
import converter.AccountToAccountDTOConverter;
import dto.AccountDTO;
import dto.ChangeEmailDTO;
import dto.ChangePasswordDTO;
import models.entities.Account;
import play.i18n.Lang;
import play.mvc.Result;
import play.mvc.Results;
import play.mvc.Security;
import services.AccountService;
import services.impl.AccountServiceImpl;
import util.ErrorMessage;
import util.exception.MyRuntimeException;

/**
 * Created by florian on 26/03/15.
 */
public class AccountRestController extends AbstractRestController {

    //service
    private AccountService accountService = new AccountServiceImpl();
    //converter
    private AccountToAccountDTOConverter accountToAccountDTOConverter  = new AccountToAccountDTOConverter();

    @Security.Authenticated(SecurityRestController.class)
    @Transactional
    public Result editAccount(long id){

        AccountDTO dto = extractDTOFromRequest(AccountDTO.class);

        //contorl it's myself'
        if (!securityController.getCurrentUser().getId().equals(id)) {
            throw new MyRuntimeException(ErrorMessage.NOT_YOURSELF, id);
        }

        Account account= securityController.getCurrentUser();

        //edit
        account.setFirstname(dto.getFirstname());
        account.setLastname(dto.getLastname());
        account.setMale(dto.getMale());
        account.setKeepSessionOpen(dto.getKeepSessionOpen());

        if (dto.getLanguageCode() != null) {
            Lang lang = Lang.forCode(dto.getLanguageCode());
            if(lang!=null) {
                account.setLanguage(dto.getLanguageCode());
                changeLang(lang.code());
            }
        }

        //save
        accountService.saveOrUpdate(account);

        return ok(accountToAccountDTOConverter.convert(account));
    }

    @Security.Authenticated(SecurityRestController.class)
    @Transactional
    public Result changePassword(long id) {

        //contorl it's myself'
        if (!securityController.getCurrentUser().getId().equals(id)) {
            throw new MyRuntimeException(ErrorMessage.NOT_YOURSELF, id);
        }

        ChangePasswordDTO changePasswordDTO = extractDTOFromRequest(ChangePasswordDTO.class);

        Account account= securityController.getCurrentUser();

        //control last password
        if (!accountService.controlPassword(changePasswordDTO.getOldPassword(), account)) {
            throw new MyRuntimeException(ErrorMessage.NOT_YOUR_PASSWORD);
        }

        account.setPassword(changePasswordDTO.getNewPassword());

        //operation
        accountService.saveOrUpdate(account);

        return ok(accountToAccountDTOConverter.convert(account));
    }
    @Security.Authenticated(SecurityRestController.class)
    @Transactional
    public Result changeEmail(long id) {

        //control it's myself
        if (!securityController.getCurrentUser().getId().equals(id)) {
            throw new MyRuntimeException(ErrorMessage.NOT_YOURSELF, id);
        }

        Account account = securityController.getCurrentUser();

        ChangeEmailDTO changeEmailDTO = extractDTOFromRequest(ChangeEmailDTO.class);

        //control email
        Account sameEmailAccount = accountService.findByEmail(changeEmailDTO.getNewEmail());
        if(sameEmailAccount!=null && !sameEmailAccount.getId().equals(account.getId())){
            throw new MyRuntimeException(ErrorMessage.EMAIL_ALREADY_USED);
        }

        //control last password
        if (!accountService.controlPassword(changeEmailDTO.getOldPassword(), securityController.getCurrentUser())) {
            throw new MyRuntimeException(ErrorMessage.NOT_YOUR_OLD_PASSWORD);
        }

        account.setEmail(changeEmailDTO.getNewEmail());

        //operation
        accountService.saveOrUpdate(account);

        //store
        securityController.storeAccount(ctx(), account);


        return ok(accountToAccountDTOConverter.convert(account));
    }
}
