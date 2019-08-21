package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListClientsController {

    @FXML
    private TableView clientsTableView;
    @FXML
    private TableColumn nameColumn;
    @FXML
    private TableColumn surnameColumn;
    @FXML
    private TableColumn peselColumn;
    @FXML
    private TableColumn clickAmountColumn;
    @FXML
    private TableColumn phoneColumn;
    @FXML
    private TableColumn cityColumn;
    @FXML
    private TableColumn adviserColumn;
    @FXML
    private TableColumn incomeColumn;
    @FXML
    private TableColumn detailsColumn;

    @FXML
    public void initialize() {

    }
}
