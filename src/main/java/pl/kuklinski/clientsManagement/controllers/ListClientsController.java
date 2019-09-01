package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
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
        bindingTableView();
    }


    private void bindingTableView() {
        this.clientsTableView.setItems(this.listClientsModel.getClientFXObservableList());
        setValues();
        setCells();

        this.clientsTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.listClientsModel.setClientFXObjectPropertyEdit(newValue);
        });

    }

    private void setCells() {
        this.nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.surnameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.phoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.clickAmountColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.cityColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.peselColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.incomeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.adviserColumn.setCellFactory(ComboBoxTableCell.forTableColumn(this.listClientsModel.getAdviserFXObservableList()));
    }

    private void setValues() {
        this.adviserColumn.setCellValueFactory(new PropertyValueFactory<>("adviser"));
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.surnameColumn.setCellValueFactory(cellData -> cellData.getValue().surnameProperty());
        this.peselColumn.setCellValueFactory(cellData -> cellData.getValue().peselProperty());
        this.clickAmountColumn.setCellValueFactory(cellData -> cellData.getValue().clickAmountProperty());
        this.phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
        this.cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        this.incomeColumn.setCellValueFactory(cellData -> cellData.getValue().incomeProperty());
    }

    @FXML
    public void addClient() {
        FXMLUtils.showPopUp(CLIENT_PANE_FXML);
    }

    @FXML
    public void editName(TableColumn.CellEditEvent<ClientFX, String> event) {
        this.listClientsModel.getClientFXObjectPropertyEdit().setName(event.getNewValue());
        this.listClientsModel.updateInDataBase();
    }

    @FXML
    public void editSurname(TableColumn.CellEditEvent<ClientFX, String> event) {
        this.listClientsModel.getClientFXObjectPropertyEdit().setSurname(event.getNewValue());
        this.listClientsModel.updateInDataBase();
    }

    @FXML
    public void editPesel(TableColumn.CellEditEvent<ClientFX, String> event) {
        this.listClientsModel.getClientFXObjectPropertyEdit().setPesel(event.getNewValue());
        this.listClientsModel.updateInDataBase();
    }

    @FXML
    public void editClickAmount(TableColumn.CellEditEvent<ClientFX, String> event) {
        this.listClientsModel.getClientFXObjectPropertyEdit().setClickAmount(event.getNewValue());
        this.listClientsModel.updateInDataBase();
    }

    @FXML
    public void editPhone(TableColumn.CellEditEvent<ClientFX, String> event) {
        this.listClientsModel.getClientFXObjectPropertyEdit().setPhone(event.getNewValue());
        this.listClientsModel.updateInDataBase();
    }

    @FXML
    public void editCity(TableColumn.CellEditEvent<ClientFX, String> event) {
        this.listClientsModel.getClientFXObjectPropertyEdit().setCity(event.getNewValue());
        this.listClientsModel.updateInDataBase();
    }

    @FXML
    public void editIncome(TableColumn.CellEditEvent<ClientFX, String> event) {
        this.listClientsModel.getClientFXObjectPropertyEdit().setIncome(event.getNewValue());
        this.listClientsModel.updateInDataBase();
    }

    @FXML
    public void editAdviser(TableColumn.CellEditEvent<ClientFX, AdviserFX> event) {
        event.getRowValue().setAdviser(event.getNewValue());
        listClientsModel.updateInDataBase();
    }
}
