package kristina.project.zoo.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Administration {
    enum TypeOfWorkWindow {
        none,
        OpenTables,
        MakeRequest,
        ChangeTable
    }

    private static TypeOfWorkWindow typeOfWorkWindow = TypeOfWorkWindow.none;
    private static final Status prevStatus = Status.main;


    @FXML
    private ImageView pharmacistImage;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private Button OpenTables;

    @FXML
    private Button MakeRequest;

    @FXML
    private Button ChangeTables;

    @FXML
    void initialize() {


        OpenTables.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) OpenTables.getScene().getWindow();
            typeOfWorkWindow = TypeOfWorkWindow.OpenTables;
            nextWindow(Status.tables, stage);
        });

        MakeRequest.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) MakeRequest.getScene().getWindow();
            typeOfWorkWindow = TypeOfWorkWindow.MakeRequest;
            nextWindow(Status.withoutparam, stage);
        });

        ChangeTables.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) ChangeTables.getScene().getWindow();
            typeOfWorkWindow = TypeOfWorkWindow.ChangeTable;
            nextWindow(Status.del, stage);
        });

        backButton.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) backButton.getScene().getWindow();
            nextWindow(prevStatus, stage);
        });
    }

    private void nextWindow(Status status, Stage stage) {

        Windows.setStatus(status);
        Windows.openNewWindow(stage);
    }

    static protected int getTypeOfWork() {
        return switch (typeOfWorkWindow) {
            case none -> -1;
            case OpenTables -> 1;
            case MakeRequest -> 2;
            case ChangeTable -> 3;
        };
    }

}