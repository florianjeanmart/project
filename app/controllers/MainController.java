package controllers;

import com.avaje.ebean.annotation.Transactional;
import controllers.technical.AbstractController;
import controllers.technical.security.SecurityController;
import converter.AccountToAccountDTOConverter;
import converter.LanguageToLanguageDTOConverter;
import dto.InterfaceDataDTO;
import dto.LangDTO;
import dto.ListDTO;
import play.i18n.Lang;
import play.mvc.Result;

/**
 * Created by florian on 23/03/15.
 */
public class MainController  extends AbstractController {

    //controller
    private LanguageToLanguageDTOConverter languageToLanguageDTOConverter = new LanguageToLanguageDTOConverter();

    @Transactional
    public Result mainPage() {

        //try with param
        InterfaceDataDTO interfaceDataDTO  = new InterfaceDataDTO();
        interfaceDataDTO.setLangId(lang().code());
        interfaceDataDTO.setTranslations(translationService.getTranslations(lang()));
        if(securityController.isAuthenticated(ctx())) {
            AccountToAccountDTOConverter accountToAccountDTOConverter = new AccountToAccountDTOConverter();
            interfaceDataDTO.setMySelf(accountToAccountDTOConverter.convert(securityController.getCurrentUser()));
        }


        return ok(views.html.home.render(getAvaiableLanguage(),interfaceDataDTO));
    }
    private ListDTO<LangDTO> getAvaiableLanguage(){

        //compute list lang
        ListDTO<LangDTO> langDTOListDTO = new ListDTO<>();
        for (Lang lang : Lang.availables()) {
            langDTOListDTO.addElement(languageToLanguageDTOConverter.convert(lang));
        }
        return langDTOListDTO;
    }
}
