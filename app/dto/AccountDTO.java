package dto;

import dto.technical.DTO;
import util.ErrorMessage;
import util.constants.ValidationRegex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by florian on 11/11/14.
 */
public class AccountDTO extends DTO {

    private Long id;

    @NotNull(message = "validation.dto.notNull")
    private Boolean male;

    @NotNull(message = "validation.dto.notNull")
    @Size(min = 2,max =50,message = "validation.dto.size")
    private String firstname;

    @NotNull(message = "validation.dto.notNull")
    @Size(min = 2,max =50,message = "validation.dto.size")
    private String lastname;

    @NotNull(message = "validation.dto.notNull")
    @Pattern(regexp = ValidationRegex.EMAIL,message = "validation.dto.message")
    private String email;

    private Boolean isAdmin;

    private String languageCode;

    private Boolean keepSessionOpen;

    public AccountDTO() {
    }

    public Boolean getMale() {
        return male;
    }

    public void setMale(Boolean male) {
        this.male = male;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public Boolean getKeepSessionOpen() {
        return keepSessionOpen;
    }

    public void setKeepSessionOpen(Boolean keepSessionOpen) {
        this.keepSessionOpen = keepSessionOpen;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin=" + isAdmin +
                ", languageCode='" + languageCode + '\'' +
                ", keepSessionOpen=" + keepSessionOpen +
                '}';
    }
}
