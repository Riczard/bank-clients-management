package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pl.kuklinski.clientsManagement.database.dbutils.ImportClientFromCSV;

import java.io.File;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Map;

public class ImportController {

    @FXML
    private Button importButton;
    @FXML
    private TextField statusIndex;
    @FXML
    private TextField adviserIndex;
    @FXML
    private TextField verificationDateIndex;
    @FXML
    private TextField lastContactDateIndex;
    @FXML
    private TextField commentIndex;
    @FXML
    private TextField clickAmountIndex;
    @FXML
    private TextField relationIndex;
    @FXML
    private TextField peselIndex;
    @FXML
    private TextField incomeIndex;
    @FXML
    private TextField phoneIndex;
    @FXML
    private TextField cityIndex;
    @FXML
    private TextField surnameIndex;
    @FXML
    private TextField nameIndex;
    @FXML
    private Label filePath;

    private File file;
    private DecimalFormat format = new DecimalFormat("#.0");

    @FXML
    public void initialize() {
        addTextFormatterToFields();
        validation();

    }

    private void addTextFormatterToFields() {
        nameIndex.setTextFormatter(setFieldOnlyNumeric());
        surnameIndex.setTextFormatter(setFieldOnlyNumeric());
        cityIndex.setTextFormatter(setFieldOnlyNumeric());
        phoneIndex.setTextFormatter(setFieldOnlyNumeric());
        incomeIndex.setTextFormatter(setFieldOnlyNumeric());
        peselIndex.setTextFormatter(setFieldOnlyNumeric());
        relationIndex.setTextFormatter(setFieldOnlyNumeric());
        clickAmountIndex.setTextFormatter(setFieldOnlyNumeric());
        commentIndex.setTextFormatter(setFieldOnlyNumeric());
        lastContactDateIndex.setTextFormatter(setFieldOnlyNumeric());
        verificationDateIndex.setTextFormatter(setFieldOnlyNumeric());
        adviserIndex.setTextFormatter(setFieldOnlyNumeric());
        statusIndex.setTextFormatter(setFieldOnlyNumeric());
    }

    private TextFormatter<Object> setFieldOnlyNumeric() {
        return new TextFormatter<>(c -> {
            if (c.getControlNewText().isEmpty()) {
                return c;
            }
            ParsePosition parsePosition = new ParsePosition(0);
            Object object = format.parse(c.getControlNewText(), parsePosition);

            if (object == null || parsePosition.getIndex() < c.getControlNewText().length()) {
                return null;
            } else {
                return c;
            }
        });
    }

    private void validation() {
        this.importButton.disableProperty().bind(this.filePath.textProperty().isEmpty()
                .or(this.peselIndex.textProperty().isEmpty()));
    }

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
        ImportClientFromCSV importClient = new ImportClientFromCSV(getColumnsIndex());
        importClient.importClientToDB(file);
    }

    private Map<String, String> getColumnsIndex() {
        Map<String, String> columnsIndex = new HashMap<>();
        columnsIndex.put(nameIndex.getText(), "nameClient");
        columnsIndex.put(surnameIndex.getText(), "surnameClient");
        columnsIndex.put(cityIndex.getText(), "cityClient");
        columnsIndex.put(phoneIndex.getText(), "phoneClient");
        columnsIndex.put(incomeIndex.getText(), "incomeClient");
        columnsIndex.put(peselIndex.getText(), "peselClient");
        columnsIndex.put(relationIndex.getText(), "relationClient");
        columnsIndex.put(clickAmountIndex.getText(), "clickAmountClient");
        columnsIndex.put(commentIndex.getText(), "commentClient");
        columnsIndex.put(lastContactDateIndex.getText(), "lastContactDateClient");
        columnsIndex.put(verificationDateIndex.getText(), "verificationDateClient");
        columnsIndex.put(adviserIndex.getText(), "adviserClient");
        columnsIndex.put(statusIndex.getText(), "statusClient");
        return columnsIndex;
    }


}
