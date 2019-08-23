package pl.kuklinski.clientsManagement.modelFX;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.kuklinski.clientsManagement.database.dao.AdviserDao;
import pl.kuklinski.clientsManagement.database.models.Adviser;
import pl.kuklinski.clientsManagement.utils.converters.AdviserConverter;

import java.util.stream.Stream;

public class AdviserModel {

    private ObjectProperty<AdviserFX> adviserFXObjectProperty = new SimpleObjectProperty<>(new AdviserFX());
    private ObjectProperty<AdviserFX> adviserFXObjectPropertyEdit = new SimpleObjectProperty<>(new AdviserFX());

    private ObservableList<AdviserFX> adviserFXObservableList = FXCollections.observableArrayList();

    public void init() {
        this.adviserFXObservableList.clear();
        addAdviserToObservableList();
    }

    private void addAdviserToObservableList() {
        AdviserDao adviserDao = new AdviserDao();
        Stream<Adviser> adviserStream = adviserDao.queryForAll(Adviser.class);
        adviserStream.forEach(adviser -> {
            AdviserFX adviserFX = AdviserConverter.convertToAdviserFx(adviser);
            this.adviserFXObservableList.add(adviserFX);
        });
        adviserDao.closeConnection();
    }

    public void saveAdviserInDataBase() {
        AdviserDao adviserDao = new AdviserDao();
        Adviser adviser = AdviserConverter.convertToAdviser(this.getAdviserFXObjectProperty());
        adviserDao.create(adviser);
        adviserDao.closeConnection();
        init();
    }

    public void deleteAdviserInDb() {
        AdviserDao adviserDao = new AdviserDao();
        adviserDao.delete(AdviserConverter.convertToAdviser(this.getAdviserFXObjectPropertyEdit()));
        adviserDao.closeConnection();
        init();
    }

    public AdviserFX getAdviserFXObjectProperty() {
        return adviserFXObjectProperty.get();
    }

    public ObjectProperty<AdviserFX> adviserFXObjectProperty() {
        return adviserFXObjectProperty;
    }

    public void setAdviserFXObjectProperty(AdviserFX adviserFXObjectProperty) {
        this.adviserFXObjectProperty.set(adviserFXObjectProperty);
    }

    public AdviserFX getAdviserFXObjectPropertyEdit() {
        return adviserFXObjectPropertyEdit.get();
    }

    public ObjectProperty<AdviserFX> adviserFXObjectPropertyEdit() {
        return adviserFXObjectPropertyEdit;
    }

    public void setAdviserFXObjectPropertyEdit(AdviserFX adviserFXObjectPropertyEdit) {
        this.adviserFXObjectPropertyEdit.set(adviserFXObjectPropertyEdit);
    }

    public ObservableList<AdviserFX> getAdviserFXObservableList() {
        return adviserFXObservableList;
    }

    public void setAdviserFXObservableList(ObservableList<AdviserFX> adviserFXObservableList) {
        this.adviserFXObservableList = adviserFXObservableList;
    }
}
