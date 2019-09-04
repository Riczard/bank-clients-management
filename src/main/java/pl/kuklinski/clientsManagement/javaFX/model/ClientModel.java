package pl.kuklinski.clientsManagement.javaFX.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.kuklinski.clientsManagement.database.dao.AdviserDao;
import pl.kuklinski.clientsManagement.database.dao.ClientDao;
import pl.kuklinski.clientsManagement.database.dao.ContactStatusDao;
import pl.kuklinski.clientsManagement.database.dao.OfferStatusDao;
import pl.kuklinski.clientsManagement.database.models.Adviser;
import pl.kuklinski.clientsManagement.database.models.Client;
import pl.kuklinski.clientsManagement.database.models.ContactStatus;
import pl.kuklinski.clientsManagement.database.models.OfferStatus;
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
