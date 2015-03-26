package dto;

import dto.technical.DTO;
import dto.technical.verification.NotNull;
import dto.technical.verification.Pattern;
import dto.technical.verification.Size;
import util.ErrorMessage;

/**
 * Created by florian on 11/11/14.
 */
public class AccountDTO extends DTO {

    private Long id;

    @NotNull
    private Boolean male;

    @NotNull
    @Size(min = 2,max =50)
    private String firstname;

    @NotNull
    @Size(min = 2,max =50)
    private String lastname;

    @NotNull
    @Pattern(regexp = Pattern.EMAIL,message = ErrorMessage.VALIDATION_EMAIL)
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
