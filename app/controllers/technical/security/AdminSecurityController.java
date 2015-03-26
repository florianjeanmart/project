package controllers.technical.security;

import models.entities.Account;

/**
 * Created by florian on 10/11/14.
 */
public class AdminSecurityController extends SecurityController {

    @Override
    public boolean testRight(Account currentAccount){
        return currentAccount.getIsAdmin();
    }
}
