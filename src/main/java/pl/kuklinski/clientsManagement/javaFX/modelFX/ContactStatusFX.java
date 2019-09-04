package pl.kuklinski.clientsManagement.javaFX.modelFX;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ContactStatusFX {

    private LongProperty id = new SimpleLongProperty();
    private StringProperty contactStatus = new SimpleStringProperty();

    public String getContactStatus() {
        return contactStatus.get();
    }

    public StringProperty contactStatusProperty() {
        return contactStatus;
    }

    public void setContactStatus(String contactStatus) {
        this.contactStatus.set(contactStatus);
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
        return contactStatusProperty().get();
    }
}
