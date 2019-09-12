package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import pl.kuklinski.clientsManagement.javaFX.model.FilterModel;
import pl.kuklinski.clientsManagement.javaFX.modelFX.ClientFX;

import java.util.List;

public class FiltersController {

    @FXML
    private GridPane filtersPane;
    @FXML
    private TextField generalFilter;
    @FXML
    private TextField peselFilter;
    @FXML
    private TextField surnameFilter;
    @FXML
    private TextField relationFilter;
    @FXML
    private TextField offerStatusFilter;
    @FXML
    private TextField contactStatusFilter;
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
        this.filterModel.filterFXObjectProperty().get().generalFilterProperty().bind(this.generalFilter.textProperty());
        this.filterModel.filterFXObjectProperty().get().peselFilterProperty().bind(this.peselFilter.textProperty());
        this.filterModel.filterFXObjectProperty().get().surnameFilterProperty().bind(this.surnameFilter.textProperty());
        this.filterModel.filterFXObjectProperty().get().relationFilterProperty().bind(this.relationFilter.textProperty());
        this.filterModel.filterFXObjectProperty().get().offerStatusFilterProperty().bind(this.offerStatusFilter.textProperty());
        this.filterModel.filterFXObjectProperty().get().contactStatusFilterProperty().bind(this.contactStatusFilter.textProperty());
        this.filterModel.filterFXObjectProperty().get().sourceFilterProperty().bind(this.sourceFilter.textProperty());
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
