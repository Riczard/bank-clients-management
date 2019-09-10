package pl.kuklinski.clientsManagement.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.kuklinski.clientsManagement.utils.DialogUtils;
import pl.kuklinski.clientsManagement.utils.FXMLUtils;

import java.util.Optional;

public class MainController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private TopMenuButtonsController topMenuButtonsController;

    @FXML
    private void initialize() {
        topMenuButtonsController.setMainController(this);
        topMenuButtonsController.getClientButton().fire();
        setCenter("/fxml/ListClients.fxml");
    }

    public void setCenter(String fxmlPath) {
        borderPane.setCenter(FXMLUtils.fxmlLoader(fxmlPath));
        BorderPane.setAlignment(borderPane.getCenter(), Pos.TOP_CENTER);
    }

    public void setAlwaysOnTop(ActionEvent actionEvent) {
        Stage stage = (Stage) borderPane.getScene().getWindow();
        boolean value = ((CheckMenuItem) actionEvent.getSource()).isSelected();
        stage.setAlwaysOnTop(value);
    }

    public void closeApp() {
        Optional<ButtonType> result = DialogUtils.confirmationDialog();
        if (result.get() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }
    }
}
