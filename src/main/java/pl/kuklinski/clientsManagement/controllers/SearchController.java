package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import pl.kuklinski.clientsManagement.javaFX.model.SearchModel;
import pl.kuklinski.clientsManagement.javaFX.modelFX.CreditFX;
import pl.kuklinski.clientsManagement.utils.DialogUtils;
import pl.kuklinski.clientsManagement.utils.FXMLUtils;

import java.io.File;
import java.io.FileNotFoundException;

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

    private File directory;

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
        allTypes.setType("creditAll");
        creditTypeCombobox.getItems().add(allTypes);
    }

    private void validation() {
        this.searchButton.disableProperty().bind(this.directoryPath.textProperty().isEmpty()
                .or(createTxtCheckbox.selectedProperty().not().and(addToDbCheckbox.selectedProperty().not()))
                .or(creditTypeCombobox.valueProperty().isNull()));
    }

    @FXML
    public void chooseFolder() {
        directory = DialogUtils.directoryChooserDialog();
        directoryPath.setText(directory.getPath());
    }

    @FXML
    public void searchCredits() {
        searchModel.setDirectory(directory);
        String[][] data = new String[0][0];
        try {
            data = searchModel.search(creditTypeCombobox.getSelectionModel().getSelectedItem());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (createTxtCheckbox.isSelected() && addToDbCheckbox.isSelected()) {
            searchModel.createTxtFile(data);
            searchModel.importToDB(data);
        } else if (createTxtCheckbox.isSelected()) {
            searchModel.createTxtFile(data);
        } else {
            searchModel.importToDB(data);
        }
    }
}
