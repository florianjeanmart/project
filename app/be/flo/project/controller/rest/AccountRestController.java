package be.flo.project.controller.rest;

import be.flo.project.controller.technical.security.annotation.SecurityAnnotation;
import be.flo.project.controller.technical.security.role.RoleEnum;
import be.flo.project.dto.AccountDTO;
import be.flo.project.dto.ChangeEmailDTO;
import be.flo.project.dto.ChangePasswordDTO;
import be.flo.project.model.entities.Account;
import play.db.jpa.Transactional;
import play.i18n.Lang;
import play.mvc.Http;
import play.mvc.Result;
import be.flo.project.service.AccountService;
import be.flo.project.service.impl.AccountServiceImpl;
import be.flo.project.util.ErrorMessage;
import be.flo.project.util.exception.MyRuntimeException;

/**
 * Created by florian on 26/03/15.
 */
public class AccountRestController extends AbstractRestController {

    //service
    private AccountService accountService = new AccountServiceImpl();

    @Transactional
    @SecurityAnnotation(role = RoleEnum.USER)
    public Result myself(){
        return ok(getMapper().map(securityController.getCurrentUser(), AccountDTO.class));
    }


    @Transactional
    @SecurityAnnotation(role = RoleEnum.USER)
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

        if (dto.getLang() != null) {
            Lang lang = Lang.forCode(dto.getLang().getCode());
            if(lang!=null) {
                account.setLang(getMapper().map(dto.getLang(), Lang.class));
                changeLang(lang.code());
            }
        }

        //save
        accountService.saveOrUpdate(account);

        return ok(getMapper().map(account, AccountDTO.class));
    }

    @Transactional
    @SecurityAnnotation(role = RoleEnum.USER)
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

        return ok(getMapper().map(account, AccountDTO.class));
    }

    @Transactional
    @SecurityAnnotation(role = RoleEnum.USER)
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


        return ok(getMapper().map(account, AccountDTO.class));
    }
}
