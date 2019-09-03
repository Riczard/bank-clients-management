package pl.kuklinski.clientsManagement.database.dbutils;

import pl.kuklinski.clientsManagement.database.dao.AccountStatusDao;
import pl.kuklinski.clientsManagement.database.dao.AdviserDao;
import pl.kuklinski.clientsManagement.database.dao.ClientDao;
import pl.kuklinski.clientsManagement.database.models.AccountStatus;
import pl.kuklinski.clientsManagement.database.models.Adviser;
import pl.kuklinski.clientsManagement.database.models.Client;
import pl.kuklinski.clientsManagement.utils.CSVUtils;
import pl.kuklinski.clientsManagement.utils.CommonUtils;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ImportClientFromCSV {

    private Map<String, String> columnsIndex;

    public ImportClientFromCSV(Map<String, String> columnsIndex) {
        this.columnsIndex = columnsIndex;
    }

    public void importClientToDB(File file) {
        ClientDao clientDao = new ClientDao();
        List<String[]> data = CSVUtils.getDataFromCSV(file);
        for (String[] clientInfo : data) {

            if(clientInfo.length > 0) {
                String pesel = getPesel(clientInfo);
                if(pesel != null) {
                    Client client = clientDao.findByPesel(pesel);
                    if (client == null) {
                        client = new Client();
                        setClientData(clientInfo, client);
                        clientDao.create(client);
                    } else {
                        setClientData(clientInfo, client);
                        clientDao.update(client);
                    }
                }
            }
        }
        clientDao.closeConnection();
    }

    private String getPesel(String[] clientInfo) {
        String peselIndex = CommonUtils.getKeyByValue(columnsIndex, "peselClient");
        if(Integer.parseInt(peselIndex) - 1 >= 0){
            return clientInfo[Integer.parseInt(peselIndex) - 1];
        }
        return null;
    }


    private void setClientData(String[] clientInfo, Client client) {
        for (int i = 0; i < clientInfo.length; i++) {
            String clientData = clientInfo[i];
            String key = String.valueOf(i + 1);
            String columnName = "";
            if(columnsIndex.containsKey(key)){
                columnName = columnsIndex.get(key);
            }

            switch (columnName) {
                case "nameClient":
                    client.setName(clientData);
                    break;
                case "surnameClient":
                    client.setSurname(clientData);
                    break;
                case "cityClient":
                    client.setCity(clientData);
                    break;
                case "phoneClient":
                    client.setPhone(clientData);
                    break;
                case "incomeClient":
                    client.setIncome(clientData);
                    break;
                case "peselClient":
                    client.setPesel(clientData);
                    break;
                case "relationClient":
                    client.setRelation(clientData);
                    break;
                case "clickAmountClient":
                    client.setClickAmount(clientData);
                    break;
                case "commentClient":
                    client.setComment(clientData);
                    break;
                case "lastContactDateClient":
                    if(clientData.contains("\".*\\\\d.*\""))
                    client.setLastContactDate(CommonUtils.convertStringToLocalDate(clientData));
                    break;
                case "verificationDateClient":
                    client.setVerificationDate(CommonUtils.convertStringToLocalDate(clientData));
                    break;
                case "adviserClient":
                    Adviser adviser = importAdviser(clientData);
                    client.setAdviser(adviser);
                    break;
                case "statusClient":
                    AccountStatus accountStatus = importClient(clientData);
                    client.setStatus(accountStatus);
                    break;
            }
        }
    }

    private AccountStatus importClient(String clientData) {
        AccountStatusDao accountStatusDao = new AccountStatusDao();
        AccountStatus status = accountStatusDao.findByName(clientData);
        if (status != null) {
            return status;
        } else {
            status = new AccountStatus();
            status.setTitle(clientData);
        }
        accountStatusDao.create(status);
        accountStatusDao.closeConnection();
        return status;
    }

    private Adviser importAdviser(String clientData) {
        String[] adviserData = clientData.split(" ");
        AdviserDao adviserDao = new AdviserDao();
        Adviser adviser = adviserDao.findByNameAndSurname(adviserData);
        if (adviser != null) {
            return adviser;
        } else {
            adviser = new Adviser();
            adviser.setName(adviserData[0]);
            adviser.setSurname(adviserData[1]);
        }
        adviserDao.create(adviser);
        adviserDao.closeConnection();
        return adviser;
    }
}
