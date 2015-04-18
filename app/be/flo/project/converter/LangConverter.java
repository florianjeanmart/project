package be.flo.project.converter;

import be.flo.project.dto.LangDTO;
import org.dozer.CustomConverter;
import org.dozer.DozerConverter;
import play.Logger;
import play.i18n.Lang;

/**
 * Created by florian on 16/04/15.
 */
public class LangConverter extends DozerConverter<Lang, LangDTO> implements CustomConverter {

    public LangConverter() {
        super(Lang.class, LangDTO.class);
    }

    @Override
    public LangDTO convertTo(Lang lang, LangDTO langDTO) {

        LangDTO dto = new LangDTO();

        dto.setCode(lang.code());
        dto.setLanguage(lang.language());

        Logger.info("LangConverter :"+lang+"/"+dto);
        return dto;
    }

    @Override
    public Lang convertFrom(LangDTO langDTO, Lang lang) {
        return Lang.forCode(langDTO.getCode());
    }
}
