package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import pl.kuklinski.clientsManagement.javaFX.model.FilterModel;
import pl.kuklinski.clientsManagement.javaFX.modelFX.ClientFX;
import pl.kuklinski.clientsManagement.javaFX.modelFX.ContactStatusFX;
import pl.kuklinski.clientsManagement.javaFX.modelFX.OfferStatusFX;
import pl.kuklinski.clientsManagement.javaFX.modelFX.RelationFX;

import java.util.List;

public class FiltersController {

    @FXML
    private ComboBox<RelationFX> relationComboBox;
    @FXML
    private ComboBox<OfferStatusFX> offerStatusComboBox;
    @FXML
    private ComboBox<ContactStatusFX> contactStatusComboBox;
    @FXML
    private TextField consolidationAmountField;
    @FXML
    private TextField clickAmountField;
    @FXML
    private GridPane filtersPane;
    @FXML
    private TextField generalFilter;
    @FXML
    private TextField sourceFilter;

    private ListClientsController listClientsController;

    private FilterModel filterModel;

    @FXML
    public void initialize() {
        this.filterModel = new FilterModel();
        bindings();
    }

    private void bindings() {
        this.filterModel.getFilterFXObjectProperty().generalFilterProperty().bind(this.generalFilter.textProperty());
        this.filterModel.getFilterFXObjectProperty().relationFxProperty().bind(this.relationComboBox.valueProperty());
        this.filterModel.getFilterFXObjectProperty().offerStatusFxProperty().bind(this.offerStatusComboBox.valueProperty());
        this.filterModel.getFilterFXObjectProperty().contactStatusFxProperty().bind(this.contactStatusComboBox.valueProperty());
        this.filterModel.getFilterFXObjectProperty().consolidationAmountProperty().bind(this.consolidationAmountField.textProperty());
        this.filterModel.getFilterFXObjectProperty().clickAmountProperty().bind(this.clickAmountField.textProperty());
        this.filterModel.getFilterFXObjectProperty().sourceProperty().bind(this.sourceFilter.textProperty());
    }

    @FXML
    public void showOrHideFilters() {
        filtersPane.setVisible(!filtersPane.visibleProperty().get());
        filtersPane.setDisable(!filtersPane.disableProperty().get());
    }

    @FXML
    public void filterClients() {
        List<ClientFX> filteredList = filterModel.filterClients(listClientsController.getClientFxList());
        listClientsController.setClientFxList(filteredList);
    }

    @FXML
    public void setListClientsController(ListClientsController listClientsController) {
        this.listClientsController = listClientsController;
    }


}
