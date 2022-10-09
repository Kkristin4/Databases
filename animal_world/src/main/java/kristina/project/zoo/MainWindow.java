package kristina.project.zoo;

import kristina.project.zoo.DB.DataBase;
import kristina.project.zoo.controllers.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindow extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        DataBase.connectToDB();
        Windows.setStatus(Status.main);
        FXMLLoader fxmlLoader = new FXMLLoader(
                        MainWindow.class.getResource(
                        Windows.resources.get(Windows.curStatus)));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("ZOO");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Windows.windowsInitialize();
        TableController.fillLists();
        DelController.fillLists();
        Without.fillLists();
        launch();
    }
}