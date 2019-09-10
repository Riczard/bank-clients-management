package pl.kuklinski.clientsManagement.javaFX.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.kuklinski.clientsManagement.database.dao.RelationDao;
import pl.kuklinski.clientsManagement.database.models.Relation;
import pl.kuklinski.clientsManagement.javaFX.modelFX.RelationFX;
import pl.kuklinski.clientsManagement.utils.converters.RelationConverter;

import java.util.stream.Stream;

public class RelationModel {

    private ObjectProperty<RelationFX> relationFXObjectProperty = new SimpleObjectProperty<>(new RelationFX());
    private ObjectProperty<RelationFX> relationFXObjectPropertyEdit = new SimpleObjectProperty<>(new RelationFX());
    private ObservableList<RelationFX> relationFXES = FXCollections.observableArrayList();

    public void init() {
        this.relationFXES.clear();
        addRelationToObsList();
    }

    private void addRelationToObsList() {
        RelationDao relationDao = new RelationDao();
        Stream<Relation> relationStream = relationDao.queryForAll(Relation.class);
        relationStream.forEach(relation -> {
            RelationFX relationFX = RelationConverter.convertToRelationFX(relation);
            this.relationFXES.add(relationFX);
        });
        relationDao.closeConnection();
    }

    public void saveRelationDB() {
        RelationDao relationDao = new RelationDao();
        Relation relation = RelationConverter.convertToRelation(this.getRelationFXObjectProperty());
        relationDao.create(relation);
        relationDao.closeConnection();
        init();
    }

    public void deleteRelationInDB() {
        RelationDao relationDao = new RelationDao();
        relationDao.delete(RelationConverter.convertToRelation(this.getRelationFXObjectPropertyEdit()));
        relationDao.closeConnection();
        init();
    }

    public void updateRelationInDB() {
        RelationDao relationDao = new RelationDao();
        relationDao.update(RelationConverter.convertToRelation(this.getRelationFXObjectPropertyEdit()));
        relationDao.closeConnection();
    }

    public RelationFX getRelationFXObjectProperty() {
        return relationFXObjectProperty.get();
    }

    public ObjectProperty<RelationFX> relationFXObjectProperty() {
        return relationFXObjectProperty;
    }

    public void setRelationFXObjectProperty(RelationFX relationFXObjectProperty) {
        this.relationFXObjectProperty.set(relationFXObjectProperty);
    }

    public RelationFX getRelationFXObjectPropertyEdit() {
        return relationFXObjectPropertyEdit.get();
    }

    public ObjectProperty<RelationFX> relationFXObjectPropertyEditProperty() {
        return relationFXObjectPropertyEdit;
    }

    public void setRelationFXObjectPropertyEdit(RelationFX relationFXObjectPropertyEdit) {
        this.relationFXObjectPropertyEdit.set(relationFXObjectPropertyEdit);
    }

    public ObservableList<RelationFX> getRelationFXES() {
        return relationFXES;
    }

    public void setRelationFXES(ObservableList<RelationFX> relationFXES) {
        this.relationFXES = relationFXES;
    }
}
