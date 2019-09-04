package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.StringConverter;
import pl.kuklinski.clientsManagement.javaFX.modelFX.ContactStatusFX;
import pl.kuklinski.clientsManagement.javaFX.model.ContactStatusModel;

public class ContactStatusController {

    @FXML
    private MenuItem deleteStatus;
    @FXML
    private ListView<ContactStatusFX> statusListView;
    @FXML
    private Button addButton;
    @FXML
    private TextField statusField;

    private ContactStatusModel accStatusModel;

    public void initialize() {
        this.accStatusModel = new ContactStatusModel();
        this.accStatusModel.init();
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
        this.accStatusModel.accountStatusFXObjectPropertyy().get().contactStatusProperty().bind(this.statusField.textProperty());
        this.addButton.disableProperty().bind(this.statusField.textProperty().isEmpty());
        this.deleteStatus.disableProperty().bind(this.statusListView.getSelectionModel().selectedItemProperty().isNull());
    }

    private void bindingsListView() {
        this.statusListView.setItems(this.accStatusModel.getContactStatusFXObservableList());
        this.statusListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.accStatusModel.setAccountStatusFXObjectPropertyEdit(newValue);
        });
    }


    @FXML
    public void addAccStatus() {
        this.accStatusModel.saveStatusInDataBase();
        this.statusField.clear();
    }


    public void deleteStatusOnAction() {
        this.accStatusModel.deleteStatusInDataBase();
    }

    public void editStatus(ListView.EditEvent<ContactStatusFX> accountStatusFXEditEvent) {
        this.accStatusModel.getAccountStatusFXObjectPropertyEdit().setContactStatus(accountStatusFXEditEvent.getNewValue().getContactStatus());
        this.accStatusModel.updateStatusInDB();
    }

}
