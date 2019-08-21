package pl.kuklinski.clientsManagement.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TopMenuButtonsController {

    private static final String LIST_CLIENTS_FXML= "/fxml/ListClients.fxml";

    private MainController mainController;


    @FXML
    public void showClients() {
        mainController.setCenter(LIST_CLIENTS_FXML);
    }

    @FXML
    public void searchClient(ActionEvent actionEvent) {
    }

    @FXML
    public void importFile(ActionEvent actionEvent) {
    }

    @FXML
    public void exportFile(ActionEvent actionEvent) {
    }

    @FXML
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
