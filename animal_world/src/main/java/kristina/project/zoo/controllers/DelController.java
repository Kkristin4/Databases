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

public class DelController {
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
    private Button del;


    @FXML
    void initialize() {

        backButton.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) backButton.getScene().getWindow();
            Windows.setStatus(prevStatus);
            Windows.openNewWindow(stage);
        });
        del.setOnMouseClicked(mouseEvent -> {
            String inputString = "Удалить"+listTables.getSelectionModel().getSelectedItem();
if ( inputString.equals("УдалитьВетеринары полные данные") || inputString.equals("УдалитьАдминистрация полные данные") || inputString.equals("УдалитьДрессировщики полные данные") || inputString.equals("УдалитьРабота полные данные") ||
inputString.equals("УдалитьКлетки полные данные") || inputString.equals("УдалитьСтационар полные данные")|| inputString.equals("УдалитьОбитатели полные данные") || inputString.equals("УдалитьРаботники полные данные") || inputString.equals("УдалитьСтроители полные данные")){
    Integer num = Table.getSelectionModel().getSelectedItem().toString().indexOf(",");
    String ret = "";
    for(int i = 1; i < num; i++){
        ret = ret + Table.getSelectionModel().getSelectedItem().toString().charAt(i);
    }
    querys.delInt(inputString, Integer.parseInt(ret));
}
if (inputString.equals("УдалитьТипы") || inputString.equals("УдалитьПроизводство") || inputString.equals("УдалитьПрививки") ||
inputString.equals("УдалитьКорма") || inputString.equals("УдалитьПоставщики") || inputString.equals("УдалитьБолезни") ||
inputString.equals("УдалитьЖивотные") || inputString.equals("УдалитьЗоопарки") || inputString.equals("УдалитьСклад")){
    Integer num = Table.getSelectionModel().getSelectedItem().toString().indexOf(",");
    String ret = Table.getSelectionModel().getSelectedItem().toString().substring(1, num);
    querys.delSt(inputString, ret);
}
if (inputString.equals("УдалитьДоступ полные данные") || inputString.equals("УдалитьСовместимость полные данные")){
    Integer num = Table.getSelectionModel().getSelectedItem().toString().indexOf(",");
    Integer numb = Table.getSelectionModel().getSelectedItem().toString().lastIndexOf(",");
    Integer size = Table.getSelectionModel().getSelectedItem().toString().indexOf("]");
    String f = Table.getSelectionModel().getSelectedItem().toString().substring(1, num);
    String c = Table.getSelectionModel().getSelectedItem().toString().substring(numb+2, size);
    querys.delIntInt(inputString, Integer.parseInt(f), Integer.parseInt(c));
}
if (inputString.equals("УдалитьРацион полные данные")||inputString.equals("УдалитьЛечение полные данные")){
    Integer num = Table.getSelectionModel().getSelectedItem().toString().indexOf(",");
    String f = Table.getSelectionModel().getSelectedItem().toString().substring(1, num);
    String nado = Table.getSelectionModel().getSelectedItem().toString().substring(num+2, Table.getSelectionModel().getSelectedItems().toString().length() - 2 );
   String c = nado.substring(0, num);
    querys.delIntSt(inputString, Integer.parseInt(f), c);
}

            /*
            if (inputString.equals("УдалитьСовместимость")) {
                Integer num = Table.getSelectionModel().getSelectedItem().toString().indexOf(",");
                Integer las = Table.getSelectionModel().getSelectedItem().toString().indexOf("]");
                String ret = "";
                String l = "";
                for(int i = 1; i < num; i++){
                    ret = ret + Table.getSelectionModel().getSelectedItem().toString().charAt(i);
                }
                for(int i = num + 2; i < las; i++){
                    l = l + Table.getSelectionModel().getSelectedItem().toString().charAt(i);
                }
                 querys.del(inputString, Integer.parseInt(ret), Integer.parseInt(l));
            }
            if (inputString.equals("УдалитьАдминистрация") || inputString.equals("УдалитьДрессировщики")) {
                Integer num = Table.getSelectionModel().getSelectedItem().toString().indexOf(",");
                Integer las = Table.getSelectionModel().getSelectedItem().toString().lastIndexOf(",");
                String ret = "";
                String l = "";
                for(int i = 1; i < num; i++){
                    ret = ret + Table.getSelectionModel().getSelectedItem().toString().charAt(i);
                }
                for(int i = num + 2; i < las; i++){
                    l = l + Table.getSelectionModel().getSelectedItem().toString().charAt(i);
                }
                querys.delSt(inputString, ret, l);
            }
            if (inputString.equals("УдалитьВетеринары")) {
                Integer num = Table.getSelectionModel().getSelectedItem().toString().indexOf(",");
                Integer las = Table.getSelectionModel().getSelectedItem().toString().lastIndexOf(",");
                String nado = Table.getSelectionModel().getSelectedItem().toString();
                nado = nado.substring(0, las);
                las = nado.lastIndexOf(",");
                nado = nado.substring(0, las);
                las = nado.lastIndexOf(",");
                nado = nado.substring(0, las);
                String ret = "";
                String l = "";
                for(int i = 1; i < num; i++){
                    ret = ret + Table.getSelectionModel().getSelectedItem().toString().charAt(i);
                }
                for(int i = num + 2; i < nado.length(); i++){
                    l = l + nado.charAt(i);
                }
                querys.delSt(inputString, ret, l);
            }
            if (inputString.equals("УдалитьСтроители")) {
                Integer num = Table.getSelectionModel().getSelectedItem().toString().indexOf(",");
                Integer las = Table.getSelectionModel().getSelectedItem().toString().lastIndexOf(",");
                String nado = Table.getSelectionModel().getSelectedItem().toString();
                nado = nado.substring(0, las);
                las = nado.lastIndexOf(",");
                nado = nado.substring(0, las);
                String ret = "";
                String l = "";
                for(int i = 1; i < num; i++){
                    ret = ret + Table.getSelectionModel().getSelectedItem().toString().charAt(i);
                }
                for(int i = num + 2; i < nado.length(); i++){
                    l = l + nado.charAt(i);
                }
                querys.delSt(inputString, ret, l);
            }
            if (inputString.equals("УдалитьРаботники")) {
                Integer num = Table.getSelectionModel().getSelectedItem().toString().indexOf(",");
                Integer las = Table.getSelectionModel().getSelectedItem().toString().lastIndexOf(",");
                Integer ls = Table.getSelectionModel().getSelectedItem().toString().indexOf("]");
                String ret = "";
                String l = "";
                for(int i = 1; i < num; i++){
                    ret = ret + Table.getSelectionModel().getSelectedItem().toString().charAt(i);
                }
                for(int i = las + 2; i < ls; i++){
                    l = l + Table.getSelectionModel().getSelectedItem().toString().charAt(i);
                }
                querys.delSt(inputString, ret, l);
            }
            if (inputString.equals("УдалитьРабота")) {
                Integer num = Table.getSelectionModel().getSelectedItem().toString().indexOf(",");
                String ret = "";
                for(int i = 1; i < num; i++){
                    ret = ret + Table.getSelectionModel().getSelectedItem().toString().charAt(i);
                }

                querys.delSt(inputString, ret, null);
            }*/

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
        list.add("Работа полные данные");
        list.add("Работники полные данные");
        list.add("Администрация полные данные");
        list.add("Болезни");
        list.add("Ветеринары полные данные");
        list.add("Доступ полные данные");
        list.add("Дрессировщики полные данные");
        list.add("Животные");
        list.add("Зоопарки");
        list.add("Клетки полные данные");
        list.add("Корма");
        list.add("Лечение полные данные");
        list.add("Медосмотр полные данные");
        list.add("Обитатели полные данные");
        list.add("Поставки полные данные");
        list.add("Поставщики");
        list.add("Прививки");
        list.add("Привитые полные данные");
        list.add("Производство");
        list.add("Стационар полные данные");
        list.add("Совместимость полные данные");
        list.add("Типы");
        list.add("Склад");
        list.add("Рекомендации полные данные");
        list.add("Транспортировка полные данные");
        list.add("Строители полные данные");
        list.add("Рацион полные данные");
    }

}