package converter;

import dto.AccountDTO;
import models.entities.Account;

/**
 * Created by florian on 11/11/14.
 */
public class AccountToAccountDTOConverter implements ConverterInterface<Account, AccountDTO>{

    public AccountDTO convert(Account account) {
        AccountDTO dto = new AccountDTO();

        dto.setId(account.getId());
        dto.setMale(account.getMale());
        dto.setEmail(account.getEmail());
        dto.setFirstname(account.getFirstname());
        dto.setLastname(account.getLastname());
        dto.setIsAdmin(account.getIsAdmin());
        dto.setKeepSessionOpen(account.isKeepSessionOpen());
        dto.setLanguageCode(account.getLanguage().code());

        return dto;
    }
}
