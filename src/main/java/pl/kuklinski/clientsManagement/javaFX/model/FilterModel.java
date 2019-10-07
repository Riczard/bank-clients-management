package pl.kuklinski.clientsManagement.javaFX.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import pl.kuklinski.clientsManagement.javaFX.modelFX.ClientFX;
import pl.kuklinski.clientsManagement.javaFX.modelFX.FilterFX;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;
import static org.apache.commons.lang3.StringUtils.substringBefore;

public class FilterModel {

    private ObjectProperty<FilterFX> filterFXObjectProperty = new SimpleObjectProperty<>(new FilterFX());

    public List<ClientFX> filterClients(List<ClientFX> clientFxList) {
        if (!getFilterFXObjectProperty().generalFilterProperty().get().isEmpty()) {
            return filterPredicate(generalPredicate(), clientFxList);
        } else if (getFilterFXObjectProperty().getGeneralFilter().isEmpty()) {
            return filterPredicate(predicateRelation()
                            .and(predicateOfferStatus()
                                    .and(predicateContactStatus())
                                    .and(sourcePredicate())
                                    .and(clickAmountGreaterThanPredicate())
                                    .and(consolidationAmountGreaterThanPredicate()))
                    , clientFxList);
        }
        return clientFxList;
    }

    private List<ClientFX> filterPredicate(Predicate<ClientFX> predicate, List<ClientFX> clientFxList) {
        return clientFxList.stream().filter(predicate).collect(Collectors.toList());
    }

    private Predicate<ClientFX> predicateRelation() {
        return clientFX -> getFilterFXObjectProperty().getRelationFx().getTitle() == null
                || clientFX.getRelation() != null
                && clientFX.getRelation().getId() == getFilterFXObjectProperty().getRelationFx().getId();
    }

    private Predicate<ClientFX> predicateOfferStatus() {
        return clientFX -> getFilterFXObjectProperty().getOfferStatusFx().getTitle() == null
                || clientFX.getOfferStatus() != null
                && clientFX.getOfferStatus().getId() == getFilterFXObjectProperty().getOfferStatusFx().getId();
    }

    private Predicate<ClientFX> predicateContactStatus() {
        return clientFX -> getFilterFXObjectProperty().getContactStatusFx().getContactStatus() == null
                || clientFX.getContactStatus() != null
                && clientFX.getContactStatus().getId() == getFilterFXObjectProperty().getContactStatusFx().getId();
    }

    private Predicate<ClientFX> generalPredicate() {
//        return clientFX -> clientFX.toString().toLowerCase().contains(getFilterFXObjectProperty().getGeneralFilter());
        return clientFX -> containsIgnoreCase(clientFX.toString(), getFilterFXObjectProperty().getGeneralFilter());
    }

    private Predicate<ClientFX> sourcePredicate() {
        return clientFX -> getFilterFXObjectProperty().getSource().isEmpty()
                || clientFX.getSource() != null
                && clientFX.getSource().equalsIgnoreCase(getFilterFXObjectProperty().getSource());
    }

    private Predicate<ClientFX> clickAmountGreaterThanPredicate() {
        return clientFX -> getFilterFXObjectProperty().getClickAmount().isEmpty()
                || clientFX.getClickAmount() != null
                && Integer.parseInt(substringBefore(clientFX.getClickAmount(), ","))
                >= Integer.parseInt(substringBefore(getFilterFXObjectProperty().getClickAmount(), ","));
    }

    private Predicate<ClientFX> consolidationAmountGreaterThanPredicate() {
        return clientFX -> getFilterFXObjectProperty().getConsolidationAmount().isEmpty()
                || clientFX.getConsolidationAmount() != null
                && Integer.parseInt(substringBefore(clientFX.getConsolidationAmount(), ","))
                >= Integer.parseInt(substringBefore(getFilterFXObjectProperty().getConsolidationAmount(), ","));
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
