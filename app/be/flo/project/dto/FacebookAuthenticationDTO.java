package be.flo.project.dto;

import be.flo.project.dto.technical.DTO;
import be.flo.project.util.constants.ValidationRegex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by florian on 3/05/15.
 */
public class FacebookAuthenticationDTO extends DTO {

    @NotNull(message = "--.validation.dto.notNull")
    private String firstname;

    @NotNull(message = "--.validation.dto.notNull")
    private String lastname;

    @NotNull(message = "--.validation.dto.notNull")
    private Long userId;

    @NotNull(message = "--.validation.dto.notNull")
    private String token;

    @Pattern(regexp = ValidationRegex.EMAIL,message = "--.validation.dto.email")
    private String email;
    private LangDTO lang;
    private String gender;

    public FacebookAuthenticationDTO() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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


    public LangDTO getLang() {
        return lang;
    }

    public void setLang(LangDTO lang) {
        this.lang = lang;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "FacebookAuthenticationDTO{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
