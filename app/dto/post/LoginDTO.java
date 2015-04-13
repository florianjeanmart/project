package dto.post;

import dto.technical.DTO;
import play.data.validation.Constraints;
import util.ErrorMessage;
import util.constants.ValidationRegex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


/**
 * Created by florian on 10/11/14.
 */
public class LoginDTO extends DTO {

    @NotNull(message = "validation.dto.notNull")
    @Pattern(regexp = ValidationRegex.EMAIL,message = "validation.dto.email")
    private String email;

    @NotNull(message = "validation.dto.notNull")
    @Pattern(regexp = ValidationRegex.PASSWORD,message = "validation.dto.password")
    private String password;

    private Boolean keepSessionOpen;

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

    public Boolean getKeepSessionOpen() {
        return keepSessionOpen;
    }

    public void setKeepSessionOpen(Boolean keepSessionOpen) {
        this.keepSessionOpen = keepSessionOpen;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", keepSessionOpen=" + keepSessionOpen +
                '}';
    }
}
