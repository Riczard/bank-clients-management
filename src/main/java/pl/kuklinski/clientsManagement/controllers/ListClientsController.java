package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.kuklinski.clientsManagement.modelFX.AdviserFX;
import pl.kuklinski.clientsManagement.modelFX.ClientFX;
import pl.kuklinski.clientsManagement.modelFX.ListClientsModel;

public class ListClientsController {

    @FXML
    private TableView<ClientFX> clientsTableView;
    @FXML
    private TableColumn<ClientFX, String> nameColumn;
    @FXML
    private TableColumn<ClientFX, String> surnameColumn;
    @FXML
    private TableColumn<ClientFX, String> peselColumn;
    @FXML
    private TableColumn<ClientFX, String> clickAmountColumn;
    @FXML
    private TableColumn<ClientFX, String> phoneColumn;
    @FXML
    private TableColumn<ClientFX, String> cityColumn;
    @FXML
    private TableColumn<ClientFX, AdviserFX> adviserColumn;
    @FXML
    private TableColumn<ClientFX, String> incomeColumn;
    @FXML
    private TableColumn<ClientFX, String> detailsColumn;

    private ListClientsModel listClientsModel;

    @FXML
    public void initialize() {

    }
}
