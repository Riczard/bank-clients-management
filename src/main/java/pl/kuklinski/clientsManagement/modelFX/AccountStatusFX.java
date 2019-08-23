package pl.kuklinski.clientsManagement.modelFX;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AccountStatusFX {

    private LongProperty id = new SimpleLongProperty();
    private StringProperty accountStatus = new SimpleStringProperty();

    public String getAccountStatus() {
        return accountStatus.get();
    }

    public StringProperty accountStatusProperty() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus.set(accountStatus);
    }

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    @Override
    public String toString() {
        return accountStatusProperty().get();
    }
}
