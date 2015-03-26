package services.impl;

import com.avaje.ebean.Ebean;
import models.entities.Account;
import org.jasypt.util.password.StrongPasswordEncryptor;
import services.AccountService;
import util.KeyGenerator;

/**
 * Created by florian on 10/11/14.
 */
public class AccountServiceImpl extends CrudServiceImpl<Account> implements AccountService {

    @Override
    public Account findByEmail(String email) {

        return Ebean.createNamedQuery(Account.class, Account.FIND_BY_EMAIL)
                .setParameter(Account.PARAM_EMAIL, email)
                .findUnique();
    }

    @Override
    public void saveOrUpdate(Account account) {

        account.setEmail(account.getEmail().toLowerCase());

        //generate the password
        if (account.getPassword().length() < 50) {
            account.setPassword(generateEncryptingPassword(account.getPassword()));
        }

        //crypte the authentication value
        if (account.getAuthenticationKey() != null && account.getAuthenticationKey().length() < 50) {
            account.setAuthenticationKey(generateEncryptingPassword(account.getAuthenticationKey()));
        }
        //or generate it
        else if(account.getAuthenticationKey()==null){
            account.setAuthenticationKey(generateEncryptingPassword(KeyGenerator.generateRandomKey(40)));
        }
        super.saveOrUpdate(account);
    }

    @Override
    public Account findByAuthenticationKey(String authenticationKey) {
        return Ebean.createNamedQuery(Account.class, Account.FIND_BY_AUTHENTICATION_KEY)
                .setParameter(Account.PARAM_AUTHENTICATION_KEY, authenticationKey)
                .findUnique();
    }

    @Override
    public boolean controlAuthenticationKey(String authenticationKey, Account account) {
        return !(!account.isKeepSessionOpen() || account.getAuthenticationKey().length() < 40) && account.getAuthenticationKey() != null && new StrongPasswordEncryptor().checkPassword(authenticationKey, account.getAuthenticationKey());
    }

    @Override
    public boolean controlPassword(String password, Account account) {
        return new StrongPasswordEncryptor().checkPassword(password,
                account.getPassword());
    }

    @Override
    public Integer getCount() {
        return Ebean.createQuery(Account.class).findRowCount();
    }

    private String generateEncryptingPassword(final String password) {

        return new StrongPasswordEncryptor().encryptPassword(password);
    }

}
