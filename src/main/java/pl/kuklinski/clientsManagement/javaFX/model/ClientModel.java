package pl.kuklinski.clientsManagement.javaFX.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.kuklinski.clientsManagement.database.dao.*;
import pl.kuklinski.clientsManagement.database.models.*;
import pl.kuklinski.clientsManagement.javaFX.modelFX.*;
import pl.kuklinski.clientsManagement.utils.converters.AccountStatusConverter;
import pl.kuklinski.clientsManagement.utils.converters.AdviserConverter;
import pl.kuklinski.clientsManagement.utils.converters.ClientConverter;

import java.util.stream.Stream;

public class ClientModel {

    private ObjectProperty<ClientFX> clientFXObjectProperty = new SimpleObjectProperty<>(new ClientFX());
    private ObservableList<AdviserFX> adviserFXES = FXCollections.observableArrayList();
    private ObservableList<ContactStatusFX> contactStatusFXES = FXCollections.observableArrayList();
    private ObservableList<OfferStatusFX> offerStatusFXES = FXCollections.observableArrayList();
    private ObservableList<RelationFX> relationFXES = FXCollections.observableArrayList();


    public void init() {
        initAdviserList();
        initContactStatusList();
        initOfferStatusList();
        initRelationList();
    }

    private void initAdviserList() {
        adviserFXES.clear();
        AdviserDao adviserDao = new AdviserDao();
        Stream<Adviser> adviserStream = adviserDao.queryForAll(Adviser.class);
        adviserStream.forEach(adviser -> {
            AdviserFX adviserFX = AdviserConverter.convertToAdviserFx(adviser);
            adviserFXES.add(adviserFX);
        });
        adviserDao.closeConnection();
    }

    private void initContactStatusList() {
        contactStatusFXES.clear();
        ContactStatusDao statusDao = new ContactStatusDao();
        Stream<ContactStatus> statusStream = statusDao.queryForAll(ContactStatus.class);
        statusStream.forEach(status -> {
            ContactStatusFX statusFX = AccountStatusConverter.convertToAccStatusFX(status);
            contactStatusFXES.add(statusFX);
        });
        statusDao.closeConnection();
    }

    private void initOfferStatusList() {
        offerStatusFXES.clear();
        OfferStatusDao statusDao = new OfferStatusDao();
        Stream<OfferStatus> offerStatusStream = statusDao.queryForAll(OfferStatus.class);
        offerStatusStream.forEach(status -> {
            OfferStatusFX offerStatusFX = OfferStatusConverter.convertToOfferStatusFX(status);
            offerStatusFXES.add(offerStatusFX);
        });
        statusDao.closeConnection();
    }

    private void initRelationList() {
        relationFXES.clear();
        RelationDao relationDao = new RelationDao();
        Stream<Relation> relationStream = relationDao.queryForAll(Relation.class);
        relationStream.forEach(relation -> {
            RelationFX relationFX = RelationConverter.convertToRelationFX(relation);
            relationFXES.add(relationFX);
        });
        relationDao.closeConnection();
    }

    public void saveClientInDataBase() {
        Client client = ClientConverter.convertToClient(this.getClientFXObjectProperty());
        ClientDao clientDao = new ClientDao();
        clientDao.update(client);
        clientDao.closeConnection();
    }

    public ClientFX getClientFXObjectProperty() {
        return clientFXObjectProperty.get();
    }

    public ObjectProperty<ClientFX> clientFXObjectProperty() {
        return clientFXObjectProperty;
    }

    public void setClientFXObjectProperty(ClientFX clientFXObjectProperty) {
        this.clientFXObjectProperty.set(clientFXObjectProperty);
    }

    public ObservableList<AdviserFX> getAdviserFXES() {
        return adviserFXES;
    }

    public void setAdviserFXES(ObservableList<AdviserFX> adviserFXES) {
        this.adviserFXES = adviserFXES;
    }

    public ObservableList<ContactStatusFX> getContactStatusFXES() {
        return contactStatusFXES;
    }

    public void setContactStatusFXES(ObservableList<ContactStatusFX> contactStatusFXES) {
        this.contactStatusFXES = contactStatusFXES;
    }

    public ObservableList<OfferStatusFX> getOfferStatusFXES() {
        return offerStatusFXES;
    }

    public void setOfferStatusFXES(ObservableList<OfferStatusFX> offerStatusFXES) {
        this.offerStatusFXES = offerStatusFXES;
    }

    public ObservableList<RelationFX> getRelationFXES() {
        return relationFXES;
    }

    public void setRelationFXES(ObservableList<RelationFX> relationFXES) {
        this.relationFXES = relationFXES;
    }
}
