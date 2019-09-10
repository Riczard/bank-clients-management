package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import pl.kuklinski.clientsManagement.utils.FXMLUtils;

public class ResourcesButtonsController {

    private static final String ADD_ADVISERS_FXML = "/fxml/AddAdvisers.fxml";
    private static final String ADD_CONTACT_STATUS_FXML = "/fxml/AddContactStatus.fxml";
    private static final String ADD_RELATION_FXML = "/fxml/AddRelation.fxml";
    private static final String ADD_OFFER_STATUS_FXML ="/fxml/AddOfferStatus.fxml";

    @FXML
    public BorderPane resourcesPane;

    @FXML
    public void initialize() {
        setCenter(ADD_CONTACT_STATUS_FXML);
    }

    @FXML
    public void showAdvisers() {
        setCenter(ADD_ADVISERS_FXML);
    }

    @FXML
    public void showRelations() {
        setCenter(ADD_RELATION_FXML);
    }

    @FXML
    public void showOffersStatus() {
        setCenter(ADD_OFFER_STATUS_FXML);
    }

    @FXML
    public void showContactStatus() {
        setCenter(ADD_CONTACT_STATUS_FXML);
    }

    private void setCenter(String fxmlPath) {
        resourcesPane.setCenter(FXMLUtils.fxmlLoader(fxmlPath));
        BorderPane.setAlignment(resourcesPane.getCenter(), Pos.TOP_CENTER);
    }
}
