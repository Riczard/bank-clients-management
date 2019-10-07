package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import pl.kuklinski.clientsManagement.javaFX.model.ExportModel;
import pl.kuklinski.clientsManagement.utils.DialogUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExportController {

    public CheckBox markOrUnmarkAll;
    @FXML
    private Button exportButton;
    @FXML
    private CheckBox adviserCheckBox;
    @FXML
    private CheckBox sourceCheckBox;
    @FXML
    private CheckBox consolidationCheckBox;
    @FXML
    private CheckBox verificationDateCheckBox;
    @FXML
    private CheckBox commentCheckBox;
    @FXML
    private CheckBox lastContactCheckBox;
    @FXML
    private CheckBox relationCheckBox;
    @FXML
    private CheckBox phoneCheckBox;
    @FXML
    private CheckBox surnameCheckBox;
    @FXML
    private CheckBox cityCheckBox;
    @FXML
    private CheckBox clickAmountCheckBox;
    @FXML
    private CheckBox incomeTypeCheckBox;
    @FXML
    private CheckBox plannedDateCheckBox;
    @FXML
    private CheckBox contactStatusCheckBox;
    @FXML
    private CheckBox statusOfferCheckBox;
    @FXML
    private CheckBox peselCheckBox;
    @FXML
    private CheckBox nameCheckBox;

    private ExportModel exportModel;

    public void initialize() {
        this.exportModel = new ExportModel();
        validation();
    }

    private void validation() {
        this.exportButton.disableProperty().bind(
                this.adviserCheckBox.selectedProperty().not()
                        .and(sourceCheckBox.selectedProperty().not())
                        .and(consolidationCheckBox.selectedProperty().not())
                        .and(verificationDateCheckBox.selectedProperty().not())
                        .and(commentCheckBox.selectedProperty().not())
                        .and(lastContactCheckBox.selectedProperty().not())
                        .and(relationCheckBox.selectedProperty().not())
                        .and(phoneCheckBox.selectedProperty().not())
                        .and(surnameCheckBox.selectedProperty().not())
                        .and(cityCheckBox.selectedProperty().not())
                        .and(clickAmountCheckBox.selectedProperty().not())
                        .and(incomeTypeCheckBox.selectedProperty().not())
                        .and(plannedDateCheckBox.selectedProperty().not())
                        .and(statusOfferCheckBox.selectedProperty().not())
                        .and(peselCheckBox.selectedProperty().not())
                        .and(contactStatusCheckBox.selectedProperty().not())
                        .and(nameCheckBox.selectedProperty().not()));
    }

    @FXML
    public void exportData() {
        try {
            this.exportModel.exportData(getFieldsToImport());
            this.setCheckBoxesAs(false);
            this.markOrUnmarkAll.selectedProperty().set(false);
        } catch (IOException e) {
            DialogUtils.informationDialog("Export Error");
        }
        DialogUtils.informationDialog("Export complete");
    }

    @FXML
    public void markAll() {
        if (markOrUnmarkAll.isSelected()) {
            setCheckBoxesAs(true);
        } else {
            setCheckBoxesAs(false);
        }
    }

    private void setCheckBoxesAs(boolean b) {
        this.adviserCheckBox.selectedProperty().set(b);
        this.sourceCheckBox.selectedProperty().set(b);
        this.consolidationCheckBox.selectedProperty().set(b);
        this.verificationDateCheckBox.selectedProperty().set(b);
        this.commentCheckBox.selectedProperty().set(b);
        this.lastContactCheckBox.selectedProperty().set(b);
        this.relationCheckBox.selectedProperty().set(b);
        this.phoneCheckBox.selectedProperty().set(b);
        this.surnameCheckBox.selectedProperty().set(b);
        this.cityCheckBox.selectedProperty().set(b);
        this.clickAmountCheckBox.selectedProperty().set(b);
        this.incomeTypeCheckBox.selectedProperty().set(b);
        this.plannedDateCheckBox.selectedProperty().set(b);
        this.contactStatusCheckBox.selectedProperty().set(b);
        this.statusOfferCheckBox.selectedProperty().set(b);
        this.peselCheckBox.selectedProperty().set(b);
        this.nameCheckBox.selectedProperty().set(b);
    }

    private List<String> getFieldsToImport() {
        List<String> fieldsToImport = new ArrayList<>();
        if (nameCheckBox.selectedProperty().getValue()) fieldsToImport.add("name");
        if (surnameCheckBox.selectedProperty().getValue()) fieldsToImport.add("surname");
        if (peselCheckBox.selectedProperty().getValue()) fieldsToImport.add("pesel");
        if (statusOfferCheckBox.selectedProperty().getValue()) fieldsToImport.add("statusOffer");
        if (contactStatusCheckBox.selectedProperty().getValue()) fieldsToImport.add("contactStatus");
        if (plannedDateCheckBox.selectedProperty().getValue()) fieldsToImport.add("plannedDate");
        if (incomeTypeCheckBox.selectedProperty().getValue()) fieldsToImport.add("incomeType");
        if (clickAmountCheckBox.selectedProperty().getValue()) fieldsToImport.add("clickAmount");
        if (cityCheckBox.selectedProperty().getValue()) fieldsToImport.add("city");
        if (phoneCheckBox.selectedProperty().getValue()) fieldsToImport.add("phone");
        if (relationCheckBox.selectedProperty().getValue()) fieldsToImport.add("relation");
        if (lastContactCheckBox.selectedProperty().getValue()) fieldsToImport.add("lastContactDate");
        if (contactStatusCheckBox.selectedProperty().getValue()) fieldsToImport.add("comment");
        if (verificationDateCheckBox.selectedProperty().getValue()) fieldsToImport.add("verificationDate");
        if (consolidationCheckBox.selectedProperty().getValue()) fieldsToImport.add("consolidationAmount");
        if (sourceCheckBox.selectedProperty().getValue()) fieldsToImport.add("source");
        if (adviserCheckBox.selectedProperty().getValue()) fieldsToImport.add("adviser");
        return fieldsToImport;
    }

}
