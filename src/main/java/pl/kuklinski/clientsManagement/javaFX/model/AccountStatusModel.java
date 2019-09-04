package pl.kuklinski.clientsManagement.javaFX.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.kuklinski.clientsManagement.database.dao.AccountStatusDao;
import pl.kuklinski.clientsManagement.database.models.ContactStatus;
import pl.kuklinski.clientsManagement.javaFX.modelFX.AccountStatusFX;
import pl.kuklinski.clientsManagement.utils.converters.AccountStatusConverter;

import java.util.stream.Stream;

public class AccountStatusModel {

    private ObjectProperty<AccountStatusFX> accountStatusFXObjectProperty = new SimpleObjectProperty<>(new AccountStatusFX());
    private ObjectProperty<AccountStatusFX> accountStatusFXObjectPropertyEdit = new SimpleObjectProperty<>(new AccountStatusFX());

    private ObservableList<AccountStatusFX> accountStatusFXObservableList = FXCollections.observableArrayList();

    public void init() {
        this.accountStatusFXObservableList.clear();
        addAccStatusToObservableList();
    }

    private void addAccStatusToObservableList() {
        AccountStatusDao accountStatusDao = new AccountStatusDao();
        Stream<ContactStatus> accStatusStream = accountStatusDao.queryForAll(ContactStatus.class);
        accStatusStream.forEach(status -> {
            AccountStatusFX accountStatusFX = AccountStatusConverter.convertToAccStatusFX(status);
            this.accountStatusFXObservableList.add(accountStatusFX);
        });
        accountStatusDao.closeConnection();
    }

    public void saveStatusInDataBase() {
        AccountStatusDao accountStatusDao = new AccountStatusDao();
        ContactStatus contactStatus = AccountStatusConverter.convertToAccStatus(this.getAccountStatusFXObjectProperty());
        accountStatusDao.create(contactStatus);
        init();
    }

    public void deleteStatusInDataBase() {
        AccountStatusDao accountStatusDao = new AccountStatusDao();
        accountStatusDao.delete(AccountStatusConverter.convertToAccStatus(this.getAccountStatusFXObjectPropertyEdit()));
        accountStatusDao.closeConnection();
        init();
    }

    public void updateStatusInDB() {
        AccountStatusDao accountStatusDao = new AccountStatusDao();
        accountStatusDao.update(AccountStatusConverter.convertToAccStatus(this.getAccountStatusFXObjectPropertyEdit()));
        accountStatusDao.closeConnection();
        init();
    }

    public AccountStatusFX getAccountStatusFXObjectProperty() {
        return accountStatusFXObjectProperty.get();
    }

    public ObjectProperty<AccountStatusFX> accountStatusFXObjectPropertyy() {
        return accountStatusFXObjectProperty;
    }

    public void setAccountStatusFXObjectProperty(AccountStatusFX accountStatusFXObjectProperty) {
        this.accountStatusFXObjectProperty.set(accountStatusFXObjectProperty);
    }

    public AccountStatusFX getAccountStatusFXObjectPropertyEdit() {
        return accountStatusFXObjectPropertyEdit.get();
    }

    public ObjectProperty<AccountStatusFX> accountStatusFXObjectPropertyEdit() {
        return accountStatusFXObjectPropertyEdit;
    }

    public void setAccountStatusFXObjectPropertyEdit(AccountStatusFX accountStatusFXObjectPropertyEdit) {
        this.accountStatusFXObjectPropertyEdit.set(accountStatusFXObjectPropertyEdit);
    }

    public ObservableList<AccountStatusFX> getAccountStatusFXObservableList() {
        return accountStatusFXObservableList;
    }

    public void setAccountStatusFXObservableList(ObservableList<AccountStatusFX> accountStatusFXObservableList) {
        this.accountStatusFXObservableList = accountStatusFXObservableList;
    }


}
