package pl.kuklinski.clientsManagement.utils.converters;

import pl.kuklinski.clientsManagement.database.models.AccountStatus;
import pl.kuklinski.clientsManagement.modelFX.AccountStatusFX;

public class AccountStatusConverter {

    public static AccountStatusFX convertToAccStatusFX(AccountStatus accountStatus) {
        AccountStatusFX accountStatusFX = new AccountStatusFX();
        accountStatusFX.setId(accountStatus.getId());
        accountStatusFX.setAccountStatus(accountStatus.getTitle());
        return accountStatusFX;
    }

    public static AccountStatus convertToAccStatus(AccountStatusFX accountStatusFX) {
        AccountStatus accountStatus = new AccountStatus();
        accountStatus.setId(accountStatusFX.getId());
        accountStatus.setTitle(accountStatusFX.getAccountStatus());
        return accountStatus;
    }
}
