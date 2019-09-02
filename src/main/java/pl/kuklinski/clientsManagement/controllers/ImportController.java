package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class ImportController {

    @FXML
    private Button importButton;
    @FXML
    private TextField statusClient;
    @FXML
    private TextField adviserClient;
    @FXML
    private TextField verificationDateClient;
    @FXML
    private TextField lastContactDateClient;
    @FXML
    private TextField commentClient;
    @FXML
    private TextField clickAmountClient;
    @FXML
    private TextField relationClient;
    @FXML
    private TextField peselClient;
    @FXML
    private TextField incomeClient;
    @FXML
    private TextField phoneClient;
    @FXML
    private TextField cityClient;
    @FXML
    private TextField surnameClient;
    @FXML
    private TextField nameClient;
    @FXML
    private Label filePath;

    private File file;

    @FXML
    public void chooseFile() {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(" ");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Files", "*.*"),
                new FileChooser.ExtensionFilter("CSV", "*.csv"),
                new FileChooser.ExtensionFilter("TXT", "*.txt")

        );
        file = fileChooser.showOpenDialog(stage);
        filePath.setText(file.getPath());

    }

    @FXML
    public void importData() {
    }
}
