module kristina.project.zoo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens kristina.project.zoo to javafx.fxml;
    exports kristina.project.zoo;
    exports kristina.project.zoo.controllers;
    opens kristina.project.zoo.controllers to javafx.fxml;
    exports kristina.project.zoo.DB;
    opens kristina.project.zoo.DB to javafx.fxml;
}