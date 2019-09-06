package pl.kuklinski.clientsManagement.javaFX.model;

import pl.kuklinski.clientsManagement.database.dao.*;
import pl.kuklinski.clientsManagement.database.models.*;
import pl.kuklinski.clientsManagement.utils.CommonUtils;

import java.util.List;
import java.util.Map;

public class ImportModel {

    private Map<String, String> columnsIndex;

    public ImportModel() {
    }

    public void setColumnsIndex(Map<String, String> columnsIndex) {
        this.columnsIndex = columnsIndex;
    }


    public void importToDB(List<String[]> dataFromCSV) {
        ClientDao clientDao = new ClientDao();
        for (String[] clientInfo : dataFromCSV) {
            String pesel = getPesel(clientInfo);
            if (pesel != null) {
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
        clientDao.closeConnection();
    }

    private String getPesel(String[] clientInfo) {
        String peselIndex = CommonUtils.getKeyByValue(columnsIndex, "pesel");
        if (peselIndex != null && Integer.parseInt(peselIndex) - 1 >= 0 && clientInfo.length > 0) {
            return clientInfo[Integer.parseInt(peselIndex) - 1];
        }
        return null;
    }

    private void setClientData(String[] clientInfo, Client client) {
        for (int i = 0; i < clientInfo.length; i++) {
            String clientData = clientInfo[i];
            String key = String.valueOf(i + 1);
            String columnName = "";
            if (columnsIndex.containsKey(key)) {
                columnName = columnsIndex.get(key);
            }
            switch (columnName) {
                case "name":
                    client.setName(clientData);
                    break;
                case "surname":
                    client.setSurname(clientData);
                    break;
                case "pesel":
                    client.setPesel(clientData);
                    break;
                case "phone":
                    client.setPhone(clientData);
                    break;
                case "offerStatus":
                    client.setOfferStatus(importOfferStatus(clientData));
                    break;
                case "relation":
                    client.setRelation(importRelation(clientData));
                    break;
                case "contactStatus":
                    client.setStatus(importClient(clientData));
                    break;
                case "lastContactDate":
                    client.setLastContactDate(CommonUtils.convertStringToLocalDate(clientData));
                    break;
                case "plannedContactDate":
                    client.setPlannedContactDate(CommonUtils.convertStringToLocalDate(clientData));
                    break;
                case "comment":
                    client.setComment(clientData);
                    break;
                case "incomeType":
                    client.setIncomeType(clientData);
                    break;
                case "verificationDate":
                    client.setVerificationDate(CommonUtils.convertStringToLocalDate(clientData));
                    break;
                case "clickAmount":
                    client.setClickAmount(clientData);
                    break;
                case "consolidationAmount":
                    client.setConsolidationAmount(clientData);
                    break;
                case "cityClient":
                    client.setCity(clientData);
                    break;
                case "source":
                    client.setSource(clientData);
                case "adviserClient":
                    client.setAdviser(importAdviser(clientData));
                    break;
            }
        }
    }

    private OfferStatus importOfferStatus(String clientData) {
        OfferStatusDao offerStatusDao = new OfferStatusDao();
        OfferStatus status = offerStatusDao.findByName(clientData);
        if (status == null) {
            status = new OfferStatus();
            status.setTitle(clientData);
            offerStatusDao.create(status);
        }
        offerStatusDao.closeConnection();
        return status;
    }

    private Relation importRelation(String clientData) {
        RelationDao relationDao = new RelationDao();
        Relation relation = relationDao.findByName(clientData);
        if (relation == null) {
            relation = new Relation();
            relation.setTitle(clientData);
            relationDao.create(relation);
        }
        relationDao.closeConnection();
        return relation;
    }

    private ContactStatus importClient(String clientData) {
        ContactStatusDao contactStatusDao = new ContactStatusDao();
        ContactStatus status = contactStatusDao.findByName(clientData);
        if (status == null) {
            status = new ContactStatus();
            status.setTitle(clientData);
            contactStatusDao.create(status);
        }
        contactStatusDao.closeConnection();
        return status;
    }

    private Adviser importAdviser(String clientData) {
        String[] adviserData = clientData.split(" ");
        AdviserDao adviserDao = new AdviserDao();
        Adviser adviser = adviserDao.findByNameAndSurname(adviserData);
        if (adviser != null) {
            adviser = new Adviser();
            adviser.setName(adviserData[0]);
            if (adviserData.length > 1) {
                adviser.setSurname(adviserData[1]);
            }
            adviserDao.create(adviser);
        }
        adviserDao.closeConnection();
        return adviser;
    }
}
