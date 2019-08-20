package pl.kuklinski.clientsManagement.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.util.ResourceBundle;

public class FXMLUtils {

    public static Pane fxmlLoader(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(FXMLUtils.class.getResource(fxmlPath));
        loader.setResources(getResourceBundle());
        try {
            return loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static FXMLLoader getLoader(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(FXMLUtils.class.getResource(fxmlPath));
        loader.setResources(getResourceBundle());
        return loader;
    }

    public static ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle("bundles.messages");
    }
}
