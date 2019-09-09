package pl.kuklinski.clientsManagement.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public static String getStringFromFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();
//        scanner.useDelimiter("");
        while (scanner.hasNext()) {
            sb.append(scanner.next());
        }
        return sb.toString();
    }
}
