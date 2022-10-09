package kristina.project.zoo.controllers;

import kristina.project.zoo.MainWindow;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Windows {

    public static Map <Status, String> resources = new HashMap<>();
    public static Status curStatus = null;
    static Status prevStatus = null;

    public static void windowsInitialize() {
        resources.put(Status.main, "Main.fxml");
        resources.put(Status.other, "Other.fxml");
        resources.put(Status.Admin, "Administration.fxml");
        resources.put(Status.tables, "Table.fxml");
        resources.put(Status.withoutparam, "Without.fxml");
        resources.put(Status.del, "Del.fxml");
    }
    public static void setStatus(Status status) {
        if (curStatus != null)
            prevStatus = curStatus;
        curStatus = status;
    }

    static void openNewWindow(Stage stage) {
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(
                MainWindow.class.getResource(
                        Windows.resources.get(Windows.curStatus)));
        Parent root;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
            return;
        }
        stage = new Stage();
        stage.setTitle("ZOO");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
}
