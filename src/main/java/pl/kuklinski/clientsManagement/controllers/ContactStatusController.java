package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.StringConverter;
import pl.kuklinski.clientsManagement.javaFX.model.ContactStatusModel;
import pl.kuklinski.clientsManagement.javaFX.modelFX.ContactStatusFX;

public class ContactStatusController {

    @FXML
    private MenuItem deleteStatus;
    @FXML
    private ListView<ContactStatusFX> statusListView;
    @FXML
    private Button addButton;
    @FXML
    private TextField statusField;

    private ContactStatusModel contactStatusModel;

    @FXML
    public void initialize() {
        this.contactStatusModel = new ContactStatusModel();
        this.contactStatusModel.init();
        bindings();
        bindingsListView();

        setOnEditCells();
    }

    private void setOnEditCells() {
        statusListView.setCellFactory(TextFieldListCell.forListView(new StringConverter<ContactStatusFX>() {
            @Override
            public String toString(ContactStatusFX object) {
                return object.getContactStatus();
            }

            @Override
            public ContactStatusFX fromString(String string) {
                ContactStatusFX contactStatusFX = new ContactStatusFX();
                contactStatusFX.setContactStatus(string);
                return contactStatusFX;
            }
        }));
    }

    private void bindings() {
        this.contactStatusModel.accountStatusFXObjectPropertyy().get().contactStatusProperty().bind(this.statusField.textProperty());
        this.addButton.disableProperty().bind(this.statusField.textProperty().isEmpty());
        this.deleteStatus.disableProperty().bind(this.statusListView.getSelectionModel().selectedItemProperty().isNull());
    }

    private void bindingsListView() {
        this.statusListView.setItems(this.contactStatusModel.getContactStatusFXObservableList());
        this.statusListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.contactStatusModel.setAccountStatusFXObjectPropertyEdit(newValue);
        });
    }

    @FXML
    public void addAccStatus() {
        this.contactStatusModel.saveStatusInDataBase();
        this.statusField.clear();
    }

    @FXML
    public void deleteStatusOnAction() {
        this.contactStatusModel.deleteStatusInDataBase();
    }

    @FXML
    public void editStatus(ListView.EditEvent<ContactStatusFX> accountStatusFXEditEvent) {
        this.contactStatusModel.getAccountStatusFXObjectPropertyEdit().setContactStatus(accountStatusFXEditEvent.getNewValue().getContactStatus());
        this.contactStatusModel.updateStatusInDB();
    }

}
