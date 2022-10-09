package kristina.project.zoo.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import kristina.project.zoo.DB.Querys;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Without {
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
    private ComboBox<String> combo;
    @FXML
    private Button findButton;

    @FXML
    private Button outin;

    @FXML
    private TextField first;
    @FXML
    private TextField second;
    @FXML
    private DatePicker third;
    @FXML
    private DatePicker four;




    @FXML
    void initialize() {
        backButton.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) backButton.getScene().getWindow();
            Windows.setStatus(prevStatus);
            Windows.openNewWindow(stage);
        });
        listTables.getItems().addAll(list);
        findButton.setOnMouseClicked(mouseEvent -> {

                String inputString = listTables.getSelectionModel().getSelectedItem() + combo.getSelectionModel().getSelectedItem();
                if (inputString.endsWith(".")) {
                } else { if(inputString.equals("Получить перечень животных, от которых можно оживать потомство в преспективев указанный период")){
                    Table.getColumns().clear();
                    querys.speshal(Table, inputString, Date.valueOf(third.getValue()), Date.valueOf(four.getValue()), null, false);
                    Table.refresh();
                }else{
                    if (inputString.equals("Получить перечень и общее число поставщиков кормовпоставляюзих только определенный корм, поставляющих в указанный период")){
                    Table.getColumns().clear();
                    querys.speshal(Table, inputString, Date.valueOf(third.getValue()), Date.valueOf(four.getValue()), first.getText(), true);
                    Table.refresh();
                }else{
                    if (inputString.equals("Получить перечень и общее число поставщиков кормовпоставляющих в указанный период")){
                        Table.getColumns().clear();
                        querys.speshal(Table, inputString, Date.valueOf(third.getValue()), Date.valueOf(four.getValue()), null, false);
                        Table.refresh();
                    } else {
                    if (inputString.equals("Получить перечень и общее число зоопарков, с которыми был произведен обмен животными в целомо животных только указанного вида")){
                        Table.getColumns().clear();
                        querys.createQuery(Table, inputString, first.getText(), null, true);
                        Table.refresh();
                    }else{
                    if (inputString.equals("Получить перечень и общее число животных которым необходим определенный тип кормовв указанном возрасте")){
                        Table.getColumns().clear();
                        querys.createQuery(Table, inputString, null, Integer.parseInt(second.getText()), true);
                        Table.refresh();
                    } else {
                    if (inputString.equals("Получить перечень и общее число животных которым необходим определенный тип кормовуказанного вида в указанном возрасте")){
                        Table.getColumns().clear();
                        querys.createQuery(Table, inputString, first.getText(), Integer.parseInt(second.getText()), true);
                        Table.refresh();
                    } else {
                    if (!first.getText().equals("---") && second.getText().equals("---"))
                    Table.getColumns().clear();
                    querys.createQuery(Table, inputString, first.getText(), null, false);
                    Table.refresh();
                    if (!first.getText().equals("---") && !second.getText().equals("---")){
                        Table.getColumns().clear();
                        querys.createQuery(Table, inputString, first.getText(), Integer.parseInt(second.getText()), false);
                        Table.refresh();
                    }
                    if (first.getText().equals("---") && !second.getText().equals("---")){
                        Table.getColumns().clear();
                        querys.createQuery(Table, inputString, null, Integer.parseInt(second.getText()), false);
                        Table.refresh();
                    }


                    }}}}}}

                }


        });
        outin.setOnMouseClicked(mouseEvent -> {
            first.setText("---");
            second.setText("---");


            if (listTables.getSelectionModel().getSelectedItems().contains("Получить список и общее число служащих зоопарка")){
                first.clear();
                if (combo.getSelectionModel().getSelectedItem().contains("имеющих доступ к указаному виду")){
                    first.setText("ввидите вид");
                }
                if (combo.getSelectionModel().getSelectedItem().contains("имеющих доступ к конкретной особи")){
                    first.setText("введите кличку");
                }
            }
            if (listTables.getSelectionModel().getSelectedItems().contains("Получить перечень и общее число животных в зоопарке и их клетки")){

                    second.setText("номер клетки");

                if (combo.getSelectionModel().getSelectedItem().contains("животных указанного вида, живших в указанной клетке")){
                    first.setText("введите вид");
                }

            }
            if (listTables.getSelectionModel().getSelectedItems().contains("Получить перечень и общее число нуждающихся в теплом помещении на зиму")){
               if ( combo.getSelectionModel().getSelectedItem().contains("только указанного вида")){
                   first.setText("введите вид");
               }
                if (combo.getSelectionModel().getSelectedItem().contains("только указанного возраста")){
                    second.setText("введите возраст в месяцах");
                }
            }
            if (listTables.getSelectionModel().getSelectedItems().contains("Получить перечень и общее число поставщиков кормов")){
                if (combo.getSelectionModel().getSelectedItem().contains("поставляющих только определенный корм")){
                    first.setText("введите название корма");
                }
                if (combo.getSelectionModel().getSelectedItem().contains("поставляюзих только определенный корм, поставляющих в указанный период")){
                    first.setText("введите название корма");
                }

            }
            if (listTables.getSelectionModel().getSelectedItems().contains("Получить перечень животных")){
                if (combo.getSelectionModel().getSelectedItem().contains("которым поставлены указанная прививка")){
                    first.setText("введите название прививки");
                }
                if (combo.getSelectionModel().getSelectedItem().contains("переболевших некоторой болезнью")){
                    first.setText("введите название болезни");
                }
                if (combo.getSelectionModel().getSelectedItem().contains("совместимых с указанным видом")){
                    first.setText("введите название вида");
                }
                if (combo.getSelectionModel().getSelectedItem().contains("совместимых с указанным видом и нуждаются в теплом помещении")){
                    first.setText("введите название вида");
                }



            }
            if (listTables.getSelectionModel().getSelectedItems().contains("Получить перечень и общее число животных которым необходим определенный тип кормов")){
                if (combo.getSelectionModel().getSelectedItem().contains("указанного вида")){
                    first.setText("введите название вида");
                }
                if (combo.getSelectionModel().getSelectedItem().contains("в указанном возрасте")){
                    second.setText("возраст в годах");
                }
                if (combo.getSelectionModel().getSelectedItem().contains("указанного вида в указанном возрасте")){
                    first.setText("введите название вида");
                    second.setText("возраст в годах");
                }
            }
            if (listTables.getSelectionModel().getSelectedItems().contains("Получить полную информацию о всех животных")){
                if (combo.getSelectionModel().getSelectedItem().contains("о животных только данного вида")){
                    first.setText("введите назание вида");
                }
                if (combo.getSelectionModel().getSelectedItem().contains("о конкретном животном")){
                    first.setText("введите кличку");
                }
                if (combo.getSelectionModel().getSelectedItem().contains("об особи, живущей в указанной клетке")){
                    second.setText("введите номер клетки");
                }

            }
            if (listTables.getSelectionModel().getSelectedItems().contains("Получить информацию о прививках животных")){
                if (combo.getSelectionModel().getSelectedItem().contains("о животных только данного вида")){
                    first.setText("введите назание вида");
                }
                if (combo.getSelectionModel().getSelectedItem().contains("о конкретном животном")){
                    first.setText("введите кличку");
                }
                if (combo.getSelectionModel().getSelectedItem().contains("об особи, живущей в указанной клетке")){
                    second.setText("введите номер клетки");
                }

            }
            if (listTables.getSelectionModel().getSelectedItems().contains("Получить информацию о болезнях животных")){
                if (combo.getSelectionModel().getSelectedItem().contains("о животных только данного вида")){
                    first.setText("введите назание вида");
                }
                if (combo.getSelectionModel().getSelectedItem().contains("о конкретном животном")){
                    first.setText("введите кличку");
                }
                if (combo.getSelectionModel().getSelectedItem().contains("об особи, живущей в указанной клетке")){
                    second.setText("введите номер клетки");
                }

            }
            if (listTables.getSelectionModel().getSelectedItems().contains("Получить перечень и общее число зоопарков, с которыми был произведен обмен животными в целом")){
                first.setText("введите название вида");

            }

        });
    }

    @FXML
    void FillCombo() {
        combo.getItems().clear();
        first.setText("---");
        second.setText("---");

      if ( listTables.getSelectionModel().getSelectedItems().contains("Получить список и общее число служащих зоопарка")) {
          combo.getItems().add("имеющих доступ к указанному виду");  //вид
          combo.getItems().add("имеющих доступ к конкретной особи");                    //особь

}
      if (listTables.getSelectionModel().getSelectedItems().contains("Получить перечень и общее число нуждающихся в теплом помещении на зиму")){
          combo.getItems().add("только указанного вида");
          combo.getItems().add("только указанного возраста");
      }

        if ( listTables.getSelectionModel().getSelectedItems().contains("Получить перечень и общее число животных в зоопарке и их клетки")) {

            combo.getItems().add("живших в указаной клетке");
            combo.getItems().add("животных указанного вида, живших в указанной клетке");
        }
        if (listTables.getSelectionModel().getSelectedItems().contains("Получить перечень и общее число поставщиков кормов")){
            combo.getItems().add("поставляющих только определенный корм");
            combo.getItems().add("поставляющих в указанный период");
            combo.getItems().add("поставляюзих только определенный корм, поставляющих в указанный период");

        }
        if (listTables.getSelectionModel().getSelectedItems().contains("Получить перечень животных")){
            combo.getItems().add("которым поставлены указанная прививка");
            combo.getItems().add("переболевших некоторой болезнью");
            combo.getItems().add("совместимых с указанным видом");
            combo.getItems().add("совместимых с указанным видом и нуждаются в теплом помещении");


        }
        if (listTables.getSelectionModel().getSelectedItems().contains("Получить перечень и общее число животных которым необходим определенный тип кормов")){
            combo.getItems().add("указанного вида");
            combo.getItems().add("в указанном возрасте");
            combo.getItems().add("указанного вида в указанном возрасте");
        }
        if (listTables.getSelectionModel().getSelectedItems().contains("Получить полную информацию о всех животных")){
            combo.getItems().add("о животных только данного вида");
            combo.getItems().add("о конкретном животном");
            combo.getItems().add("об особи, живущей в указанной клетке");
        }
        if (listTables.getSelectionModel().getSelectedItems().contains("Получить информацию о прививках животных")){
            combo.getItems().add("о животных только данного вида");
            combo.getItems().add("о конкретном животном");
            combo.getItems().add("об особи, живущей в указанной клетке");
        }
        if (listTables.getSelectionModel().getSelectedItems().contains("Получить информацию о болезнях животных")){
            combo.getItems().add("о животных только данного вида");
            combo.getItems().add("о конкретном животном");
            combo.getItems().add("об особи, живущей в указанной клетке");
        }
        if (listTables.getSelectionModel().getSelectedItems().contains("Получить перечень и общее число зоопарков, с которыми был произведен обмен животными в целом")){
            combo.getItems().add("о животных только указанного вида");

        }
        if (listTables.getSelectionModel().getSelectedItems().contains("Получить перечень животных, от которых можно оживать потомство в преспективе")){
            combo.getItems().add("в указанный период");
        }


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
        list.add("Получить список и общее число служащих зоопарка");
        list.add("Получить список и общее число ветеринаров");
        list.add("Получить список и общее число служащих администрации");
        list.add("Получить список и общее число строителей-ремонтников");
        list.add("Получить список и общее число дрессировщиков");
        list.add("Получить перечень и общее число животных в зоопарке и их клетки");
        list.add("Получить перечень и общее число нуждающихся в теплом помещении на зиму");
        list.add("Получить перечень и общее число поставщиков кормов");
        list.add("Получить перечень и объем кормов, производимых зоопарком полностью");
        list.add("Получить перечень и объем кормов, производимых зоопарком в поставках которых зоопарк не нуждается");
        list.add("Получить перечень животных");
        list.add("Получить перечень и общее число животных которым необходим определенный тип кормов");
        list.add("Получить полную информацию о всех животных");
        list.add("Получить информацию о прививках животных");
        list.add("Получить информацию о болезнях животных");
        list.add("Получить перечень животных, от которых можно оживать потомство в преспективе");
        list.add("Получить перечень и общее число зоопарков, с которыми был произведен обмен животными в целом");

    }


}
