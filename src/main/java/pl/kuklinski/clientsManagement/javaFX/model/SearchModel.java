package pl.kuklinski.clientsManagement.javaFX.model;

import javafx.scene.control.Dialog;
import pl.kuklinski.clientsManagement.database.dao.ClientDao;
import pl.kuklinski.clientsManagement.database.models.Client;
import pl.kuklinski.clientsManagement.javaFX.modelFX.CreditFX;
import pl.kuklinski.clientsManagement.utils.CSVUtils;
import pl.kuklinski.clientsManagement.utils.DialogUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchModel {

    private File[] files;
    private static final int peselIndex = 0;
    private static final int preapprovedIndex = 1;
    private static final int consolidationIndex = 2;

    public void setDirectory(File directory) {
        this.files = directory.listFiles();
    }

    public String[][] search(CreditFX selectedItem) throws FileNotFoundException {
        String type = selectedItem.getType();
        String[][] result = new String[0][0];
        switch (type) {
            case "preapproved":
                result = searchForAmounts("preapproved");
                break;
            case "consolidation":
                result = searchForAmounts("Konsolidacja");
                break;
            case "creditAll":
                result = searchForAmounts("preapproved", "Konsolidacja");
                break;
        }
        return result;
    }

    private String[][] searchForAmounts(String... word) throws FileNotFoundException {
        String[][] result = new String[files.length][3];
            for(int i = 0; i < result.length; i++){
                File file = files[i];
                if(file.isFile()) {
                    result[i][0] = file.getName().replace(".txt","");
                    String stringFromFile  = CSVUtils.getStringFromFile(file).replaceAll("\\s+","");
                    result[i][1] = searchAmountByCreditType(stringFromFile, word[0]);
                    if(word.length > 1 ) {
                        result[i][2] = searchAmountByCreditType(stringFromFile, word[1]);
                    }
                }
            }
        return result;
    }

    public String searchAmountByCreditType(String data, String creditType) {
        DialogUtils.informationDialog(creditType);
        String regex = String.format(".*%s.*?Maksymalnakwota:(.*?zł)", creditType);
        DialogUtils.informationDialog(regex);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(data);
        if(m.find()) {
            return m.group(1);
        }
        return null;
    }

    public void createTxtFile(String[][] data) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("clickCheck_" + LocalDate.now());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        for(String[] singleData : data) {
            Objects.requireNonNull(printWriter).write(singleData[0]+";" + singleData[1] + ";" + singleData[2] + "\n");
        }
        Objects.requireNonNull(printWriter).close();
    }

    public void importToDB(String[][] data) {
        ClientDao clientDao = new ClientDao();
        for(String[] singleData : data) {
            Client client = clientDao.findByPesel(singleData[peselIndex]);
            if(client == null) {
                client = new Client();
                client.setPesel(singleData[peselIndex]);
                client.setClickAmount(singleData[preapprovedIndex]);
                client.setConsolidationAmount(singleData[consolidationIndex]);
                client.setVerificationDate(LocalDate.now());
                clientDao.create(client);
            }else {
                client.setClickAmount(singleData[preapprovedIndex]);
                client.setConsolidationAmount(singleData[consolidationIndex]);
                client.setVerificationDate(LocalDate.now());
                clientDao.update(client);
            }
        }
        clientDao.closeConnection();
    }
}
