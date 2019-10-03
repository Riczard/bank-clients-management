package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;

public class TopMenuButtonsController {

    private static final String LIST_CLIENTS_FXML = "/fxml/ListClients.fxml";
    private static final String IMPORT_PANE_FXML = "/fxml/ImportPane.fxml";
    private static final String SEARCH_PANE_FXML = "/fxml/SearchPane.fxml";
    private static final String RESOURCES_BUTTONS_FXML = "/fxml/ResourcesButtons.fxml";
    private static final String EXPORT_PANE_FXML = "/fxml/ExportPane.fxml";

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
    public void exportFile() { mainController.setCenter(EXPORT_PANE_FXML);
    }

    @FXML
    public void importClients() {
        mainController.setCenter(IMPORT_PANE_FXML);
    }

    @FXML
    public void openResources() {
        this.mainController.setCenter(RESOURCES_BUTTONS_FXML);
    }

    @FXML
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

}
