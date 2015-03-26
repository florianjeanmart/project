package controllers.technical.security;

import models.entities.Account;
import play.mvc.Http;
import play.mvc.Security;
import services.AccountService;
import services.impl.AccountServiceImpl;
import util.ErrorMessage;
import util.exception.MyRuntimeException;

/**
 * Created by florian on 10/11/14.
 */
public abstract class CommonSecurityController extends Security.Authenticator {

    //recover the language into the http request
    public static final String REQUEST_HEADER_LANGUAGE = "language";
    //recover the email into the session
    public static final String SESSION_IDENTIFIER_STORE = "email";
    //name of the cookie for the automatic reconnection
    public static final String COOKIE_KEEP_SESSION_OPEN = "session_key";
    //recover the session key into the http request
    public static final String REQUEST_HEADER_AUTHENTICATION_KEY = "authenticationKey";
    //error for failed authentication
    public static final String FAILED_AUTHENTICATION_CAUSE = "FAILED_AUTHENTICATION_CAUSE";
    //error for wrong rights
    public static final String FAILED_AUTHENTICATION_CAUSE_WRONG_RIGHTS = "WRONG_RIGHT";

    //service
    private static final AccountService USER_SERVICE = new AccountServiceImpl();


    /**
     * two ways : by the session or by the authentication key into the http request
     *
     * @param ctx
     * @return
     */
    @Override
    public String getUsername(Http.Context ctx) {

        if (ctx.session().get(CommonSecurityController.SESSION_IDENTIFIER_STORE) == null) {

            String authenticationKey = ctx.request().getHeader(REQUEST_HEADER_AUTHENTICATION_KEY);

            if (authenticationKey == null) {
                return null;
            }

            //control authentication
            Account currentAccount = getCurrentUser();
            if (currentAccount == null) {
                return null;
            }

            //test right
            if(!testRight(currentAccount)){
                ctx.args.put(FAILED_AUTHENTICATION_CAUSE,FAILED_AUTHENTICATION_CAUSE_WRONG_RIGHTS);
                return null;
            }

            ctx.changeLang(currentAccount.getLanguage().code());
            return currentAccount.getEmail();
        } else {
            return ctx.session().get(CommonSecurityController.SESSION_IDENTIFIER_STORE);
        }
    }

    /**
     * abstract request to test user's rights. Depend of the implementation and the level security
     * @param account
     * @return
     */
    public abstract boolean testRight(Account account);

    /**
     * return the current user if the user is authenticated
     * @return
     */
    public Account getCurrentUser() {

        //by session
        if (Http.Context.current().session().get(SESSION_IDENTIFIER_STORE) != null) {
            return USER_SERVICE.findByEmail(Http.Context.current().session().get(SESSION_IDENTIFIER_STORE));
        }

        //by request
        if(Http.Context.current().request().getHeader(REQUEST_HEADER_AUTHENTICATION_KEY)!=null) {
            String authentication = Http.Context.current().request().getHeader(REQUEST_HEADER_AUTHENTICATION_KEY);
            return  USER_SERVICE.findByAuthenticationKey(authentication);
        }
        throw new MyRuntimeException(ErrorMessage.NOT_CONNECTED);
    }

    /**
     * return true if the user is authenticated
     * @param ctx
     * @return
     */
    public boolean isAuthenticated(Http.Context ctx) {

        if (ctx.session().get(SESSION_IDENTIFIER_STORE) != null) {
            return true;
        }

        if (ctx.request().cookie(CommonSecurityController.COOKIE_KEEP_SESSION_OPEN) != null) {

            String key = ctx.request().cookie(CommonSecurityController.COOKIE_KEEP_SESSION_OPEN).value();

            String keyElements[] = key.split(":");

            try {
                Account account = USER_SERVICE.findById(Long.parseLong(keyElements[0]));

                if (account != null && USER_SERVICE.controlAuthenticationKey(keyElements[1], account)) {
                    //connection
                    storeAccount(ctx, account);
                    return true;
                }
            }
            catch(NumberFormatException e){

            }
        }

        return false;
    }

    public void logout(Http.Context ctx) {

        if (getCurrentUser() != null && getCurrentUser().isKeepSessionOpen()) {

            Account currentAccount = getCurrentUser();
            currentAccount.setKeepSessionOpen(false);

            USER_SERVICE.saveOrUpdate(currentAccount);
        }
        ctx.session().clear();
    }

    public void storeAccount(Http.Context context, Account account) {

        //if the login and the password are ok, refresh the session
        Http.Context.current().session().clear();
        Http.Context.current().session().put(SESSION_IDENTIFIER_STORE, account.getEmail());

        context.changeLang(account.getLanguage().code());
    }

    public String getCookieKey() {
        if(getCurrentUser()!=null){
            return getCurrentUser().getId()+":"+getCurrentUser().getAuthenticationKey();
        }
        return null;
    }
}
