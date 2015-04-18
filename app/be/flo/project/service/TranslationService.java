package be.flo.project.service;

import be.flo.project.dto.TranslationsDTO;
import be.flo.project.model.entities.Translation;
import play.i18n.Lang;
import be.flo.project.util.EmailMessage;
import be.flo.project.util.ErrorMessage;

/**
 * Created by florian on 6/12/14.
 */
public interface TranslationService {

    TranslationsDTO getTranslations(Lang lang);

    String getTranslation(ErrorMessage errorMessage, Lang language, Object... params);

    String getTranslation(String messageRef, Lang language, Object... params);

    String getTranslation(EmailMessage emailMessage, Lang language, Object... params);

    String getTranslation(Translation translation, Lang language, Object... params);
}
