package pl.kuklinski.clientsManagement.utils;

import javafx.scene.control.TextFormatter;

import java.text.DecimalFormat;
import java.text.ParsePosition;

public class Formatters {

    private static DecimalFormat format = new DecimalFormat("#.0");

    public static TextFormatter<Object> setFieldOnlyNumeric() {
        return new TextFormatter<>(c -> {
            if (c.getControlNewText().isEmpty()) {
                return c;
            }
            ParsePosition parsePosition = new ParsePosition(0);
            Object object = format.parse(c.getControlNewText(), parsePosition);

            if (object == null || parsePosition.getIndex() < c.getControlNewText().length()) {
                return null;
            } else {
                return c;
            }
        });
    }
}
