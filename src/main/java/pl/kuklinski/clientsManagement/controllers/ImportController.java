package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pl.kuklinski.clientsManagement.javaFX.model.ImportModel;
import pl.kuklinski.clientsManagement.utils.CSVUtils;
import pl.kuklinski.clientsManagement.utils.DialogUtils;
import pl.kuklinski.clientsManagement.utils.FXMLUtils;

import java.io.File;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static pl.kuklinski.clientsManagement.utils.Formatters.setFieldOnlyNumeric;

public class ImportController {

    @FXML
    private TextField delimiterField;
    @FXML
    private Button importButton;

    @FXML
    private TextField nameIndex;
    @FXML
    private TextField surnameIndex;
    @FXML
    private TextField peselIndex;
    @FXML
    private TextField phoneIndex;
    @FXML
    private TextField offerStatusIndex;
    @FXML
    private TextField relationIndex;
    @FXML
    private TextField contactStatusIndex;
    @FXML
    private TextField lastContactDateIndex;
    @FXML
    private TextField plannedContactIndex;
    @FXML
    private TextField commentIndex;
    @FXML
    private TextField incomeType;
    @FXML
    private TextField verificationDateIndex;
    @FXML
    private TextField clickAmountIndex;
    @FXML
    private TextField consolidationAmountIndex;
    @FXML
    private TextField cityIndex;
    @FXML
    private TextField sourceIndex;
    @FXML
    private TextField adviserIndex;
    @FXML
    private Label filePath;

    private File file;
    private ImportModel importModel;

    @FXML
    public void initialize() {
        this.importModel = new ImportModel();
        addTextFormatterToFields();
        validation();
    }

    private void addTextFormatterToFields() {
        nameIndex.setTextFormatter(setFieldOnlyNumeric());
        surnameIndex.setTextFormatter(setFieldOnlyNumeric());
        peselIndex.setTextFormatter(setFieldOnlyNumeric());
        phoneIndex.setTextFormatter(setFieldOnlyNumeric());
        offerStatusIndex.setTextFormatter(setFieldOnlyNumeric());
        relationIndex.setTextFormatter(setFieldOnlyNumeric());
        contactStatusIndex.setTextFormatter(setFieldOnlyNumeric());
        lastContactDateIndex.setTextFormatter(setFieldOnlyNumeric());
        plannedContactIndex.setTextFormatter(setFieldOnlyNumeric());
        commentIndex.setTextFormatter(setFieldOnlyNumeric());
        incomeType.setTextFormatter(setFieldOnlyNumeric());
        verificationDateIndex.setTextFormatter(setFieldOnlyNumeric());
        clickAmountIndex.setTextFormatter(setFieldOnlyNumeric());
        consolidationAmountIndex.setTextFormatter(setFieldOnlyNumeric());
        cityIndex.setTextFormatter(setFieldOnlyNumeric());
        sourceIndex.setTextFormatter(setFieldOnlyNumeric());
        adviserIndex.setTextFormatter(setFieldOnlyNumeric());
    }

    private void validation() {
        this.importButton.disableProperty().bind(this.filePath.textProperty().isEmpty()
                .or(this.delimiterField.textProperty().isEmpty()));
    }

    @FXML
    public void chooseFile() {
        this.file = DialogUtils.fileChooserDialog();
        this.filePath.setText(file.getPath());
    }

    @FXML
    public void importData() {
        List<String[]> dataFromCSV = CSVUtils.getDataFromCSV(file, delimiterField.getText());
        this.importModel.setColumnsIndex(getColumnsIndex());
        this.importModel.importToDB(dataFromCSV);
        DialogUtils.informationDialog(FXMLUtils.getResourceBundle().getString("information.import"));
    }

    private Map<String, String> getColumnsIndex() {
        Map<String, String> columnsIndex = new HashMap<>();
        columnsIndex.put(nameIndex.getText(), "name");
        columnsIndex.put(surnameIndex.getText(), "surname");
        columnsIndex.put(peselIndex.getText(), "pesel");
        columnsIndex.put(phoneIndex.getText(), "phone");
        columnsIndex.put(offerStatusIndex.getText(), "offerStatus");
        columnsIndex.put(relationIndex.getText(), "relation");
        columnsIndex.put(contactStatusIndex.getText(), "contactStatus");
        columnsIndex.put(lastContactDateIndex.getText(), "lastContactDate");
        columnsIndex.put(plannedContactIndex.getText(), "plannedContactDate");
        columnsIndex.put(commentIndex.getText(), "comment");
        columnsIndex.put(incomeType.getText(), "incomeType");
        columnsIndex.put(verificationDateIndex.getText(), "verificationDate");
        columnsIndex.put(clickAmountIndex.getText(), "clickAmount");
        columnsIndex.put(consolidationAmountIndex.getText(), "consolidationAmount");
        columnsIndex.put(cityIndex.getText(), "cityClient");
        columnsIndex.put(sourceIndex.getText(), "source");
        columnsIndex.put(adviserIndex.getText(), "adviserClient");
        return columnsIndex;
    }


}
