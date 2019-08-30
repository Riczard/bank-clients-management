package pl.kuklinski.clientsManagement.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import pl.kuklinski.clientsManagement.modelFX.AccountStatusFX;
import pl.kuklinski.clientsManagement.modelFX.AdviserFX;
import pl.kuklinski.clientsManagement.modelFX.ClientModel;

public class ClientController {

    @FXML
    private TextField nameField;
    @FXML
    private Button addButton;
    @FXML
    private TextArea commentArea;
    @FXML
    private ComboBox<AdviserFX> adviserComboBox;
    @FXML
    private DatePicker lastContactDate;
    @FXML
    private DatePicker verificationDate;
    @FXML
    private ComboBox<AccountStatusFX> accStatusComboBox;
    @FXML
    private TextField relationField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField incomeField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField peselField;
    @FXML
    private TextField surnameField;

    private ClientModel clientModel;

    @FXML
    public void initialize() {
        this.clientModel = new ClientModel();
        this.clientModel.init();

        this.adviserComboBox.setItems(this.clientModel.getAdviserFXObservableList());
        this.accStatusComboBox.setItems(this.clientModel.getAccountStatusFXObservableList());
        
        bindings();
        validation();
    }

    private void bindings() {
        this.clientModel.getClientFXObjectProperty();
        this.accStatusComboBox.valueProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().accountStatusProperty());
        this.adviserComboBox.valueProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().adviserProperty());
        this.nameField.textProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().nameProperty());
        this.surnameField.textProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().surnameProperty());
        this.commentArea.textProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().commentProperty());
        this.peselField.textProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().peselProperty());
        this.relationField.textProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().peselProperty());
        this.lastContactDate.valueProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().lastContactDateProperty());
        this.verificationDate.valueProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().verificationDateProperty());
        this.phoneField.textProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().phoneProperty());
        this.incomeField.textProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().incomeProperty());
        this.cityField.textProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().cityProperty());
    }

    private void validation() {
        this.addButton.disableProperty().bind(this.nameField.textProperty().isEmpty()
                .or(this.surnameField.textProperty().isEmpty())
                .or(this.nameField.textProperty().isEmpty())
                .or(this.peselField.textProperty().isEmpty())
        );
    }

    @FXML
    public void addClient() {
        this.clientModel.saveClientInDataBase();
    }
}
