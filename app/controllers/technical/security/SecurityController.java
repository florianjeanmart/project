package controllers.technical.security;

import controllers.MainController;
import models.entities.Account;
import play.mvc.Http;
import play.mvc.Result;

/**
 * Created by florian on 10/11/14.
 */
public class SecurityController extends CommonSecurityController {

    //controller
    private static MainController mainController = new MainController();

    @Override
    public Result onUnauthorized(Http.Context ctx) {
        return mainController.mainPage();
    }

    @Override
    public boolean testRight(Account account) {
        return true;
    }
}
