package converter;

import dto.LoginSuccessDTO;
import models.entities.*;

/**
 * Created by florian on 11/11/14.
 */
public class AccountToLoginSuccessConverter implements ConverterInterface<Account, LoginSuccessDTO> {

    //converter
    private AccountToAccountDTOConverter accountToAccountDTOConverter = new AccountToAccountDTOConverter();


    public LoginSuccessDTO convert(Account account) {

        LoginSuccessDTO dto = new LoginSuccessDTO();

        dto.setMyself(accountToAccountDTOConverter.convert(account));
        dto.setAuthenticationKey(account.getAuthenticationKey());

        return dto;
    }
}
