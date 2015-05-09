package be.flo.project.controller;

import be.flo.project.controller.technical.AbstractController;
import be.flo.project.dto.AccountDTO;
import be.flo.project.dto.InterfaceDataDTO;
import be.flo.project.dto.LangDTO;
import be.flo.project.dto.ListDTO;
import be.flo.project.util.AppStatusEnum;
import play.Configuration;
import play.Logger;
import play.db.jpa.Transactional;
import play.i18n.Lang;
import play.mvc.Result;

/**
 * Created by florian on 23/03/15.
 */
@org.springframework.stereotype.Controller
public class MainController  extends AbstractController {


    String accessKey = Configuration.root().getString("app.status");

    @Transactional
    public Result mainPage() {


        AppStatusEnum appStatus = AppStatusEnum.getByString(accessKey);


        //try with param
        InterfaceDataDTO interfaceDataDTO  = new InterfaceDataDTO();
        interfaceDataDTO.setLangId(lang().code());
        interfaceDataDTO.setTranslations(translationService.getTranslations(lang()));
        interfaceDataDTO.setAppStatus(appStatus.getS());
        if(securityController.isAuthenticated(ctx())) {
            AccountDTO accountDTO = dozerService.map(securityController.getCurrentUser(), AccountDTO.class);
            interfaceDataDTO.setMySelf(accountDTO);
            Logger.info(securityController.getCurrentUser()+"<=>"+accountDTO);
        }


        return ok(be.flo.project.views.html.template.render(getAvaiableLanguage(),interfaceDataDTO));
    }

    private ListDTO<LangDTO> getAvaiableLanguage(){

        //compute list lang
        ListDTO<LangDTO> langDTOListDTO = new ListDTO<>();
        for (Lang lang : Lang.availables()) {
            LangDTO langDTO=dozerService.map(lang, LangDTO.class);
            Logger.info(lang+"<=>"+langDTO);
            langDTOListDTO.addElement(langDTO);
        }
        return langDTOListDTO;
    }
}
