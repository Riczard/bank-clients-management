package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import pl.kuklinski.clientsManagement.javaFX.model.ExportModel;

import java.util.HashMap;
import java.util.Map;

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
        this.exportModel.exportData(getFieldsToImport());
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

    private Map<String, Boolean> getFieldsToImport() {
        Map<String, Boolean> checkBoxesValues = new HashMap<>();
        checkBoxesValues.put("name", nameCheckBox.selectedProperty().getValue());
        checkBoxesValues.put("surname", surnameCheckBox.selectedProperty().getValue());
        checkBoxesValues.put("pesel", peselCheckBox.selectedProperty().getValue());
        checkBoxesValues.put("statusOffer", statusOfferCheckBox.selectedProperty().getValue());
        checkBoxesValues.put("contactStatus", contactStatusCheckBox.selectedProperty().getValue());
        checkBoxesValues.put("plannedDate", plannedDateCheckBox.selectedProperty().getValue());
        checkBoxesValues.put("income", incomeTypeCheckBox.selectedProperty().getValue());
        checkBoxesValues.put("clickAmount", clickAmountCheckBox.selectedProperty().getValue());
        checkBoxesValues.put("city", cityCheckBox.selectedProperty().getValue());
        checkBoxesValues.put("phone", phoneCheckBox.selectedProperty().getValue());
        checkBoxesValues.put("relation", relationCheckBox.selectedProperty().getValue());
        checkBoxesValues.put("lastContact", lastContactCheckBox.selectedProperty().getValue());
        checkBoxesValues.put("comment", commentCheckBox.selectedProperty().getValue());
        checkBoxesValues.put("verification", verificationDateCheckBox.selectedProperty().getValue());
        checkBoxesValues.put("consolidation", consolidationCheckBox.selectedProperty().getValue());
        checkBoxesValues.put("source", sourceCheckBox.selectedProperty().getValue());
        checkBoxesValues.put("adviser", adviserCheckBox.selectedProperty().getValue());
        return checkBoxesValues;
    }

}
