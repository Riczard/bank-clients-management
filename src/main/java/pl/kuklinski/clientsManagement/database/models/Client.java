package pl.kuklinski.clientsManagement.database.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Client")
public class Client implements BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private String pesel;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String phone;
    @ManyToOne
    private OfferStatus offerStatus;
    @ManyToOne
    private Relation relation;
    @ManyToOne
    private ContactStatus status;
    @Column
    private LocalDate lastContactDate;
    @Column
    private LocalDate plannedContactDate;
    @Column
    private String comment;
    @Column
    private String incomeType;
    @Column
    private LocalDate verificationDate;
    @Column
    private String clickAmount;
    @Column
    private String consolidationAmount;
    @Column
    private String city;
    @Column
    private String source;
    @ManyToOne
    @JoinColumn(name = "adviser_id")
    private Adviser adviser;

    public Client() {
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public OfferStatus getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(OfferStatus offerStatus) {
        this.offerStatus = offerStatus;
    }

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    public ContactStatus getStatus() {
        return status;
    }

    public void setStatus(ContactStatus status) {
        this.status = status;
    }

    public LocalDate getLastContactDate() {
        return lastContactDate;
    }

    public void setLastContactDate(LocalDate lastContactDate) {
        this.lastContactDate = lastContactDate;
    }

    public LocalDate getPlannedContactDate() {
        return plannedContactDate;
    }

    public void setPlannedContactDate(LocalDate plannedContactDate) {
        this.plannedContactDate = plannedContactDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

    public LocalDate getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(LocalDate verificationDate) {
        this.verificationDate = verificationDate;
    }

    public String getClickAmount() {
        return clickAmount;
    }

    public void setClickAmount(String clickAmount) {
        this.clickAmount = clickAmount;
    }

    public String getConsolidationAmount() {
        return consolidationAmount;
    }

    public void setConsolidationAmount(String consolidationAmount) {
        this.consolidationAmount = consolidationAmount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Adviser getAdviser() {
        return adviser;
    }

    public void setAdviser(Adviser adviser) {
        this.adviser = adviser;
    }
}
