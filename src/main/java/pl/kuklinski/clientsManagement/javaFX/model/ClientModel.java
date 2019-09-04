package pl.kuklinski.clientsManagement.javaFX.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.kuklinski.clientsManagement.database.dao.AccountStatusDao;
import pl.kuklinski.clientsManagement.database.dao.AdviserDao;
import pl.kuklinski.clientsManagement.database.dao.ClientDao;
import pl.kuklinski.clientsManagement.database.models.ContactStatus;
import pl.kuklinski.clientsManagement.database.models.Adviser;
import pl.kuklinski.clientsManagement.database.models.Client;
import pl.kuklinski.clientsManagement.javaFX.modelFX.AccountStatusFX;
import pl.kuklinski.clientsManagement.javaFX.modelFX.AdviserFX;
import pl.kuklinski.clientsManagement.javaFX.modelFX.ClientFX;
import pl.kuklinski.clientsManagement.utils.converters.AccountStatusConverter;
import pl.kuklinski.clientsManagement.utils.converters.AdviserConverter;
import pl.kuklinski.clientsManagement.utils.converters.ClientConverter;

import java.util.stream.Stream;

public class ClientModel {

    private ObjectProperty<ClientFX> clientFXObjectProperty = new SimpleObjectProperty<>(new ClientFX());
    private ObservableList<AdviserFX> adviserFXObservableList = FXCollections.observableArrayList();
    private ObservableList<AccountStatusFX> accountStatusFXObservableList = FXCollections.observableArrayList();


    public void init() {
        initAdviserList();
        initAccStatusList();
    }

    private void initAdviserList() {
        adviserFXObservableList.clear();
        AdviserDao adviserDao = new AdviserDao();
        Stream<Adviser> adviserStream = adviserDao.queryForAll(Adviser.class);
        adviserStream.forEach(adviser -> {
            AdviserFX adviserFX = AdviserConverter.convertToAdviserFx(adviser);
            adviserFXObservableList.add(adviserFX);
        });
        adviserDao.closeConnection();
    }

    private void initAccStatusList() {
        accountStatusFXObservableList.clear();
        AccountStatusDao statusDao = new AccountStatusDao();
        Stream<ContactStatus> statusStream = statusDao.queryForAll(ContactStatus.class);
        statusStream.forEach(status -> {
            AccountStatusFX statusFX = AccountStatusConverter.convertToAccStatusFX(status);
            accountStatusFXObservableList.add(statusFX);
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

    public ObservableList<AdviserFX> getAdviserFXObservableList() {
        return adviserFXObservableList;
    }

    public void setAdviserFXObservableList(ObservableList<AdviserFX> adviserFXObservableList) {
        this.adviserFXObservableList = adviserFXObservableList;
    }

    public ObservableList<AccountStatusFX> getAccountStatusFXObservableList() {
        return accountStatusFXObservableList;
    }

    public void setAccountStatusFXObservableList(ObservableList<AccountStatusFX> accountStatusFXObservableList) {
        this.accountStatusFXObservableList = accountStatusFXObservableList;
    }
}
