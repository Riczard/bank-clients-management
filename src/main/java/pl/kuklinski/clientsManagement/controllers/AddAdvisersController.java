package pl.kuklinski.clientsManagement.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pl.kuklinski.clientsManagement.database.dao.AdviserDao;
import pl.kuklinski.clientsManagement.modelFX.AdviserFX;
import pl.kuklinski.clientsManagement.modelFX.AdviserModel;

public class AddAdvisersController {

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
        bindingTableView();
    }

    private void bindingTableView() {
        this.adviserTableView.setItems(this.adviserModel.getAdviserFXObservableList());
    }


    public void addAdviser() {
        this.adviserModel.saveAdviserInDataBase();
        this.adviserNameField.clear();
        this.adviserSurnameField.clear();
    }


    public void deleteAdviser() {
        this.adviserModel.deleteAdviserInDb();
    }
}
