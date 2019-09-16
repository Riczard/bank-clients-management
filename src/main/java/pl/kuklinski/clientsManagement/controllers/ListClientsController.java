package pl.kuklinski.clientsManagement.controllers;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.kuklinski.clientsManagement.javaFX.AcceptOnExitTableCell;
import pl.kuklinski.clientsManagement.javaFX.LocalDateTableCell;
import pl.kuklinski.clientsManagement.javaFX.model.ListClientsModel;
import pl.kuklinski.clientsManagement.javaFX.modelFX.ClientFX;
import pl.kuklinski.clientsManagement.javaFX.modelFX.ContactStatusFX;
import pl.kuklinski.clientsManagement.javaFX.modelFX.OfferStatusFX;
import pl.kuklinski.clientsManagement.javaFX.modelFX.RelationFX;
import pl.kuklinski.clientsManagement.utils.FXMLUtils;

import java.time.LocalDate;
import java.util.List;

public class ListClientsController {

    @FXML
    private TableView<ClientFX> clientsTableView;

    @FXML
    private TableColumn<ClientFX, Number> idColumn;
    @FXML
    private TableColumn<ClientFX, String> nameColumn;
    @FXML
    private TableColumn<ClientFX, String> surnameColumn;
    @FXML
    private TableColumn<ClientFX, String> peselColumn;
    @FXML
    private TableColumn<ClientFX, String> phoneColumn;
    @FXML
    private TableColumn<ClientFX, OfferStatusFX> offerStatusColumn;
    @FXML
    private TableColumn<ClientFX, RelationFX> relationColumn;
    @FXML
    private TableColumn<ClientFX, ContactStatusFX> contactStatusColumn;
    @FXML
    private TableColumn<ClientFX, LocalDate> lastContactDateColumn;
    @FXML
    private TableColumn<ClientFX, LocalDate> plannedContactDateColumn;
    @FXML
    private TableColumn<ClientFX, String> commentColumn;
    @FXML
    private TableColumn<ClientFX, String> incomeTypeColumn;
    @FXML
    private TableColumn<ClientFX, LocalDate> verificationDateColumn;
    @FXML
    private TableColumn<ClientFX, String> clickAmountColumn;
    @FXML
    private TableColumn<ClientFX, String> consolidationAmountColumn;
    @FXML
    private TableColumn<ClientFX, String> detailsColumn;

    @FXML
    private FiltersController filtersController;

    private ListClientsModel listClientsModel;

    private final static String CLIENT_PANE_FXML = "/fxml/ClientPane.fxml";

    @FXML
    public void initialize() {
        this.listClientsModel = new ListClientsModel();
        listClientsModel.init();
        bindingTableView();
        filtersController.setListClientsController(this);
    }


    private void bindingTableView() {
        this.clientsTableView.setItems(this.listClientsModel.getClientFXES());
        setCellValueFactories();
        setCellsFactory();

        this.clientsTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)
                -> this.listClientsModel.setClientFXObjectPropertyEdit(newValue));

    }

    private void setCellValueFactories() {
        this.idColumn.setCellValueFactory(column -> new ReadOnlyObjectWrapper<>
                (clientsTableView.getItems().indexOf(column.getValue()) + 1)); // +1 because start index from 0
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        this.peselColumn.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        this.phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        this.offerStatusColumn.setCellValueFactory(new PropertyValueFactory<>("offerStatus"));
        this.relationColumn.setCellValueFactory(new PropertyValueFactory<>("relation"));
        this.contactStatusColumn.setCellValueFactory(new PropertyValueFactory<>("contactStatus"));
        this.lastContactDateColumn.setCellValueFactory(new PropertyValueFactory<>("lastContactDate"));
        this.plannedContactDateColumn.setCellValueFactory(new PropertyValueFactory<>("plannedDate"));
        this.commentColumn.setCellValueFactory(new PropertyValueFactory<>("comment"));
        this.incomeTypeColumn.setCellValueFactory(new PropertyValueFactory<>("incomeType"));
        this.verificationDateColumn.setCellValueFactory(new PropertyValueFactory<>("verificationDate"));
        this.clickAmountColumn.setCellValueFactory(new PropertyValueFactory<>("clickAmount"));
        this.consolidationAmountColumn.setCellValueFactory(new PropertyValueFactory<>("consolidationAmount"));
    }

    private void setCellsFactory() {
        this.nameColumn.setCellFactory(AcceptOnExitTableCell.forTableColumn());
        this.surnameColumn.setCellFactory(AcceptOnExitTableCell.forTableColumn());
        this.peselColumn.setCellFactory(AcceptOnExitTableCell.forTableColumn());
        this.phoneColumn.setCellFactory(AcceptOnExitTableCell.forTableColumn());
        this.offerStatusColumn.setCellFactory(ComboBoxTableCell.forTableColumn(this.listClientsModel.getOfferStatusFXES()));
        this.relationColumn.setCellFactory(ComboBoxTableCell.forTableColumn(this.listClientsModel.getRelationFXES()));
        this.contactStatusColumn.setCellFactory(ComboBoxTableCell.forTableColumn(this.listClientsModel.getContactStatusFXES()));
        this.lastContactDateColumn.setCellFactory(LocalDateTableCell::new);
        this.plannedContactDateColumn.setCellFactory(LocalDateTableCell::new);
        this.commentColumn.setCellFactory(AcceptOnExitTableCell.forTableColumn());
        this.incomeTypeColumn.setCellFactory(AcceptOnExitTableCell.forTableColumn());
        this.verificationDateColumn.setCellFactory(LocalDateTableCell::new);
        this.clickAmountColumn.setCellFactory(AcceptOnExitTableCell.forTableColumn());
        this.consolidationAmountColumn.setCellFactory(AcceptOnExitTableCell.forTableColumn());

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
    public void editIncomeType(TableColumn.CellEditEvent<ClientFX, String> event) {
        this.listClientsModel.getClientFXObjectPropertyEdit().setIncomeType(event.getNewValue());
        this.listClientsModel.updateInDataBase();
    }

    @FXML
    public void editConsolidationAmount(TableColumn.CellEditEvent<ClientFX, String> event) {
        this.listClientsModel.getClientFXObjectPropertyEdit().setClickAmount(event.getNewValue());
        this.listClientsModel.updateInDataBase();
    }

    @FXML
    public void editComment(TableColumn.CellEditEvent<ClientFX, String> event) {
        this.listClientsModel.getClientFXObjectPropertyEdit().setComment(event.getNewValue());
        this.listClientsModel.updateInDataBase();
    }

    @FXML
    public void editPlannedContact(TableColumn.CellEditEvent<ClientFX, LocalDate> event) {
        this.listClientsModel.getClientFXObjectPropertyEdit().setPlannedDate(event.getNewValue());
        this.listClientsModel.updateInDataBase();
    }

    @FXML
    public void editLastContact(TableColumn.CellEditEvent<ClientFX, LocalDate> event) {
        this.listClientsModel.getClientFXObjectPropertyEdit().setLastContactDate(event.getNewValue());
        this.listClientsModel.updateInDataBase();
    }

    @FXML
    public void editContactStatus(TableColumn.CellEditEvent<ClientFX, ContactStatusFX> event) {
        this.listClientsModel.getClientFXObjectPropertyEdit().setContactStatus(event.getNewValue());
        this.listClientsModel.updateInDataBase();
    }

    @FXML
    public void editRelation(TableColumn.CellEditEvent<ClientFX, RelationFX> event) {
        this.listClientsModel.getClientFXObjectPropertyEdit().setRelation(event.getNewValue());
        this.listClientsModel.updateInDataBase();
    }

    @FXML
    public void editOfferStatus(TableColumn.CellEditEvent<ClientFX, OfferStatusFX> event) {
        this.listClientsModel.getClientFXObjectPropertyEdit().setOfferStatus(event.getNewValue());
        this.listClientsModel.updateInDataBase();
    }

    void setClientFxList(List<ClientFX> clientFxList) {
        this.listClientsModel.getClientFXES().setAll(clientFxList);
    }

    List<ClientFX> getClientFxList() {
        return this.listClientsModel.getClientFXList();
    }

    ListClientsModel getListClientsModel() {
        return listClientsModel;
    }

}
