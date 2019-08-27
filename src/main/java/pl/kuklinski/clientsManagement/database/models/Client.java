package pl.kuklinski.clientsManagement.database.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Client implements BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String city;

    @Column
    private int phone;

    @JoinColumn
    @ManyToOne
    private AccountStatus status;

    @Column
    private String income;

    @Column
    private String relation;

    @Column
    private String clickAmount;

    @Column
    private String comment;

    @Column
    private LocalDate lastContactDate;

    @Column
    private LocalDate verificationDate;

    @ManyToOne
    private Adviser adviser;

    public Client() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getClickAmount() {
        return clickAmount;
    }

    public void setClickAmount(String clickAmount) {
        this.clickAmount = clickAmount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getLastContactDate() {
        return lastContactDate;
    }

    public void setLastContactDate(LocalDate lastContactDate) {
        this.lastContactDate = lastContactDate;
    }

    public LocalDate getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(LocalDate verificationDate) {
        this.verificationDate = verificationDate;
    }

    public Adviser getAdviser() {
        return adviser;
    }

    public void setAdviser(Adviser adviser) {
        this.adviser = adviser;
    }
}
