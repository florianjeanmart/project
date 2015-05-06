package be.flo.project.dto;

import be.flo.project.dto.technical.DTO;
import be.flo.project.model.entities.Account;
import be.flo.project.model.entities.technical.AbstractEntity;
import be.flo.project.util.constants.ValidationRegex;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.tools.Diagnostic;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by florian on 3/05/15.
 */
public class FacebookAuthenticationDTO extends DTO {

    @NotNull(message = "--.validation.dto.notNull")
    private Long userId;

    @NotNull(message = "--.validation.dto.notNull")
    private String token;

    @Pattern(regexp = ValidationRegex.EMAIL,message = "--.validation.dto.email")
    private String email;
    private LangDTO lang;

    public FacebookAuthenticationDTO() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "FacebookAuthenticationDTO{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public LangDTO getLang() {
        return lang;
    }

    public void setLang(LangDTO lang) {
        this.lang = lang;
    }
}
