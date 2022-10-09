package kristina.project.zoo.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import kristina.project.zoo.DB.Querys;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

import javafx.stage.Stage;

public class TableController {
    private static final Status prevStatus = Status.Admin;
    private static final List<String> list = new ArrayList<>();
    private final Querys querys = new Querys();

    @FXML
    private Button backButton;

    @FXML
    private ListView<String> listTables = new ListView<>();

    @FXML
    private TableView<Object> Table = new TableView<>();


    @FXML
    void initialize() {
        backButton.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) backButton.getScene().getWindow();
            Windows.setStatus(prevStatus);
            Windows.openNewWindow(stage);
        });
        listTables.getItems().addAll(list);
    }

    @FXML
    void OpenTable() {
        String inputString = listTables.getSelectionModel().getSelectedItem();
        if (inputString.endsWith("."))
        {}
        else{
            Table.getColumns().clear();
            querys.getQuery(Table, inputString, false);
            Table.refresh();
        }
    }


    public static void fillLists() {
        list.add("Работа");
        list.add("Работники");
        list.add("Администрация");
        list.add("Болезни");
        list.add("Ветеринары");
        list.add("Доступ");
        list.add("Дрессировщики");
        list.add("Животные");
        list.add("Зоопарки");
        list.add("Клетки");
        list.add("Корма");
        list.add("Лечение");
        list.add("Медосмотр");
        list.add("Обитатели");
        list.add("Поставки");
        list.add("Поставщики");
        list.add("Прививки");
        list.add("Привитые");
        list.add("Производство");
        list.add("Стационар");
        list.add("Совместимость");
        list.add("Типы");
        list.add("Склад");
        list.add("Рекомендации");
        list.add("Транспортировка");
        list.add("Строители");
        list.add("Рацион");
    }

}
