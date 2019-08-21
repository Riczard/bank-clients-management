package pl.kuklinski.clientsManagement.modelFX;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AdviserFX {

    private StringProperty adviserName = new SimpleStringProperty();

    public String getAdviserName() {
        return adviserName.get();
    }

    public StringProperty adviserNameProperty() {
        return adviserName;
    }

    public void setAdviserName(String adviserName) {
        this.adviserName.set(adviserName);
    }
}
