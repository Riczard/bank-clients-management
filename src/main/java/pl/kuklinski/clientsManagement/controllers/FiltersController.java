package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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
    public void setListClientsController(ListClientsController listClientsController) {
        this.listClientsController = listClientsController;
    }
}
