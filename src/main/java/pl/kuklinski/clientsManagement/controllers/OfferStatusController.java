package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.StringConverter;
import pl.kuklinski.clientsManagement.javaFX.model.OfferStatusModel;
import pl.kuklinski.clientsManagement.javaFX.modelFX.OfferStatusFX;

public class OfferStatusController {

    @FXML
    private TextField statusField;
    @FXML
    private Button addButton;
    @FXML
    private ListView<OfferStatusFX> statusListView;
    @FXML
    private MenuItem deleteStatus;

    private OfferStatusModel offerStatusModel;

    @FXML
    public void initialize() {
        this.offerStatusModel = new OfferStatusModel();
        this.offerStatusModel.init();
        bindings();
        bindingsListView();
        setOnEditCells();
    }

    private void bindings() {
        this.offerStatusModel.offerStatusFXObjectProperty().get().titleProperty().bind(this.statusField.textProperty());
        this.addButton.disableProperty().bind(this.statusField.textProperty().isEmpty());
        this.deleteStatus.disableProperty().bind(this.statusListView.getSelectionModel().selectedItemProperty().isNull());
    }

    private void bindingsListView() {
        this.statusListView.setItems(this.offerStatusModel.getOfferStatusFXES());
        this.statusListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.offerStatusModel.setOfferStatusFXObjectPropertyEdit(newValue);
        });
    }

    private void setOnEditCells() {
        statusListView.setCellFactory(TextFieldListCell.forListView(new StringConverter<OfferStatusFX>() {
            @Override
            public String toString(OfferStatusFX object) {
                return object.toString();
            }

            @Override
            public OfferStatusFX fromString(String string) {
                OfferStatusFX offerStatusFX = new OfferStatusFX();
                offerStatusFX.setTitle(string);
                return offerStatusFX;
            }
        }));
    }

    @FXML
    public void addOfferStatus() {
        this.offerStatusModel.saveStatusInDB();
        this.statusField.clear();
    }

    @FXML
    public void deleteStatusOnAction() {
        this.offerStatusModel.deleteStatusInDB();
    }

    @FXML
    public void editStatus(ListView.EditEvent<OfferStatusFX> event) {
        this.offerStatusModel.getOfferStatusFXObjectPropertyEdit().setTitle(event.getNewValue().getTitle());
        this.offerStatusModel.updateStatusInDB();
    }
}
