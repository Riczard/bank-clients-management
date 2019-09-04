package pl.kuklinski.clientsManagement.javaFX.modelFX;

import javafx.beans.property.*;

import java.time.LocalDate;

public class ClientFX {

    private LongProperty id = new SimpleLongProperty();
    private StringProperty name = new SimpleStringProperty();
    private StringProperty surname = new SimpleStringProperty();
    private StringProperty pesel = new SimpleStringProperty();
    private StringProperty phone = new SimpleStringProperty();
    private ObjectProperty<OfferStatusFX> offerStatus = new SimpleObjectProperty<>();
    private ObjectProperty<RelationFX> relation = new SimpleObjectProperty<>();
    private ObjectProperty<ContactStatusFX> contactStatus = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> lastContactDate = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> plannedDate = new SimpleObjectProperty<>();
    private StringProperty comment = new SimpleStringProperty();
    private StringProperty incomeType = new SimpleStringProperty();
    private ObjectProperty<LocalDate> verificationDate = new SimpleObjectProperty<>();
    private StringProperty clickAmount = new SimpleStringProperty();
    private StringProperty consolidationAmount = new SimpleStringProperty();
    private StringProperty city = new SimpleStringProperty();
    private ObjectProperty<AdviserFX> adviser = new SimpleObjectProperty<>();

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

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

    public String getPesel() {
        return pesel.get();
    }

    public StringProperty peselProperty() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel.set(pesel);
    }

    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public OfferStatusFX getOfferStatus() {
        return offerStatus.get();
    }

    public ObjectProperty<OfferStatusFX> offerStatusProperty() {
        return offerStatus;
    }

    public void setOfferStatus(OfferStatusFX offerStatus) {
        this.offerStatus.set(offerStatus);
    }

    public RelationFX getRelation() {
        return relation.get();
    }

    public ObjectProperty<RelationFX> relationProperty() {
        return relation;
    }

    public void setRelation(RelationFX relation) {
        this.relation.set(relation);
    }

    public ContactStatusFX getContactStatus() {
        return contactStatus.get();
    }

    public ObjectProperty<ContactStatusFX> contactStatusProperty() {
        return contactStatus;
    }

    public void setContactStatus(ContactStatusFX contactStatus) {
        this.contactStatus.set(contactStatus);
    }

    public LocalDate getLastContactDate() {
        return lastContactDate.get();
    }

    public ObjectProperty<LocalDate> lastContactDateProperty() {
        return lastContactDate;
    }

    public void setLastContactDate(LocalDate lastContactDate) {
        this.lastContactDate.set(lastContactDate);
    }

    public LocalDate getPlannedDate() {
        return plannedDate.get();
    }

    public ObjectProperty<LocalDate> plannedDateProperty() {
        return plannedDate;
    }

    public void setPlannedDate(LocalDate plannedDate) {
        this.plannedDate.set(plannedDate);
    }

    public String getComment() {
        return comment.get();
    }

    public StringProperty commentProperty() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment.set(comment);
    }

    public String getIncomeType() {
        return incomeType.get();
    }

    public StringProperty incomeTypeProperty() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType.set(incomeType);
    }

    public LocalDate getVerificationDate() {
        return verificationDate.get();
    }

    public ObjectProperty<LocalDate> verificationDateProperty() {
        return verificationDate;
    }

    public void setVerificationDate(LocalDate verificationDate) {
        this.verificationDate.set(verificationDate);
    }

    public String getClickAmount() {
        return clickAmount.get();
    }

    public StringProperty clickAmountProperty() {
        return clickAmount;
    }

    public void setClickAmount(String clickAmount) {
        this.clickAmount.set(clickAmount);
    }

    public String getConsolidationAmount() {
        return consolidationAmount.get();
    }

    public StringProperty consolidationAmountProperty() {
        return consolidationAmount;
    }

    public void setConsolidationAmount(String consolidationAmount) {
        this.consolidationAmount.set(consolidationAmount);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public AdviserFX getAdviser() {
        return adviser.get();
    }

    public ObjectProperty<AdviserFX> adviserProperty() {
        return adviser;
    }

    public void setAdviser(AdviserFX adviser) {
        this.adviser.set(adviser);
    }
}
