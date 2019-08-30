package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.kuklinski.clientsManagement.modelFX.AdviserFX;
import pl.kuklinski.clientsManagement.modelFX.ClientFX;
import pl.kuklinski.clientsManagement.modelFX.ListClientsModel;
import pl.kuklinski.clientsManagement.utils.FXMLUtils;

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

    private final static String CLIENT_PANE_FXML = "/fxml/ClientPane.fxml";

    @FXML
    public void initialize() {
        this.listClientsModel = new ListClientsModel();
        listClientsModel.init();

        setCells();
    }

    private void setCells() {
        this.clientsTableView.setItems(this.listClientsModel.getClientFXObservableList());
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.surnameColumn.setCellValueFactory(cellData -> cellData.getValue().surnameProperty());
        this.peselColumn.setCellValueFactory(cellData -> cellData.getValue().peselProperty());
        this.clickAmountColumn.setCellValueFactory(cellData -> cellData.getValue().clickAmountProperty());
        this.phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
        this.cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        this.incomeColumn.setCellValueFactory(cellData -> cellData.getValue().incomeProperty());

        this.adviserColumn.setCellValueFactory(new PropertyValueFactory<>("adviser"));
        this.adviserColumn.setCellFactory(ComboBoxTableCell.forTableColumn(this.listClientsModel.getAdviserFXObservableList()));
        this.adviserColumn.setOnEditCommit(event -> {
            event.getRowValue().setAdviser(event.getNewValue());
            listClientsModel.updateInDataBase(event.getRowValue());
        });

    }

    public void addClient() {
        FXMLUtils.showPopUp(CLIENT_PANE_FXML);
    }
}
