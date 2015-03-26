package controllers;

import controllers.technical.AbstractController;
import models.entities.Account;
import services.EmailService;
import services.TranslationService;
import services.impl.EmailServiceImpl;
import services.impl.TranslationServiceImpl;
import util.EmailMessage;

/**
 * Created by florian on 6/12/14.
 */
public class EmailController extends AbstractController {

    //service
    private EmailService emailService = new EmailServiceImpl();
    private TranslationService translationService = new TranslationServiceImpl();

    public void sendApplicationRegistrationEmail(Account account){

        String title = translationService.getTranslation(EmailMessage.REGISTRATION_APP_EMAIL_TITLE,lang());

        // 0 => account.name
        // 1 => password
        String body = translationService.getTranslation(EmailMessage.REGISTRATION_APP_EMAIL_BODY,lang(),
                account.getFirstname()+" "+account.getLastname(),
                account.getPassword());

        try {
            emailService.sendEmail(account, title, body);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendNewPasswordEmail(Account account) {

        String title = translationService.getTranslation(
                EmailMessage.NEW_PASSWORD_EMAIL_TITLE,
                account.getLanguage());

        String body = translationService.getTranslation(
                EmailMessage.NEW_PASSWORD_EMAIL_BODY,
                account.getLanguage(),
                account.getFirstname()+" "+account.getLastname(),
                account.getPassword());

        try {
            emailService.sendEmail(account,title,body);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
