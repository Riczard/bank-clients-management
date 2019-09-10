package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.StringConverter;
import pl.kuklinski.clientsManagement.javaFX.model.RelationModel;
import pl.kuklinski.clientsManagement.javaFX.modelFX.RelationFX;

public class RelationController {

    @FXML
    private TextField relationField;
    @FXML
    private Button addButton;
    @FXML
    private MenuItem deleteRelation;
    @FXML
    private ListView<RelationFX> relationList;

    private RelationModel relationModel;

    @FXML
    public void initialize() {
        this.relationModel = new RelationModel();
        this.relationModel.init();
        bindings();
        bindingsListView();
        setOnEditCells();
    }

    private void bindings() {
        this.relationModel.relationFXObjectProperty().get().titleProperty().bind(this.relationField.textProperty());
        this.addButton.disableProperty().bind(relationField.textProperty().isEmpty());
        this.deleteRelation.disableProperty().bind(relationList.getSelectionModel().selectedItemProperty().isNull());
    }

    private void bindingsListView() {
        this.relationList.setItems(this.relationModel.getRelationFXES());
        this.relationList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.relationModel.setRelationFXObjectPropertyEdit(newValue);
        });
    }

    private void setOnEditCells() {
        relationList.setCellFactory(TextFieldListCell.forListView(new StringConverter<RelationFX>() {
            @Override
            public String toString(RelationFX object) {
                return object.toString();
            }

            @Override
            public RelationFX fromString(String string) {
                RelationFX relationFX = new RelationFX();
                relationFX.setTitle(string);
                return relationFX;
            }
        }));
    }

    @FXML
    public void addRelation() {
        this.relationModel.saveRelationDB();
        this.relationField.clear();
    }

    @FXML
    public void deleteRelationOnAction() {
        this.relationModel.deleteRelationInDB();
    }

    @FXML
    public void editRelation(ListView.EditEvent<RelationFX> event) {
        this.relationModel.getRelationFXObjectPropertyEdit().setTitle(event.getNewValue().getTitle());
        this.relationModel.updateRelationInDB();
    }
}
