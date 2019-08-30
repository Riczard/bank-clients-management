package pl.kuklinski.clientsManagement.modelFX;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.kuklinski.clientsManagement.database.dao.AdviserDao;
import pl.kuklinski.clientsManagement.database.dao.ClientDao;
import pl.kuklinski.clientsManagement.database.models.Adviser;
import pl.kuklinski.clientsManagement.database.models.Client;
import pl.kuklinski.clientsManagement.utils.converters.AdviserConverter;
import pl.kuklinski.clientsManagement.utils.converters.ClientConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ListClientsModel {

    private ObservableList<ClientFX> clientFXObservableList = FXCollections.observableArrayList();
    private ObservableList<AdviserFX> adviserFXObservableList = FXCollections.observableArrayList();
    private ObservableList<AccountStatusFX> accStatusFXObservableList = FXCollections.observableArrayList();

    private ObjectProperty<AdviserFX> adviserFXObjectProperty = new SimpleObjectProperty<>();
    private ObjectProperty<AccountStatusFX> accountStatusFXObjectProperty = new SimpleObjectProperty<>();
    private List<ClientFX> clientFXList = new ArrayList<>();

    public void init() {
        clientFXList.clear();
        initClientFxList();
        initAdvisers();
    }

    private void initAdvisers() {
        adviserFXObservableList.clear();
        AdviserDao adviserDao = new AdviserDao();
        Stream<Adviser> adviserStream = adviserDao.queryForAll(Adviser.class);
        adviserStream.forEach(a -> {
            AdviserFX adviserFX = AdviserConverter.convertToAdviserFx(a);
            adviserFXObservableList.add(adviserFX);
        });
        adviserDao.closeConnection();
    }

    private void initClientFxList() {
        ClientDao clientDao = new ClientDao();
        Stream<Client> clientStream = clientDao.queryForAll(Client.class);
        clientStream.forEach(client -> this.clientFXList.add(ClientConverter.convertToClientFX(client)));
        this.clientFXObservableList.setAll(clientFXList);
        clientDao.closeConnection();
    }

    public void updateInDataBase(ClientFX clientFX) {
        ClientDao clientDao = new ClientDao();
        clientDao.update(ClientConverter.convertToClient(clientFX));
        clientDao.closeConnection();
    }

    public ObservableList<ClientFX> getClientFXObservableList() {
        return clientFXObservableList;
    }

    public void setClientFXObservableList(ObservableList<ClientFX> clientFXObservableList) {
        this.clientFXObservableList = clientFXObservableList;
    }

    public ObservableList<AdviserFX> getAdviserFXObservableList() {
        return adviserFXObservableList;
    }

    public void setAdviserFXObservableList(ObservableList<AdviserFX> adviserFXObservableList) {
        this.adviserFXObservableList = adviserFXObservableList;
    }

    public ObservableList<AccountStatusFX> getAccStatusFXObservableList() {
        return accStatusFXObservableList;
    }

    public void setAccStatusFXObservableList(ObservableList<AccountStatusFX> accStatusFXObservableList) {
        this.accStatusFXObservableList = accStatusFXObservableList;
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

    public AccountStatusFX getAccountStatusFXObjectProperty() {
        return accountStatusFXObjectProperty.get();
    }

    public ObjectProperty<AccountStatusFX> accountStatusFXObjectProperty() {
        return accountStatusFXObjectProperty;
    }

    public void setAccountStatusFXObjectProperty(AccountStatusFX accountStatusFXObjectProperty) {
        this.accountStatusFXObjectProperty.set(accountStatusFXObjectProperty);
    }

    public List<ClientFX> getClientFXList() {
        return clientFXList;
    }

    public void setClientFXList(List<ClientFX> clientFXList) {
        this.clientFXList = clientFXList;
    }
}
