package pl.kuklinski.clientsManagement.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import pl.kuklinski.clientsManagement.database.dao.AdviserDao;
import pl.kuklinski.clientsManagement.modelFX.AdviserFX;
import pl.kuklinski.clientsManagement.modelFX.AdviserModel;

public class AdvisersController {

    @FXML
    private Button addButton;
    @FXML
    private TableView<AdviserFX> adviserTableView;
    @FXML
    private TextField adviserSurnameField;
    @FXML
    private TextField adviserNameField;
    @FXML
    private MenuItem deleteMenuItem;
    @FXML
    private TableColumn<AdviserFX, String> nameAdviserColumn;
    @FXML
    private TableColumn<AdviserFX, String> surnameAdviserColumn;

    private AdviserModel adviserModel;

    public void initialize() {
        this.adviserModel = new AdviserModel();
        this.adviserModel.init();
        bindings();
        bindingTableView();
    }

    private void bindings() {
        this.adviserModel.adviserFXObjectProperty().get().nameProperty().bind(this.adviserNameField.textProperty());
        this.adviserModel.adviserFXObjectProperty().get().surnameProperty().bind(this.adviserSurnameField.textProperty());
        this.addButton.disableProperty().bind(this.adviserNameField.textProperty().isEmpty()
                .or(this.adviserSurnameField.textProperty().isEmpty()));
        this.deleteMenuItem.disableProperty().bind(this.adviserTableView.getSelectionModel().selectedItemProperty().isNull());
    }

    private void bindingTableView() {
        this.adviserTableView.setItems(this.adviserModel.getAdviserFXObservableList());
        this.nameAdviserColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        this.surnameAdviserColumn.setCellValueFactory(cellData ->cellData.getValue().surnameProperty());

        this.nameAdviserColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.surnameAdviserColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        this.adviserTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.adviserModel.setAdviserFXObjectPropertyEdit(newValue);
        });
    }


    public void addAdviser() {
        this.adviserModel.saveAdviserInDataBase();
        this.adviserNameField.clear();
        this.adviserSurnameField.clear();
    }


    public void deleteAdviser() {
        this.adviserModel.deleteAdviserInDb();
    }


    public void editName(TableColumn.CellEditEvent<AdviserFX, String> adviserFXStringCellEditEvent) {
        this.adviserModel.getAdviserFXObjectProperty().setName(adviserFXStringCellEditEvent.getNewValue());
        this.adviserModel.saveAdviserInDataBase();
    }

    public void editSurname(TableColumn.CellEditEvent<AdviserFX, String> adviserFXStringCellEditEvent) {
        this.adviserModel.getAdviserFXObjectProperty().setSurname(adviserFXStringCellEditEvent.getNewValue());
        this.adviserModel.saveAdviserInDataBase();
    }
}
