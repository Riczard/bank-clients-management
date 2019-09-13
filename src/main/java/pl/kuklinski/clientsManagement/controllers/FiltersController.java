package pl.kuklinski.clientsManagement.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import pl.kuklinski.clientsManagement.database.dao.ContactStatusDao;
import pl.kuklinski.clientsManagement.database.dao.OfferStatusDao;
import pl.kuklinski.clientsManagement.database.dao.RelationDao;
import pl.kuklinski.clientsManagement.database.models.ContactStatus;
import pl.kuklinski.clientsManagement.database.models.OfferStatus;
import pl.kuklinski.clientsManagement.database.models.Relation;
import pl.kuklinski.clientsManagement.javaFX.model.FilterModel;
import pl.kuklinski.clientsManagement.javaFX.modelFX.ClientFX;
import pl.kuklinski.clientsManagement.javaFX.modelFX.ContactStatusFX;
import pl.kuklinski.clientsManagement.javaFX.modelFX.OfferStatusFX;
import pl.kuklinski.clientsManagement.javaFX.modelFX.RelationFX;
import pl.kuklinski.clientsManagement.utils.Formatters;
import pl.kuklinski.clientsManagement.utils.converters.ContactStatusConverter;
import pl.kuklinski.clientsManagement.utils.converters.OfferStatusConverter;
import pl.kuklinski.clientsManagement.utils.converters.RelationConverter;

import java.util.List;
import java.util.stream.Stream;

public class FiltersController {

    @FXML
    private ComboBox<RelationFX> relationComboBox;
    @FXML
    private ComboBox<OfferStatusFX> offerStatusComboBox;
    @FXML
    private ComboBox<ContactStatusFX> contactStatusComboBox;
    @FXML
    private TextField consolidationAmountField;
    @FXML
    private TextField clickAmountField;
    @FXML
    private GridPane filtersPane;
    @FXML
    private TextField generalFilter;
    @FXML
    private TextField sourceFilter;

    private ListClientsController listClientsController;

    private FilterModel filterModel;

    @FXML
    public void initialize() {
        this.filterModel = new FilterModel();
        bindings();
        setTextFormatters();
        initComboBoxes();
    }

    private void bindings() {
        this.filterModel.getFilterFXObjectProperty().generalFilterProperty().bind(this.generalFilter.textProperty());
        this.filterModel.getFilterFXObjectProperty().relationFxProperty().bind(this.relationComboBox.valueProperty());
        this.filterModel.getFilterFXObjectProperty().offerStatusFxProperty().bind(this.offerStatusComboBox.valueProperty());
        this.filterModel.getFilterFXObjectProperty().contactStatusFxProperty().bind(this.contactStatusComboBox.valueProperty());
        this.filterModel.getFilterFXObjectProperty().consolidationAmountProperty().bind(this.consolidationAmountField.textProperty());
        this.filterModel.getFilterFXObjectProperty().clickAmountProperty().bind(this.clickAmountField.textProperty());
        this.filterModel.getFilterFXObjectProperty().sourceProperty().bind(this.sourceFilter.textProperty());
    }

    private void setTextFormatters() {
        clickAmountField.setTextFormatter(Formatters.setFieldOnlyNumeric());
        consolidationAmountField.setTextFormatter(Formatters.setFieldOnlyNumeric());
    }

    private void initComboBoxes() {
        initRelationComboBox();
        initOfferStatusComboBox();
        initContactStatusComboBox();
    }

    private void initRelationComboBox() {
        relationComboBox.getItems().add(new RelationFX());
        relationComboBox.getSelectionModel().selectFirst();
        RelationDao relationDao = new RelationDao();
        Stream<Relation> relationStream = relationDao.queryForAll(Relation.class);
        relationStream.forEach(relation -> relationComboBox.getItems().add(RelationConverter.convertToRelationFX(relation)));
        relationDao.closeConnection();
    }

    private void initOfferStatusComboBox() {
        offerStatusComboBox.getItems().add(new OfferStatusFX());
        offerStatusComboBox.getSelectionModel().selectFirst();
        OfferStatusDao offerStatusDao = new OfferStatusDao();
        Stream<OfferStatus> statusStream = offerStatusDao.queryForAll(OfferStatus.class);
        statusStream.forEach(status -> offerStatusComboBox.getItems().add(OfferStatusConverter.convertToOfferStatusFX(status)));
        offerStatusDao.closeConnection();
    }

    private void initContactStatusComboBox() {
        contactStatusComboBox.getItems().add(new ContactStatusFX());
        contactStatusComboBox.getSelectionModel().selectFirst();
        ContactStatusDao contactStatusDao = new ContactStatusDao();
        Stream<ContactStatus> statusStream = contactStatusDao.queryForAll(ContactStatus.class);
        statusStream.forEach(status -> contactStatusComboBox.getItems().add(ContactStatusConverter.convertToAccStatusFX(status)));
        contactStatusDao.closeConnection();
    }

    @FXML
    public void showOrHideFilters() {
        filtersPane.setVisible(!filtersPane.visibleProperty().get());
        filtersPane.setDisable(!filtersPane.disableProperty().get());
    }

    @FXML
    public void filterClients() {
        List<ClientFX> filteredList = filterModel.filterClients(listClientsController.getClientFxList());
        listClientsController.setClientFxList(filteredList);
    }

    @FXML
    public void setListClientsController(ListClientsController listClientsController) {
        this.listClientsController = listClientsController;
    }

    @FXML
    public void clearFilters() {
        relationComboBox.getSelectionModel().selectFirst();
        contactStatusComboBox.getSelectionModel().selectFirst();
        offerStatusComboBox.getSelectionModel().selectFirst();
        sourceFilter.clear();
        clickAmountField.clear();
        consolidationAmountField.clear();
        listClientsController.getListClientsModel().init();
    }
}
