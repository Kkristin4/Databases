package kristina.project.zoo.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class MainController {


    @FXML
    private Button AdminButton;

    @FXML
    private ImageView mainImage;

    @FXML
    private void initialize () {



        AdminButton.setOnAction(event -> {

            Stage stage = (Stage) AdminButton.getScene().getWindow();
            Windows.setStatus(Status.Admin);
            Windows.openNewWindow(stage);
        });
    }



}
