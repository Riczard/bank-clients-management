package pl.kuklinski.clientsManagement.javaFX.modelFX;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FilterFX {

    private StringProperty generalFilter = new SimpleStringProperty();
    private StringProperty peselFilter = new SimpleStringProperty();
    private StringProperty surnameFilter = new SimpleStringProperty();
    private StringProperty relationFilter = new SimpleStringProperty();
    private StringProperty offerStatusFilter = new SimpleStringProperty();
    private StringProperty contactStatusFilter = new SimpleStringProperty();
    private StringProperty sourceFilter = new SimpleStringProperty();

    public String getGeneralFilter() {
        return generalFilter.get();
    }

    public StringProperty generalFilterProperty() {
        return generalFilter;
    }

    public void setGeneralFilter(String generalFilter) {
        this.generalFilter.set(generalFilter);
    }

    public String getPeselFilter() {
        return peselFilter.get();
    }

    public StringProperty peselFilterProperty() {
        return peselFilter;
    }

    public void setPeselFilter(String peselFilter) {
        this.peselFilter.set(peselFilter);
    }

    public String getSurnameFilter() {
        return surnameFilter.get();
    }

    public StringProperty surnameFilterProperty() {
        return surnameFilter;
    }

    public void setSurnameFilter(String surnameFilter) {
        this.surnameFilter.set(surnameFilter);
    }

    public String getRelationFilter() {
        return relationFilter.get();
    }

    public StringProperty relationFilterProperty() {
        return relationFilter;
    }

    public void setRelationFilter(String relationFilter) {
        this.relationFilter.set(relationFilter);
    }

    public String getOfferStatusFilter() {
        return offerStatusFilter.get();
    }

    public StringProperty offerStatusFilterProperty() {
        return offerStatusFilter;
    }

    public void setOfferStatusFilter(String offerStatusFilter) {
        this.offerStatusFilter.set(offerStatusFilter);
    }

    public String getContactStatusFilter() {
        return contactStatusFilter.get();
    }

    public StringProperty contactStatusFilterProperty() {
        return contactStatusFilter;
    }

    public void setContactStatusFilter(String contactStatusFilter) {
        this.contactStatusFilter.set(contactStatusFilter);
    }

    public String getSourceFilter() {
        return sourceFilter.get();
    }

    public StringProperty sourceFilterProperty() {
        return sourceFilter;
    }

    public void setSourceFilter(String sourceFilter) {
        this.sourceFilter.set(sourceFilter);
    }
}
