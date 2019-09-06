package pl.kuklinski.clientsManagement.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;
import java.util.ResourceBundle;

public class DialogUtils {

    private static ResourceBundle bundle = FXMLUtils.getResourceBundle();

    public static Optional<ButtonType> confirmationDialog() {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle(bundle.getString("exit.title"));
        confirmationDialog.setHeaderText(bundle.getString("exit.header"));

        return confirmationDialog.showAndWait();
    }

    public static void informationDialog(String information) {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle(bundle.getString("information.title"));
        informationAlert.setHeaderText(bundle.getString("information.header"));

        TextArea textArea = new TextArea(information);
        informationAlert.getDialogPane().setContent(textArea);
        informationAlert.showAndWait();
    }

    public static File fileChooserDialog() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(" ");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Files", "*.*"),
                new FileChooser.ExtensionFilter("CSV", "*.csv"),
                new FileChooser.ExtensionFilter("TXT", "*.txt")
        );
        return fileChooser.showOpenDialog(new Stage());
    }
}
