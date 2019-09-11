package pl.kuklinski.clientsManagement.utils.converters;

import pl.kuklinski.clientsManagement.database.models.Client;
import pl.kuklinski.clientsManagement.javaFX.modelFX.ClientFX;
import pl.kuklinski.clientsManagement.utils.CommonUtils;

public class ClientConverter {

    public static ClientFX convertToClientFX(Client client) {
        ClientFX clientFX = new ClientFX();
        clientFX.setId(client.getId());
        clientFX.setName(client.getName());
        clientFX.setSurname(client.getSurname());
        clientFX.setPesel(client.getPesel());
        if(client.getPhone() != null) {
            clientFX.setPhone(CommonUtils.insert(client.getPhone(), " ", 3));
        }
        if (client.getOfferStatus() != null) {
            clientFX.setOfferStatus(OfferStatusConverter.convertToOfferStatusFX(client.getOfferStatus()));
        }
        if (client.getRelation() != null) {
            clientFX.setRelation(RelationConverter.convertToRelationFX(client.getRelation()));
        }
        if (client.getStatus() != null) {
            clientFX.setContactStatus(ContactStatusConverter.convertToAccStatusFX(client.getStatus()));
        }
        clientFX.setLastContactDate(client.getLastContactDate());
        clientFX.setPlannedDate(client.getPlannedContactDate());
        clientFX.setComment(client.getComment());
        clientFX.setIncomeType(client.getIncomeType());
        clientFX.setVerificationDate(client.getVerificationDate());
        clientFX.setClickAmount(client.getClickAmount());
        clientFX.setConsolidationAmount(client.getConsolidationAmount());
        clientFX.setCity(client.getCity());
        clientFX.setSource(client.getSource());
        if (client.getAdviser() != null) {
            clientFX.setAdviser(AdviserConverter.convertToAdviserFx(client.getAdviser()));
        }
        return clientFX;
    }


    public static Client convertToClient(ClientFX clientFX) {
        Client client = new Client();
        client.setId(clientFX.getId());
        client.setName(clientFX.getName());
        client.setSurname(clientFX.getSurname());
        client.setPesel(clientFX.getPesel());
        if(clientFX.getPhone() != null){
            client.setPhone(clientFX.getPhone().replaceAll(" ", ""));
        }
        if (clientFX.getOfferStatus() != null) {
            client.setOfferStatus(OfferStatusConverter.convertToOfferStatus(clientFX.getOfferStatus()));
        }
        if (clientFX.getRelation() != null) {
            client.setRelation(RelationConverter.convertToRelation(clientFX.getRelation()));
        }
        if (clientFX.getContactStatus() != null) {
            client.setStatus(ContactStatusConverter.convertToContactStatus(clientFX.getContactStatus()));
        }
        client.setLastContactDate(clientFX.getLastContactDate());
        client.setPlannedContactDate(clientFX.getPlannedDate());
        client.setComment(clientFX.getComment());
        client.setIncomeType(clientFX.getIncomeType());
        client.setVerificationDate(clientFX.getVerificationDate());
        client.setClickAmount(clientFX.getClickAmount());
        client.setConsolidationAmount(clientFX.getConsolidationAmount());
        client.setCity(clientFX.getCity());
        client.setSource(clientFX.getSource());
        if (clientFX.getAdviser() != null) {
            client.setAdviser(AdviserConverter.convertToAdviser(clientFX.getAdviser()));
        }
        return client;
    }
}
