package kristina.project.zoo.DB;

import javafx.scene.chart.PieChart;
import kristina.project.zoo.MainWindow;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;


public class Querys {
    PreparedStatement Ask;

    public void getQuery(TableView<Object> tableview, String table, boolean needValidation) {
        String query = getQueryFromFile(table);
        if (needValidation)
        {
        }
        ObservableList<Object> data = FXCollections.observableArrayList();
        ResultSet set;
        try {
            set = DataBase.getConnection().createStatement().executeQuery(query);
            for(int i = 0; i < set.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(set.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>,
                        ObservableValue<String>>)
                        param -> new SimpleStringProperty(param.getValue().get(j).toString()));

                tableview.getColumns().addAll(col);
            }

            while(set.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i = 1 ; i <= set.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    if (set.getString(i) == null)
                        row.add("NULL");
                    else
                        row.add(set.getString(i));
                }
                data.add(row);

            }
            tableview.setItems(data);

        } catch (SQLException e) {
            System.out.println("ERROR");
            tableview.setItems(FXCollections.observableArrayList("Нет соединения"));
        }

    }
    public void Add_clear(String q, String w, String e, String r, String t, String y, String u){
        String stat  = "INSERT INTO РАБОТНИКИ VALUES(" + q +  ", "+ w + ", " + e + ", "+r + ", " + t + ", "+ y +", " + u + ");";
        try { DataBase.getConnection().createStatement().executeQuery(stat );

        }
        catch (SQLException ex){
        }
    }
    public void createQuery(TableView<Object> tableview, String table, String first, Integer second, boolean flag) {

        try(PreparedStatement pstm = DataBase.getConnection().prepareStatement(getQueryFromFile(table))){
            if (flag){
                if (second != null){
                pstm.setInt(1, second);
                pstm.setInt(2, second);
                if (first != null){
                    pstm.setString(3, first);
                }}
                else {
                    pstm.setString(1, first);
                    pstm.setString(2, first);
                }
            }
            else {
            if (first != null ) {
                pstm.setString(1, first);
                if (second != null){
                    pstm.setInt(2, second);
                }
            }
            else {
                if (second != null){
                pstm.setInt(1, second);}
            }}
            ObservableList<Object> data = FXCollections.observableArrayList();
            ResultSet set;
            try {
                set = pstm.executeQuery();
                for(int i = 0; i < set.getMetaData().getColumnCount(); i++){
                    //We are using non property style for making dynamic table
                    final int j = i;
                    TableColumn col = new TableColumn(set.getMetaData().getColumnName(i + 1));
                    col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>,
                            ObservableValue<String>>)
                            param -> new SimpleStringProperty(param.getValue().get(j).toString()));

                    tableview.getColumns().addAll(col);
                }

                while(set.next()){
                    //Iterate Row
                    ObservableList<String> row = FXCollections.observableArrayList();
                    for(int i = 1 ; i <= set.getMetaData().getColumnCount(); i++){
                        //Iterate Column
                        if (set.getString(i) == null)
                            row.add("NULL");
                        else {
                            row.add(set.getString(i));
                        }
                    }
                    data.add(row);

                }
                tableview.setItems(data);

           } catch (SQLException e) {
                tableview.setItems(FXCollections.observableArrayList("Нет соединения"));
            }
        }
        catch(SQLException e){}


    }
    public void del(String name, Integer first, Integer second){
        try(PreparedStatement pstm = DataBase.getConnection().prepareStatement(getQueryFromFile(name))){
            ResultSet set;
            pstm.setInt(1, first);
            pstm.setInt(2, second);
            try { set = pstm.executeQuery();}
            catch (SQLException e){
                System.out.println("тип");
            }
        }
        catch (SQLException ex){
            System.out.println("rrrr");
        }

    }
    public void delInt(String name, Integer first){
        try(PreparedStatement pstm = DataBase.getConnection().prepareStatement(getQueryFromFile(name))){
            ResultSet set;
            pstm.setInt(1, first);
            try { set = pstm.executeQuery();}
            catch (SQLException e){
                System.out.println("есть зависимость");
            }
        }
        catch (SQLException ex){
            System.out.println("есть зависимость(");
        }

    }
    public void delIntInt(String name, Integer first, Integer second){
        try(PreparedStatement pstm = DataBase.getConnection().prepareStatement(getQueryFromFile(name))){
            ResultSet set;
            pstm.setInt(1, first);
            pstm.setInt(2, second);
            try { set = pstm.executeQuery();}
            catch (SQLException e){
                System.out.println("есть зависимость");
            }
        }
        catch (SQLException ex){
            System.out.println("есть зависимость(");
        }

    }
    public void delIntSt(String name, Integer first, String second){
        try(PreparedStatement pstm = DataBase.getConnection().prepareStatement(getQueryFromFile(name))){
            ResultSet set;
            pstm.setInt(1, first);
            pstm.setString(2, second);
            try { set = pstm.executeQuery();}
            catch (SQLException e){
                System.out.println("есть зависимость");
            }
        }
        catch (SQLException ex){
            System.out.println("есть зависимость(");
        }

    }
    public void delSt(String name, String first){
        try(PreparedStatement pstm = DataBase.getConnection().prepareStatement(getQueryFromFile(name))){
            ResultSet set;
            pstm.setString(1, first);
            try { set = pstm.executeQuery();}
            catch (SQLException e){
                System.out.println("Имеется зависимость");
            }
        }
        catch (SQLException ex){
            System.out.println("rrrr");
        }}

    public void speshal(TableView<Object> tableview, String table, Date first, Date second, String third, boolean flag ) {

        try(PreparedStatement pstm = DataBase.getConnection().prepareStatement(getQueryFromFile(table))){


                    pstm.setDate(1, first);
                    pstm.setDate(2, second);
                    if (flag){
                        pstm.setString(3, third);
                    }

            ObservableList<Object> data = FXCollections.observableArrayList();
            ResultSet set;
            try {
                set = pstm.executeQuery();
                for(int i = 0; i < set.getMetaData().getColumnCount(); i++){
                    //We are using non property style for making dynamic table
                    final int j = i;
                    TableColumn col = new TableColumn(set.getMetaData().getColumnName(i + 1));
                    col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>,
                            ObservableValue<String>>)
                            param -> new SimpleStringProperty(param.getValue().get(j).toString()));

                    tableview.getColumns().addAll(col);
                }

                while(set.next()){
                    //Iterate Row
                    ObservableList<String> row = FXCollections.observableArrayList();
                    for(int i = 1 ; i <= set.getMetaData().getColumnCount(); i++){
                        //Iterate Column
                        if (set.getString(i) == null)
                            row.add("NULL");
                        else {
                            row.add(set.getString(i));
                        }
                    }
                    data.add(row);

                }
                tableview.setItems(data);

            } catch (SQLException e) {
                tableview.setItems(FXCollections.observableArrayList("Нет соединения"));
            }
        }
        catch(SQLException e){}


    }

    private String getQueryFromFile(String fileName) {
        try {
            return Files.readString(Paths.get(Objects.requireNonNull(MainWindow.class.getResource
                    ("sqlQuerys/" + DataBase.QueryStrToFile.get(fileName))).toURI()));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void createQuery(String NameTable, String arg1, String arg2){
        try{
            Ask = DataBase.getConnection().prepareStatement(getQueryFromFile(NameTable));
            if (arg1 != null){
                Ask.setString(1, arg1);}
            if (arg2 != null){
                Ask.setString(2, arg2);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

}
