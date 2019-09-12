package pl.kuklinski.clientsManagement.javaFX.modelFX;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FilterFX {

    private SimpleStringProperty generalFilter = new SimpleStringProperty();
    private ObjectProperty<RelationFX> relationFx = new SimpleObjectProperty<>();
    private ObjectProperty<OfferStatusFX> offerStatusFx = new SimpleObjectProperty<>();
    private ObjectProperty<ContactStatusFX> contactStatusFx = new SimpleObjectProperty<>();
    private SimpleStringProperty consolidationAmount = new SimpleStringProperty();
    private SimpleStringProperty clickAmount = new SimpleStringProperty();
    private SimpleStringProperty source = new SimpleStringProperty();

    public String getGeneralFilter() {
        return generalFilter.get();
    }

    public SimpleStringProperty generalFilterProperty() {
        return generalFilter;
    }

    public void setGeneralFilter(String generalFilter) {
        this.generalFilter.set(generalFilter);
    }

    public RelationFX getRelationFx() {
        return relationFx.get();
    }

    public ObjectProperty<RelationFX> relationFxProperty() {
        return relationFx;
    }

    public void setRelationFx(RelationFX relationFx) {
        this.relationFx.set(relationFx);
    }

    public OfferStatusFX getOfferStatusFx() {
        return offerStatusFx.get();
    }

    public ObjectProperty<OfferStatusFX> offerStatusFxProperty() {
        return offerStatusFx;
    }

    public void setOfferStatusFx(OfferStatusFX offerStatusFx) {
        this.offerStatusFx.set(offerStatusFx);
    }

    public ContactStatusFX getContactStatusFx() {
        return contactStatusFx.get();
    }

    public ObjectProperty<ContactStatusFX> contactStatusFxProperty() {
        return contactStatusFx;
    }

    public void setContactStatusFx(ContactStatusFX contactStatusFx) {
        this.contactStatusFx.set(contactStatusFx);
    }

    public String getConsolidationAmount() {
        return consolidationAmount.get();
    }

    public SimpleStringProperty consolidationAmountProperty() {
        return consolidationAmount;
    }

    public void setConsolidationAmount(String consolidationAmount) {
        this.consolidationAmount.set(consolidationAmount);
    }

    public String getClickAmount() {
        return clickAmount.get();
    }

    public SimpleStringProperty clickAmountProperty() {
        return clickAmount;
    }

    public void setClickAmount(String clickAmount) {
        this.clickAmount.set(clickAmount);
    }

    public String getSource() {
        return source.get();
    }

    public SimpleStringProperty sourceProperty() {
        return source;
    }

    public void setSource(String source) {
        this.source.set(source);
    }
}
