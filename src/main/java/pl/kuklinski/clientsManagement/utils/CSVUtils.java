package pl.kuklinski.clientsManagement.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    public static List<String[]> getDataFromCSV(File file, String delimiter) {
        String line;
        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                data.add(line.split(delimiter));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
