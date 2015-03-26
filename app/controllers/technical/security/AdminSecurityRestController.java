package controllers.technical.security;

import models.entities.Account;

/**
 * Created by florian on 10/11/14.
 */
public class AdminSecurityRestController extends SecurityRestController {

    @Override
    public boolean testRight(Account currentAccount){
        return currentAccount.getIsAdmin();
    }
}
