package kristina.project.zoo.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import kristina.project.zoo.DB.Querys;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

import javafx.stage.Stage;


public class Other {
    private static final Status prevStatus = Status.main;
    private final Querys querys = new Querys();
    @FXML
    private ImageView customerImage;

    @FXML
    private Button backButton;
    @FXML
    private Button add_cleaner;
    @FXML
    private TextField first;
    @FXML
    private TextField second;
    @FXML
    private TextField third;
    @FXML
    private TextField fourth;
    @FXML
    private TextField fifth;
    @FXML
    private TextField sixth;
    @FXML
    private TextField seventh;

    @FXML
    void initialize() {
     backButton.setOnMouseClicked(mouseEvent -> {
        Stage stage = (Stage) backButton.getScene().getWindow();
        nextWindow(prevStatus, stage);
    });
    add_cleaner.setOnMouseClicked(mouseEvent -> {
        querys.Add_clear("20", "02.02.2022", "M", "02.02.2022", "5", "stiv", "virs");
    });

    }
    private void nextWindow(Status status, Stage stage) {

        Windows.setStatus(status);
        Windows.openNewWindow(stage);
    }
}

