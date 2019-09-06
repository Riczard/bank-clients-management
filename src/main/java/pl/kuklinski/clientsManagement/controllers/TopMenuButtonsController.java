package pl.kuklinski.clientsManagement.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TopMenuButtonsController {

    private static final String LIST_CLIENTS_FXML = "/fxml/ListClients.fxml";
    private static final String ADD_ADVISERS_FXML = "/fxml/AddAdvisers.fxml";
    private static final String ADD_ACCOUNT_STATUS_FXML = "/fxml/AddContactStatus.fxml";
    private static final String IMPORT_PANE_FXML = "/fxml/ImportPane.fxml";
    private static final String SEARCH_PANE_FXML = "/fxml/SearchPane.fxml";

    private MainController mainController;


    @FXML
    public void showClients() {
        mainController.setCenter(LIST_CLIENTS_FXML);
    }

    @FXML
    public void searchClient() {
        mainController.setCenter(SEARCH_PANE_FXML);
    }

    @FXML
    public void exportFile(ActionEvent actionEvent) {
    }

    @FXML
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }


    public void addAdvisers() {
        mainController.setCenter(ADD_ADVISERS_FXML);
    }

    public void addAccStatus() {
        mainController.setCenter(ADD_ACCOUNT_STATUS_FXML);
    }

    public void importClients() {
        mainController.setCenter(IMPORT_PANE_FXML);
    }
}
