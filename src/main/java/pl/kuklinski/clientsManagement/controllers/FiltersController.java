package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pl.kuklinski.clientsManagement.javaFX.modelFX.ClientFX;

import java.util.List;

public class FiltersController {

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

    @FXML
    public void showOrHideFilters() {
        filters.setVisible(!filters.visibleProperty().get());
        filters.setDisable(!filters.disableProperty().get());
    }

    @FXML
    public void filterAll() {
        filtersController.filterAllClients(this.listClientsModel.getClientFXList());
    }


    @FXML
    public void setListClientsController(ListClientsController listClientsController) {
        this.listClientsController = listClientsController;
    }

    public void filterAllClients(List<ClientFX> clientFXList) {

        listClientsController.setClientFxList(clientFXList);
    }
}
