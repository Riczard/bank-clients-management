package pl.kuklinski.clientsManagement;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pl.kuklinski.clientsManagement.utils.FXMLUtils;

public class Main extends Application {

    private static final String BORDER_PANE_MAIN_FXML = "/fxml/BorderPaneMain.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Pane borderPane = FXMLUtils.fxmlLoader(BORDER_PANE_MAIN_FXML);
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle(FXMLUtils.getResourceBundle().getString("title.application"));
        primaryStage.show();
    }
}
