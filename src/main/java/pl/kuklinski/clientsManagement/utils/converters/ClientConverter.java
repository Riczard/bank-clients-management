package pl.kuklinski.clientsManagement.utils.converters;

import pl.kuklinski.clientsManagement.database.models.Client;
import pl.kuklinski.clientsManagement.modelFX.ClientFX;

public class ClientConverter {

    public static ClientFX convertToClientFX(Client client) {
        ClientFX clientFX = new ClientFX();
        clientFX.setId(client.getId());
        clientFX.setName(client.getName());
        clientFX.setPhone(client.getPhone());
        clientFX.setSurname(client.getSurname());
        clientFX.setCity(client.getCity());
        clientFX.setIncome(client.getIncome());
        clientFX.setRelation(client.getRelation());
        clientFX.setClickAmount(client.getClickAmount());
        clientFX.setComment(client.getComment());
        clientFX.setLastContactDate(client.getLastContactDate());
        clientFX.setVerificationDate(client.getVerificationDate());
        if(client.getStatus() != null) {
            clientFX.setAccountState(AccountStatusConverter.convertToAccStatusFX(client.getStatus()));
        }
        if(client.getAdviser() != null) {
            clientFX.setAdviser(AdviserConverter.convertToAdviserFx(client.getAdviser()));
        }
        return clientFX;
    }
}
