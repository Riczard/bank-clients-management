package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pl.kuklinski.clientsManagement.javaFX.model.ClientModel;
import pl.kuklinski.clientsManagement.javaFX.modelFX.AdviserFX;
import pl.kuklinski.clientsManagement.javaFX.modelFX.ContactStatusFX;
import pl.kuklinski.clientsManagement.javaFX.modelFX.OfferStatusFX;
import pl.kuklinski.clientsManagement.javaFX.modelFX.RelationFX;

public class ClientController {

    @FXML
    private Button addButton;

    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField peselField;
    @FXML
    private TextField phoneField;
    @FXML
    private ComboBox<OfferStatusFX> statusOfferField;
    @FXML
    private ComboBox<RelationFX> relationField;
    @FXML
    private ComboBox<ContactStatusFX> contactStatusField;
    @FXML
    private DatePicker lastContactField;
    @FXML
    private DatePicker plannedDateField;
    @FXML
    private TextArea commentField;
    @FXML
    private TextField incomeTypeField;
    @FXML
    private TextField cityField;
    @FXML
    private ComboBox<AdviserFX> adviserField;

    private ClientModel clientModel;

    @FXML
    public void initialize() {
        this.clientModel = new ClientModel();
        this.clientModel.init();
        setItemsToComboBox();
        bindings();
//        validation();
    }

    private void setItemsToComboBox() {
        this.adviserField.setItems(this.clientModel.getAdviserFXES());
        this.statusOfferField.setItems(this.clientModel.getOfferStatusFXES());
        this.contactStatusField.setItems(this.clientModel.getContactStatusFXES());
        this.relationField.setItems(this.clientModel.getRelationFXES());
    }

    private void bindings() {
        this.clientModel.getClientFXObjectProperty();
//        this.accStatusComboBox.valueProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().accountStatusProperty());
//        this.adviserComboBox.valueProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().adviserProperty());
        this.nameField.textProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().nameProperty());
        this.surnameField.textProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().surnameProperty());
//        this.commentArea.textProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().commentProperty());
        this.peselField.textProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().peselProperty());
//        this.relationField.textProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().relationProperty());
//        this.lastContactDate.valueProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().lastContactDateProperty());
//        this.verificationDate.valueProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().verificationDateProperty());
        this.phoneField.textProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().phoneProperty());
//        this.incomeField.textProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().incomeTypeProperty());
//        this.cityField.textProperty().bindBidirectional(this.clientModel.getClientFXObjectProperty().cityProperty());
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
        Stage window = (Stage) addButton.getScene().getWindow();
        window.close();
    }

}
