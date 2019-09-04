package pl.kuklinski.clientsManagement.javaFX.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.kuklinski.clientsManagement.database.dao.ContactStatusDao;
import pl.kuklinski.clientsManagement.database.models.ContactStatus;
import pl.kuklinski.clientsManagement.javaFX.modelFX.ContactStatusFX;
import pl.kuklinski.clientsManagement.utils.converters.AccountStatusConverter;

import java.util.stream.Stream;

public class ContactStatusModel {

    private ObjectProperty<ContactStatusFX> accountStatusFXObjectProperty = new SimpleObjectProperty<>(new ContactStatusFX());
    private ObjectProperty<ContactStatusFX> accountStatusFXObjectPropertyEdit = new SimpleObjectProperty<>(new ContactStatusFX());

    private ObservableList<ContactStatusFX> contactStatusFXObservableList = FXCollections.observableArrayList();

    public void init() {
        this.contactStatusFXObservableList.clear();
        addAccStatusToObservableList();
    }

    private void addAccStatusToObservableList() {
        ContactStatusDao contactStatusDao = new ContactStatusDao();
        Stream<ContactStatus> accStatusStream = contactStatusDao.queryForAll(ContactStatus.class);
        accStatusStream.forEach(status -> {
            ContactStatusFX contactStatusFX = AccountStatusConverter.convertToAccStatusFX(status);
            this.contactStatusFXObservableList.add(contactStatusFX);
        });
        contactStatusDao.closeConnection();
    }

    public void saveStatusInDataBase() {
        ContactStatusDao contactStatusDao = new ContactStatusDao();
        ContactStatus contactStatus = AccountStatusConverter.convertToAccStatus(this.getAccountStatusFXObjectProperty());
        contactStatusDao.create(contactStatus);
        init();
    }

    public void deleteStatusInDataBase() {
        ContactStatusDao contactStatusDao = new ContactStatusDao();
        contactStatusDao.delete(AccountStatusConverter.convertToAccStatus(this.getAccountStatusFXObjectPropertyEdit()));
        contactStatusDao.closeConnection();
        init();
    }

    public void updateStatusInDB() {
        ContactStatusDao contactStatusDao = new ContactStatusDao();
        contactStatusDao.update(AccountStatusConverter.convertToAccStatus(this.getAccountStatusFXObjectPropertyEdit()));
        contactStatusDao.closeConnection();
        init();
    }

    public ContactStatusFX getAccountStatusFXObjectProperty() {
        return accountStatusFXObjectProperty.get();
    }

    public ObjectProperty<ContactStatusFX> accountStatusFXObjectPropertyy() {
        return accountStatusFXObjectProperty;
    }

    public void setAccountStatusFXObjectProperty(ContactStatusFX contactStatusFXObjectProperty) {
        this.accountStatusFXObjectProperty.set(contactStatusFXObjectProperty);
    }

    public ContactStatusFX getAccountStatusFXObjectPropertyEdit() {
        return accountStatusFXObjectPropertyEdit.get();
    }

    public ObjectProperty<ContactStatusFX> accountStatusFXObjectPropertyEdit() {
        return accountStatusFXObjectPropertyEdit;
    }

    public void setAccountStatusFXObjectPropertyEdit(ContactStatusFX contactStatusFXObjectPropertyEdit) {
        this.accountStatusFXObjectPropertyEdit.set(contactStatusFXObjectPropertyEdit);
    }

    public ObservableList<ContactStatusFX> getContactStatusFXObservableList() {
        return contactStatusFXObservableList;
    }

    public void setContactStatusFXObservableList(ObservableList<ContactStatusFX> contactStatusFXObservableList) {
        this.contactStatusFXObservableList = contactStatusFXObservableList;
    }


}
