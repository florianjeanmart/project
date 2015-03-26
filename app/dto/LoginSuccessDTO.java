package dto;

import dto.technical.DTO;

/**
 * Created by florian on 11/11/14.
 */
public class LoginSuccessDTO extends DTO {

    private AccountDTO myself;
    private String authenticationKey;

    public LoginSuccessDTO() {
    }

    public AccountDTO getMyself() {
        return myself;
    }

    public void setMyself(AccountDTO myself) {
        this.myself = myself;
    }

    public String getAuthenticationKey() {
        return authenticationKey;
    }

    public void setAuthenticationKey(String authenticationKey) {
        this.authenticationKey = authenticationKey;
    }

    @Override
    public String toString() {
        return "LoginSuccessDTO{" +
                "myself=" + myself +
                ", authenticationKey='" + authenticationKey + '\'' +
                '}';
    }
}
