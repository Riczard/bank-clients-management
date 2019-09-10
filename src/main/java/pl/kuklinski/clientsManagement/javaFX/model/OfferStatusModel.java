package pl.kuklinski.clientsManagement.javaFX.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.kuklinski.clientsManagement.database.dao.OfferStatusDao;
import pl.kuklinski.clientsManagement.database.models.OfferStatus;
import pl.kuklinski.clientsManagement.javaFX.modelFX.OfferStatusFX;
import pl.kuklinski.clientsManagement.utils.converters.OfferStatusConverter;

import java.util.stream.Stream;

public class OfferStatusModel {

    private ObjectProperty<OfferStatusFX> offerStatusFXObjectProperty = new SimpleObjectProperty<>(new OfferStatusFX());
    private ObjectProperty<OfferStatusFX> offerStatusFXObjectPropertyEdit = new SimpleObjectProperty<>(new OfferStatusFX());
    private ObservableList<OfferStatusFX> offerStatusFXES = FXCollections.observableArrayList();

    public void init() {
        this.offerStatusFXES.clear();
        addOfferStatusToObsList();
    }

    private void addOfferStatusToObsList() {
        OfferStatusDao offerStatusDao = new OfferStatusDao();
        Stream<OfferStatus> offerStatusStream = offerStatusDao.queryForAll(OfferStatus.class);
        offerStatusStream.forEach(status -> {
            OfferStatusFX offerStatusFX = OfferStatusConverter.convertToOfferStatusFX(status);
            this.offerStatusFXES.add(offerStatusFX);
        });
        offerStatusDao.closeConnection();
    }

    public void saveStatusInDB() {
        OfferStatusDao offerStatusDao = new OfferStatusDao();
        OfferStatus offerStatus = OfferStatusConverter.convertToOfferStatus(this.getOfferStatusFXObjectProperty());
        offerStatusDao.create(offerStatus);
        offerStatusDao.closeConnection();
        init();
    }

    public void deleteStatusInDB() {
        OfferStatusDao offerStatusDao = new OfferStatusDao();
        offerStatusDao.delete(OfferStatusConverter.convertToOfferStatus(this.getOfferStatusFXObjectPropertyEdit()));
        offerStatusDao.closeConnection();
        init();
    }

    public void updateStatusInDB() {
        OfferStatusDao offerStatusDao = new OfferStatusDao();
        offerStatusDao.update(OfferStatusConverter.convertToOfferStatus(this.getOfferStatusFXObjectPropertyEdit()));
        offerStatusDao.closeConnection();
    }

    public OfferStatusFX getOfferStatusFXObjectProperty() {
        return offerStatusFXObjectProperty.get();
    }

    public ObjectProperty<OfferStatusFX> offerStatusFXObjectProperty() {
        return offerStatusFXObjectProperty;
    }

    public void setOfferStatusFXObjectProperty(OfferStatusFX offerStatusFXObjectProperty) {
        this.offerStatusFXObjectProperty.set(offerStatusFXObjectProperty);
    }

    public OfferStatusFX getOfferStatusFXObjectPropertyEdit() {
        return offerStatusFXObjectPropertyEdit.get();
    }

    public ObjectProperty<OfferStatusFX> offerStatusFXObjectPropertyEditProperty() {
        return offerStatusFXObjectPropertyEdit;
    }

    public void setOfferStatusFXObjectPropertyEdit(OfferStatusFX offerStatusFXObjectPropertyEdit) {
        this.offerStatusFXObjectPropertyEdit.set(offerStatusFXObjectPropertyEdit);
    }

    public ObservableList<OfferStatusFX> getOfferStatusFXES() {
        return offerStatusFXES;
    }

    public void setOfferStatusFXES(ObservableList<OfferStatusFX> offerStatusFXES) {
        this.offerStatusFXES = offerStatusFXES;
    }
}
