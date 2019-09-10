package pl.kuklinski.clientsManagement.javaFX.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.kuklinski.clientsManagement.database.dao.ContactStatusDao;
import pl.kuklinski.clientsManagement.database.models.ContactStatus;
import pl.kuklinski.clientsManagement.javaFX.modelFX.ContactStatusFX;
import pl.kuklinski.clientsManagement.utils.converters.ContactStatusConverter;

import java.util.stream.Stream;

public class ContactStatusModel {

    private ObjectProperty<ContactStatusFX> contactStatusFXObjectProperty = new SimpleObjectProperty<>(new ContactStatusFX());
    private ObjectProperty<ContactStatusFX> contactStatusFXObjectPropertyEdit = new SimpleObjectProperty<>(new ContactStatusFX());

    private ObservableList<ContactStatusFX> contactStatusFXObservableList = FXCollections.observableArrayList();

    public void init() {
        this.contactStatusFXObservableList.clear();
        addContactStatusToObsList();
    }

    private void addContactStatusToObsList() {
        ContactStatusDao contactStatusDao = new ContactStatusDao();
        Stream<ContactStatus> contactStatusStream = contactStatusDao.queryForAll(ContactStatus.class);
        contactStatusStream.forEach(status -> {
            ContactStatusFX contactStatusFX = ContactStatusConverter.convertToAccStatusFX(status);
            this.contactStatusFXObservableList.add(contactStatusFX);
        });
        contactStatusDao.closeConnection();
    }

    public void saveStatusInDataBase() {
        ContactStatusDao contactStatusDao = new ContactStatusDao();
        ContactStatus contactStatus = ContactStatusConverter.convertToContactStatus(this.getContactStatusFXObjectProperty());
        contactStatusDao.create(contactStatus);
        init();
    }

    public void deleteStatusInDataBase() {
        ContactStatusDao contactStatusDao = new ContactStatusDao();
        contactStatusDao.delete(ContactStatusConverter.convertToContactStatus(this.getContactStatusFXObjectPropertyEdit()));
        contactStatusDao.closeConnection();
        init();
    }

    public void updateStatusInDB() {
        ContactStatusDao contactStatusDao = new ContactStatusDao();
        contactStatusDao.update(ContactStatusConverter.convertToContactStatus(this.getContactStatusFXObjectPropertyEdit()));
        contactStatusDao.closeConnection();
        init();
    }

    public ContactStatusFX getContactStatusFXObjectProperty() {
        return contactStatusFXObjectProperty.get();
    }

    public ObjectProperty<ContactStatusFX> contactStatusFXObjectPropertyy() {
        return contactStatusFXObjectProperty;
    }

    public void setContactStatusFXObjectProperty(ContactStatusFX contactStatusFXObjectProperty) {
        this.contactStatusFXObjectProperty.set(contactStatusFXObjectProperty);
    }

    public ContactStatusFX getContactStatusFXObjectPropertyEdit() {
        return contactStatusFXObjectPropertyEdit.get();
    }

    public ObjectProperty<ContactStatusFX> contactStatusFXObjectPropertyEdit() {
        return contactStatusFXObjectPropertyEdit;
    }

    public void setContactStatusFXObjectPropertyEdit(ContactStatusFX contactStatusFXObjectPropertyEdit) {
        this.contactStatusFXObjectPropertyEdit.set(contactStatusFXObjectPropertyEdit);
    }

    public ObservableList<ContactStatusFX> getContactStatusFXObservableList() {
        return contactStatusFXObservableList;
    }

    public void setContactStatusFXObservableList(ObservableList<ContactStatusFX> contactStatusFXObservableList) {
        this.contactStatusFXObservableList = contactStatusFXObservableList;
    }


}
