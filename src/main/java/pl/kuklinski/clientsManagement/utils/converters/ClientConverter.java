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
        clientFX.setPesel(client.getPesel());
        clientFX.setIncome(client.getIncome());
        clientFX.setRelation(client.getRelation());
        clientFX.setClickAmount(client.getClickAmount());
        clientFX.setComment(client.getComment());
        clientFX.setLastContactDate(client.getLastContactDate());
        clientFX.setVerificationDate(client.getVerificationDate());
        if (client.getStatus() != null) {
            clientFX.setAccountStatus(AccountStatusConverter.convertToAccStatusFX(client.getStatus()));
        }
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
        client.setPhone(clientFX.getPhone());
        client.setCity(clientFX.getCity());
        client.setIncome(clientFX.getIncome());
        client.setRelation(clientFX.getRelation());
        client.setClickAmount(clientFX.getClickAmount());
        client.setComment(clientFX.getComment());
        client.setLastContactDate(clientFX.getLastContactDate());
        client.setVerificationDate(clientFX.getVerificationDate());
        if (clientFX.getAccountStatus() != null) {
            client.setStatus(AccountStatusConverter.convertToAccStatus(clientFX.getAccountStatus()));
        }
        if (clientFX.getAdviser() != null) {
            client.setAdviser(AdviserConverter.convertToAdviser(clientFX.getAdviser()));
        }
        return client;
    }
}
