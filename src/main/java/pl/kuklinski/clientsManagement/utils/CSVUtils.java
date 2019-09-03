package pl.kuklinski.clientsManagement.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    public static List<String[]> getDataFromCSV(File file) {
        String line = "";
        String csvSplitBy = ";";
        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((line = br.readLine()) != null) {
                data.add(line.split(csvSplitBy));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
