package converter;

import dto.InterfaceDataDTO;
import models.entities.Account;
import play.i18n.Lang;
import services.TranslationService;
import services.impl.TranslationServiceImpl;

/**
 * Created by florian on 29/12/14.
 */
public class MyselfToInterfaceDataDTOConverter implements ConverterInterface<Account, InterfaceDataDTO>{

    //service
    private TranslationService translationService = new TranslationServiceImpl();

    //converter
    private AccountToAccountDTOConverter accountToAccountDTOConverter = new AccountToAccountDTOConverter();
    private LanguageToLanguageDTOConverter languageToLanguageDTOConverter = new LanguageToLanguageDTOConverter();

    @Override
    public InterfaceDataDTO convert(Account entity) {

        InterfaceDataDTO dto = new InterfaceDataDTO();

        for (Lang lang : Lang.availables()) {
            dto.addLanguage(languageToLanguageDTOConverter.convert(lang));
        }


        dto.setTranslations(translationService.getTranslations(entity.getLanguage()));

        dto.setMySelf(accountToAccountDTOConverter.convert(entity));

        dto.setLangId(entity.getLanguage().code());

        return dto;
    }
}
