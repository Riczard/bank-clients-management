package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.StringConverter;
import pl.kuklinski.clientsManagement.modelFX.AccountStatusFX;
import pl.kuklinski.clientsManagement.modelFX.AccountStatusModel;

public class AccountStatusController {

    @FXML
    private MenuItem deleteStatus;
    @FXML
    private ListView<AccountStatusFX> statusListView;
    @FXML
    private Button addButton;
    @FXML
    private TextField statusField;

    private AccountStatusModel accStatusModel;

    public void initialize() {
        this.accStatusModel = new AccountStatusModel();
        this.accStatusModel.init();
        bindings();
        bindingsListView();

        setOnEditCells();
    }

    private void setOnEditCells() {
        statusListView.setCellFactory(TextFieldListCell.forListView(new StringConverter<AccountStatusFX>() {
            @Override
            public String toString(AccountStatusFX object) {
                return object.getAccountStatus();
            }

            @Override
            public AccountStatusFX fromString(String string) {
                AccountStatusFX accountStatusFX = new AccountStatusFX();
                accountStatusFX.setAccountStatus(string);
                return accountStatusFX;
            }
        }));
    }

    private void bindings() {
        this.accStatusModel.accountStatusFXObjectPropertyy().get().accountStatusProperty().bind(this.statusField.textProperty());
        this.addButton.disableProperty().bind(this.statusField.textProperty().isEmpty());
        this.deleteStatus.disableProperty().bind(this.statusListView.getSelectionModel().selectedItemProperty().isNull());
    }

    private void bindingsListView() {
        this.statusListView.setItems(this.accStatusModel.getAccountStatusFXObservableList());
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

    public void editStatus(ListView.EditEvent<AccountStatusFX> accountStatusFXEditEvent) {
        this.accStatusModel.getAccountStatusFXObjectPropertyEdit().setAccountStatus(accountStatusFXEditEvent.getNewValue().getAccountStatus());
        this.accStatusModel.updateStatusInDB();
    }

}
