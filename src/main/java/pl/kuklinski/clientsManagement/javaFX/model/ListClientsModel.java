package pl.kuklinski.clientsManagement.javaFX.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.kuklinski.clientsManagement.database.dao.AdviserDao;
import pl.kuklinski.clientsManagement.database.dao.ClientDao;
import pl.kuklinski.clientsManagement.database.models.Adviser;
import pl.kuklinski.clientsManagement.database.models.Client;
import pl.kuklinski.clientsManagement.javaFX.modelFX.*;
import pl.kuklinski.clientsManagement.utils.converters.AdviserConverter;
import pl.kuklinski.clientsManagement.utils.converters.ClientConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ListClientsModel {

    private ObservableList<ClientFX> clientFXES = FXCollections.observableArrayList();
    private ObservableList<AdviserFX> adviserFXES = FXCollections.observableArrayList();
    private ObservableList<ContactStatusFX> contactStatusFXES = FXCollections.observableArrayList();
    private ObservableList<OfferStatusFX> offerStatusFXES = FXCollections.observableArrayList();
    private ObservableList<RelationFX> relationFXES = FXCollections.observableArrayList();

    private ObjectProperty<ClientFX> clientFXObjectPropertyEdit = new SimpleObjectProperty<>(new ClientFX());
    private ObjectProperty<AdviserFX> adviserFXObjectProperty = new SimpleObjectProperty<>();
    private ObjectProperty<ContactStatusFX> contactStatusFXObjectProperty = new SimpleObjectProperty<>();
    private ObjectProperty<OfferStatusFX> offerStatusFXObjectProperty = new SimpleObjectProperty<>();
    private ObjectProperty<RelationFX> relationFXObjectProperty = new SimpleObjectProperty<>();

    private List<ClientFX> clientFXList = new ArrayList<>();

    public void init() {
        clientFXList.clear();
        initClientFxList();
        initAdvisers();
    }

    private void initAdvisers() {
        adviserFXES.clear();
        AdviserDao adviserDao = new AdviserDao();
        Stream<Adviser> adviserStream = adviserDao.queryForAll(Adviser.class);
        adviserStream.forEach(a -> {
            AdviserFX adviserFX = AdviserConverter.convertToAdviserFx(a);
            adviserFXES.add(adviserFX);
        });
        adviserDao.closeConnection();
    }

    private void initClientFxList() {
        ClientDao clientDao = new ClientDao();
        Stream<Client> clientStream = clientDao.queryForAll(Client.class);
        clientStream.forEach(client -> this.clientFXList.add(ClientConverter.convertToClientFX(client)));
        this.clientFXES.setAll(clientFXList);
        clientDao.closeConnection();
    }

    public void updateInDataBase() {
        ClientDao clientDao = new ClientDao();
        clientDao.update(ClientConverter.convertToClient(this.getClientFXObjectPropertyEdit()));
        clientDao.closeConnection();
    }

    public ObservableList<ClientFX> getClientFXES() {
        return clientFXES;
    }

    public void setClientFXES(ObservableList<ClientFX> clientFXES) {
        this.clientFXES = clientFXES;
    }

    public ObservableList<AdviserFX> getAdviserFXES() {
        return adviserFXES;
    }

    public void setAdviserFXES(ObservableList<AdviserFX> adviserFXES) {
        this.adviserFXES = adviserFXES;
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

    public ClientFX getClientFXObjectPropertyEdit() {
        return clientFXObjectPropertyEdit.get();
    }

    public ObjectProperty<ClientFX> clientFXObjectPropertyEdit() {
        return clientFXObjectPropertyEdit;
    }

    public void setClientFXObjectPropertyEdit(ClientFX clientFXObjectPropertyEdit) {
        this.clientFXObjectPropertyEdit.set(clientFXObjectPropertyEdit);
    }

    public AdviserFX getAdviserFXObjectProperty() {
        return adviserFXObjectProperty.get();
    }

    public ObjectProperty<AdviserFX> adviserFXObjectProperty() {
        return adviserFXObjectProperty;
    }

    public void setAdviserFXObjectProperty(AdviserFX adviserFXObjectProperty) {
        this.adviserFXObjectProperty.set(adviserFXObjectProperty);
    }

    public ContactStatusFX getContactStatusFXObjectProperty() {
        return contactStatusFXObjectProperty.get();
    }

    public ObjectProperty<ContactStatusFX> contactStatusFXObjectProperty() {
        return contactStatusFXObjectProperty;
    }

    public void setContactStatusFXObjectProperty(ContactStatusFX contactStatusFXObjectProperty) {
        this.contactStatusFXObjectProperty.set(contactStatusFXObjectProperty);
    }

    public OfferStatusFX getOfferStatusFXObjectProperty() {
        return offerStatusFXObjectProperty.get();
    }

    public ObjectProperty<OfferStatusFX> offerStatusFXObjectProperty() {
        return offerStatusFXObjectProperty;
    }

    public void setOfferStatusFXObjectProperty(OfferStatusFX offerStatusFXObjectProperty) {
        this.offerStatusFXObjectProperty.set(offerStatusFXObjectProperty);
    }

    public RelationFX getRelationFXObjectProperty() {
        return relationFXObjectProperty.get();
    }

    public ObjectProperty<RelationFX> relationFXObjectProperty() {
        return relationFXObjectProperty;
    }

    public void setRelationFXObjectProperty(RelationFX relationFXObjectProperty) {
        this.relationFXObjectProperty.set(relationFXObjectProperty);
    }

    public List<ClientFX> getClientFXList() {
        return clientFXList;
    }

    public void setClientFXList(List<ClientFX> clientFXList) {
        this.clientFXList = clientFXList;
    }

    public ObservableList<ContactStatusFX> getContactStatusFXES() {
        return contactStatusFXES;
    }

    public void setContactStatusFXES(ObservableList<ContactStatusFX> contactStatusFXES) {
        this.contactStatusFXES = contactStatusFXES;
    }
}
