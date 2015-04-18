package be.flo.project.service.impl;

import be.flo.project.dto.TranslationsDTO;
import be.flo.project.model.entities.Translation;
import be.flo.project.model.entities.TranslationValue;
import play.api.Play;
import play.api.i18n.MessagesPlugin;
import play.i18n.Lang;
import play.i18n.Messages;
import scala.Option;
import scala.collection.JavaConverters;
import scala.collection.immutable.Map;
import be.flo.project.service.TranslationService;
import be.flo.project.util.EmailMessage;
import be.flo.project.util.ErrorMessage;

/**
 * Created by florian on 11/11/14.
 */
public class TranslationServiceImpl implements TranslationService {

    @Override
    public TranslationsDTO getTranslations(Lang lang) {

        java.util.Map<String, String> m = new java.util.HashMap<>();

        if(lang!=null) {
            Option<Map<String, String>> mapExpected = Play.current().plugin(MessagesPlugin.class).get().api().messages().get(lang.code());

            if(mapExpected.nonEmpty()) {
                //convert
                m.putAll(JavaConverters.mapAsJavaMapConverter(mapExpected.get()).asJava());
            }
        }

        if(!lang.code().equals("en")) {

            Option<Map<String, String>> mapDefaultLanguage = Play.current().plugin(MessagesPlugin.class).get().api().messages().get("en");

            java.util.Map<String, String> mapAsJavaDefault = JavaConverters.mapAsJavaMapConverter(mapDefaultLanguage.get()).asJava();

            for (java.util.Map.Entry<String, String> entry : mapAsJavaDefault.entrySet()) {
                if (!m.containsKey(entry.getKey())) {
                    m.put(entry.getKey(), entry.getValue());
                }
            }
        }

        return new TranslationsDTO(m);
    }

    @Override
    public String getTranslation(ErrorMessage errorMessage, Lang language, Object... params) {

        return Messages.get(language, errorMessage.name(), params);
    }

    @Override
    public String getTranslation(String messageRef, Lang language, Object... params) {

        return Messages.get(language, messageRef, params);
    }

    @Override
    public String getTranslation(EmailMessage emailMessage, Lang language, Object... params) {
        return Messages.get(language, emailMessage.name(), params);
    }

    @Override
    public String getTranslation(Translation translation, Lang language, Object... params) {
        String message = null;
        for (TranslationValue translationValue : translation.getTranslationValues()) {
            if (translationValue.getLanguageCode().equals(language.code())) {
                message = translationValue.getContent();
            }
        }

        if (message == null) {
            return "Message not found";
        }

        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                Object o = params[i];
                message = message.replace("{" + i + "}", o + "");

            }

        }
        return message;
    }
}
