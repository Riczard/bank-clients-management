package pl.kuklinski.clientsManagement.javaFX.model;

import pl.kuklinski.clientsManagement.database.dao.ClientDao;
import pl.kuklinski.clientsManagement.database.models.Client;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class ExportModel {
    public void exportClients() {
        ClientDao clientDao = new ClientDao();
        Stream<Client> clientStream = clientDao.queryForAll(Client.class);
        FileWriter csvWriter = null;
        try {
            csvWriter = new FileWriter("ClientsData");
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter finalCsvWriter = csvWriter;
        clientStream.forEach(client -> {
            try {
                assert finalCsvWriter != null;
                if (client.getName() != null) finalCsvWriter.append(client.getName());
                finalCsvWriter.append(";");
                if (client.getSurname() != null) finalCsvWriter.append(client.getSurname());
                finalCsvWriter.append(";");
                if (client.getPesel() != null) finalCsvWriter.append(client.getPesel());
                finalCsvWriter.append(";");
                if (client.getPhone() != null) finalCsvWriter.append(client.getPhone());
                finalCsvWriter.append(";");
                if (client.getOfferStatus() != null) finalCsvWriter.append(client.getOfferStatus().getTitle());
                finalCsvWriter.append(";");
                if (client.getRelation() != null) finalCsvWriter.append(client.getRelation().getTitle());
                finalCsvWriter.append(";");
                if (client.getStatus() != null) finalCsvWriter.append(client.getStatus().getTitle());
                finalCsvWriter.append(";");
                if(client.getLastContactDate() != null) finalCsvWriter.append(client.getLastContactDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                finalCsvWriter.append(";");
                if(client.getPlannedContactDate() != null) finalCsvWriter.append(client.getPlannedContactDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                finalCsvWriter.append(";");
                if (client.getComment() != null)finalCsvWriter.append(client.getComment());
                finalCsvWriter.append(";");
                if(client.getIncomeType() != null) finalCsvWriter.append(client.getIncomeType());
                finalCsvWriter.append(";");
                if(client.getVerificationDate() != null) finalCsvWriter.append(client.getVerificationDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                finalCsvWriter.append(";");
                if(client.getClickAmount() != null) finalCsvWriter.append(client.getClickAmount());
                finalCsvWriter.append(";");
                if(client.getConsolidationAmount() != null) finalCsvWriter.append(client.getConsolidationAmount());
                finalCsvWriter.append(";");
                if(client.getCity() != null) finalCsvWriter.append(client.getCity());
                finalCsvWriter.append(";");
                if(client.getAdviser() != null) {
                    finalCsvWriter.append(client.getAdviser().getName());
                    finalCsvWriter.append(" ");
                    finalCsvWriter.append(client.getAdviser().getSurname());
                }
                finalCsvWriter.append("\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
