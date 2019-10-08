package pl.kuklinski.clientsManagement.javaFX.model;

import pl.kuklinski.clientsManagement.database.dao.ClientDao;
import pl.kuklinski.clientsManagement.database.models.Client;
import pl.kuklinski.clientsManagement.utils.DialogUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

public class ExportModel {

    private List<String> fieldsToImport;

    public void saveAsCsv(File file) throws IOException {
        ClientDao clientDao = new ClientDao();
        Stream<Client> clientStream = clientDao.queryForAll(Client.class);
        FileWriter csvWriter = null;
        try {
            csvWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter finalCsvWriter = csvWriter;
        assert finalCsvWriter != null;
        clientStream.forEach(client -> {
            try {
                finalCsvWriter.append(getClientData(client));
                finalCsvWriter.append("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        finalCsvWriter.flush();
        finalCsvWriter.close();
        clientDao.closeConnection();
    }


    public void exportData(List<String> fieldsToImport) throws IOException {
        this.fieldsToImport = fieldsToImport;
        File file = DialogUtils.setFileInFileChooser();
        saveAsCsv(file);

    }

    private String getClientData(Client client) {
        StringBuilder sb = new StringBuilder();

        for (String fieldName : fieldsToImport) {
            sb.append(getClientDataByField(fieldName, client));
            sb.append(";");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private String getClientDataByField(String fieldName, Client client) {

        switch (fieldName) {
            case "name":
                return client.getName() != null ? client.getName() : "";
            case "surname":
                return client.getSurname() != null ? client.getSurname() : "";
            case "pesel":
                return client.getPesel() != null ? client.getPesel() : "";
            case "statusOffer":
                return client.getOfferStatus() != null ? client.getOfferStatus().getTitle() : "";
            case "contactStatus":
                return client.getStatus() != null ? client.getStatus().getTitle() : "";
            case "plannedDate":
                return client.getPlannedContactDate() != null ? client.getPlannedContactDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) : "";
            case "incomeType":
                return client.getIncomeType() != null ? client.getIncomeType() : "";
            case "clickAmount":
                return client.getClickAmount() != null ? client.getClickAmount() : "";
            case "city":
                return client.getCity() != null ? client.getCity() : "";
            case "phone":
                return client.getPhone() != null ? client.getPhone() : "";
            case "relation":
                return client.getRelation() != null ? client.getRelation().getTitle() : "";
            case "lastContactDate":
                return client.getLastContactDate() != null ? client.getLastContactDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) : "";
            case "comment":
                return client.getComment() != null ? client.getComment() : "";
            case "verificationDate":
                return client.getVerificationDate() != null ? client.getVerificationDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) : "";
            case "consolidationAmount":
                return client.getConsolidationAmount() != null ? client.getConsolidationAmount() : "";
            case "source":
                return client.getSource() != null ? client.getSource() : "";
            case "adviser":
                return client.getAdviser() != null ? client.getAdviser().getAdviserFullName() : "";
            default:
                return "";
        }
    }

}
