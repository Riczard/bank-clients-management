package pl.kuklinski.clientsManagement.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class CommonUtils {

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static LocalDate convertStringToLocalDate(String date) {
        System.out.println(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        formatter = formatter.withLocale(Locale.getDefault());
        return LocalDate.parse(date, formatter);
    }

}
