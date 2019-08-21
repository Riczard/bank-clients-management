package pl.kuklinski.clientsManagement.modelFX;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AccountStateFX {

    private StringProperty accountState = new SimpleStringProperty();

    public String getAccountState() {
        return accountState.get();
    }

    public StringProperty accountStateProperty() {
        return accountState;
    }

    public void setAccountState(String accountState) {
        this.accountState.set(accountState);
    }
}
