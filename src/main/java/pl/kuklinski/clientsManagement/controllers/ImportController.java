package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pl.kuklinski.clientsManagement.database.dbutils.ImportManager;

import java.io.File;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private DecimalFormat format = new DecimalFormat( "#.0" );

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
            if ( c.getControlNewText().isEmpty() ) {
                return c;
            }
            ParsePosition parsePosition = new ParsePosition( 0 );
            Object object = format.parse( c.getControlNewText(), parsePosition );

            if ( object == null || parsePosition.getIndex() < c.getControlNewText().length() ) {
                return null;
            }
            else {
                return c;
            }
        });
    }

    private void validation() {
        this.importButton.disableProperty().bind(this.filePath.textProperty().isEmpty());
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
        ImportManager.importToDataBase(getColumnsIndex(), file);
    }

    private Map<String, Integer> getColumnsIndex() {
        Map<String, Integer> columnsIndex = new HashMap<>();
        columnsIndex.put("nameClient", Integer.parseInt(nameIndex.getText()));
        columnsIndex.put("surnameClient", Integer.parseInt(surnameIndex.getText()));
        columnsIndex.put("cityClient", Integer.parseInt(cityIndex.getText()));
        columnsIndex.put("phoneClient", Integer.parseInt(phoneIndex.getText()));
        columnsIndex.put("incomeClient", Integer.parseInt(incomeIndex.getText()));
        columnsIndex.put("peselClient", Integer.parseInt(peselIndex.getText()));
        columnsIndex.put("relationClient", Integer.parseInt(relationIndex.getText()));
        columnsIndex.put("clickAmountClient", Integer.parseInt(clickAmountIndex.getText()));
        columnsIndex.put("commentClient", Integer.parseInt(commentIndex.getText()));
        columnsIndex.put("lastContactDateClient", Integer.parseInt(lastContactDateIndex.getText()));
        columnsIndex.put("verificationDateClient", Integer.parseInt(verificationDateIndex.getText()));
        columnsIndex.put("adviserClient", Integer.parseInt(adviserIndex.getText()));
        columnsIndex.put("statusClient", Integer.parseInt(statusIndex.getText()));
        return columnsIndex;
    }


}
