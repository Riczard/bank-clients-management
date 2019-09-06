package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import pl.kuklinski.clientsManagement.javaFX.model.SearchModel;
import pl.kuklinski.clientsManagement.javaFX.modelFX.CreditFX;
import pl.kuklinski.clientsManagement.utils.FXMLUtils;

public class SearchController {

    @FXML
    private ComboBox<CreditFX> creditTypeCombobox;
    @FXML
    private Label directoryPath;
    @FXML
    private CheckBox createTxtCheckbox;
    @FXML
    private CheckBox addToDbCheckbox;
    @FXML
    private Button searchButton;

    private SearchModel searchModel;

    @FXML
    public void initialize() {
        this.searchModel = new SearchModel();
        initComboBox();
        validation();
    }

    private void initComboBox() {
        CreditFX preapprovedCredit = new CreditFX();
        preapprovedCredit.setTitle(FXMLUtils.getResourceBundle().getString("creditPreapproved.search"));
        preapprovedCredit.setType("preapproved");
        creditTypeCombobox.getItems().add(preapprovedCredit);

        CreditFX consolidationCredit = new CreditFX();
        consolidationCredit.setTitle(FXMLUtils.getResourceBundle().getString("creditConsolidation.search"));
        consolidationCredit.setType("consolidation");
        creditTypeCombobox.getItems().add(consolidationCredit);

        CreditFX allTypes = new CreditFX();
        allTypes.setTitle(FXMLUtils.getResourceBundle().getString("creditAll"));
        allTypes.setType("all");
        creditTypeCombobox.getItems().add(allTypes);
    }

    private void validation() {
        this.searchButton.disableProperty().bind(this.directoryPath.textProperty().isEmpty()
                .or((createTxtCheckbox.selectedProperty()).not()).and(addToDbCheckbox.selectedProperty().not()));
    }

    @FXML
    public void chooseFolder() {
    }

    @FXML
    public void searchCredits() {
    }
}
