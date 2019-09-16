package pl.kuklinski.clientsManagement.javaFX;

import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Optional;

public class LocalDateTableCell<T> extends TableCell<T, LocalDate> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
    private final DatePicker datePicker;

    public LocalDateTableCell(TableColumn<T, LocalDate> column) {
        this.datePicker = new DatePicker();
        this.datePicker.setConverter(new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate object) {
                String date = null;
                if (object != null) {
                    date = formatter.format(object);
                }
                return date;
            }

            @Override
            public LocalDate fromString(String string) {
                LocalDate date = null;
                if (!Optional.ofNullable(string).orElse("").isEmpty()) {
                    date = LocalDate.parse(string, formatter);
                }
                return date;
            }
        });

        this.datePicker.getEditor().focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                final TableView<T> tableView = getTableView();
                tableView.getSelectionModel().select(getTableRow().getIndex());
                tableView.edit(tableView.getSelectionModel().getSelectedIndex(), column);
            }
        });
        this.datePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (isEditing()) {
                commitEdit(newValue);
            }
        });
        editableProperty().bind(column.editableProperty());
        contentDisplayProperty().setValue(ContentDisplay.TEXT_ONLY);
    }

    @Override
    public void startEdit() {
        contentDisplayProperty().setValue(ContentDisplay.GRAPHIC_ONLY);
        super.startEdit();
    }

    @Override
    public void commitEdit(LocalDate newValue) {
        super.commitEdit(newValue);
        contentDisplayProperty().setValue(ContentDisplay.TEXT_ONLY);
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        contentDisplayProperty().setValue(ContentDisplay.TEXT_ONLY);
    }

    @Override
    protected void updateItem(LocalDate item, boolean empty) {

        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            this.datePicker.setValue(item);
            setGraphic(this.datePicker);
            if (item == null) {
                setText(null);
            } else {
                setText(formatter.format(item));
            }
        }
    }

}
