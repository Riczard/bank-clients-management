package pl.kuklinski.clientsManagement.javaFX.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import pl.kuklinski.clientsManagement.javaFX.modelFX.ClientFX;
import pl.kuklinski.clientsManagement.javaFX.modelFX.FilterFX;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterModel {

    private ObjectProperty<FilterFX> filterFXObjectProperty = new SimpleObjectProperty<>(new FilterFX());


    public List<ClientFX> filterClients(List<ClientFX> clientFxList) {
        if (!getFilterFXObjectProperty().generalFilterProperty().get().isEmpty()) {
            return filterPredicate(generalPredicate(), clientFxList);
        } else {
            return clientFxList;
        }
    }

    private List<ClientFX> filterPredicate(Predicate<ClientFX> predicate, List<ClientFX> clientFxList) {
        return clientFxList.stream().filter(predicate).collect(Collectors.toList());
    }

    private Predicate<ClientFX> generalPredicate() {
        return clientFX -> clientFX.toString().toLowerCase().contains(getFilterFXObjectProperty().getGeneralFilter().toLowerCase());
    }

    public FilterFX getFilterFXObjectProperty() {
        return filterFXObjectProperty.get();
    }

    public ObjectProperty<FilterFX> filterFXObjectProperty() {
        return filterFXObjectProperty;
    }

    public void setFilterFXObjectProperty(FilterFX filterFXObjectProperty) {
        this.filterFXObjectProperty.set(filterFXObjectProperty);
    }
}
