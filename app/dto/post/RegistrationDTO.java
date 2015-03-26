package dto.post;

import dto.technical.DTO;
import dto.technical.verification.NotNull;
import dto.technical.verification.Pattern;
import org.hibernate.validator.constraints.Email;
import util.ErrorMessage;


/**
 * Created by florian on 11/11/14.
 */
public class RegistrationDTO extends DTO {

    @NotNull
    private Boolean male;

    @Pattern(regexp = ".{2,50}",message = ErrorMessage.VALIDATION_SIZE)
    private String firstname;

    @Pattern(regexp = ".{2,50}",message = ErrorMessage.VALIDATION_SIZE)
    private String lastname;

    @Pattern(regexp = Pattern.EMAIL,message = ErrorMessage.VALIDATION_EMAIL)
    private String email;

    @Pattern(regexp = "[a-zA-Z0-9-_]{6,18}",message = ErrorMessage.VALIDATION_PASSWORD)
    private String password;

    private String lang;

    private Boolean keepSessionOpen;

    public Boolean getMale() {
        return male;
    }

    public void setMale(Boolean male) {
        this.male = male;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setKeepSessionOpen(Boolean keepSessionOpen) {
        this.keepSessionOpen = keepSessionOpen;
    }

    public Boolean getKeepSessionOpen() {
        return keepSessionOpen;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "male=" + male +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", lang='" + lang + '\'' +
                ", keepSessionOpen=" + keepSessionOpen +
                '}';
    }
}
