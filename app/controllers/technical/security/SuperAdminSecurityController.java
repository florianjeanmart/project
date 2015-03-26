package controllers.technical.security;

import models.entities.Account;

/**
 * Created by florian on 20/02/15.
 */
public class SuperAdminSecurityController extends SecurityRestController {

    @Override
    public boolean testRight(Account currentAccount){
        return currentAccount.getIsSuperAdmin();
    }

}
