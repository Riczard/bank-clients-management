package pl.kuklinski.clientsManagement.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if(date.equals("0")){
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        formatter = formatter.withLocale(Locale.getDefault());
        return LocalDate.parse(date, formatter);
    }

    public static String insert(String text, String insert, int period) {
        String regex = String.format("(.{%s})", period);
        Pattern p = Pattern.compile(regex, Pattern.DOTALL);
        Matcher m = p.matcher(text);
        return m.replaceAll("$1" + insert);
    }

}
