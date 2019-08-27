package pl.kuklinski.clientsManagement.modelFX;

import javafx.beans.property.*;

import java.time.LocalDate;

public class ClientFX {

    private LongProperty id = new SimpleLongProperty();
    private StringProperty name = new SimpleStringProperty();
    private StringProperty surname = new SimpleStringProperty();
    private StringProperty city = new SimpleStringProperty();
    private StringProperty phone = new SimpleStringProperty();
    private StringProperty status = new SimpleStringProperty();
    private StringProperty pesel = new SimpleStringProperty();
    private StringProperty income = new SimpleStringProperty();
    private StringProperty relation = new SimpleStringProperty();
    private StringProperty clickAmount = new SimpleStringProperty();
    private StringProperty comment = new SimpleStringProperty();
    private ObjectProperty<AccountStatusFX> accountState = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> lastContactDate = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> verificationDate = new SimpleObjectProperty<>();
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

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
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

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
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

    public String getIncome() {
        return income.get();
    }

    public StringProperty incomeProperty() {
        return income;
    }

    public void setIncome(String income) {
        this.income.set(income);
    }

    public String getRelation() {
        return relation.get();
    }

    public StringProperty relationProperty() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation.set(relation);
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

    public String getComment() {
        return comment.get();
    }

    public StringProperty commentProperty() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment.set(comment);
    }

    public AccountStatusFX getAccountState() {
        return accountState.get();
    }

    public ObjectProperty<AccountStatusFX> accountStateProperty() {
        return accountState;
    }

    public void setAccountState(AccountStatusFX accountState) {
        this.accountState.set(accountState);
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

    public LocalDate getVerificationDate() {
        return verificationDate.get();
    }

    public ObjectProperty<LocalDate> verificationDateProperty() {
        return verificationDate;
    }

    public void setVerificationDate(LocalDate verificationDate) {
        this.verificationDate.set(verificationDate);
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
