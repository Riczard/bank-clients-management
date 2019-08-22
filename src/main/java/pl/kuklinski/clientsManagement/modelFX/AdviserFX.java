package pl.kuklinski.clientsManagement.modelFX;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AdviserFX {

    private StringProperty name = new SimpleStringProperty();
    private StringProperty surname = new SimpleStringProperty();

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }
}
