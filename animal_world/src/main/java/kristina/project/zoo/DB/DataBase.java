package kristina.project.zoo.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DataBase {
    public static final String URL = "jdbc:oracle:thin:@84.237.50.81:1521:XE";
    public static final String USER_NAME = "19208_Galisheva";
    public static final String PASSWORD = "Vspjat545862";
    public static Connection connection;
    public static Statement statement;

    public static HashMap<String, String> QueryStrToFile = new HashMap<>();

    public static HashMap<String, String> HardQTF =new HashMap<>();

    public static void connectToDB() {
        fillTables();
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();
            System.out.println("Connect to DB is success!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    private static void fillTables() {
        QueryStrToFile.put("Работа", "getWork.sql");
        QueryStrToFile.put("Работники", "getWorkers.sql");
        QueryStrToFile.put("Администрация", "getAdministration.sql");
        QueryStrToFile.put("Болезни", "getDisease.sql");
        QueryStrToFile.put("Ветеринары", "getVetetinatians.sql");
        QueryStrToFile.put("Доступ", "getAccess.sql");
        QueryStrToFile.put("Дрессировщики", "getTrainers.sql");
        QueryStrToFile.put("Животные", "getAnimals.sql");
        QueryStrToFile.put("Зоопарки", "getZoo.sql");
        QueryStrToFile.put("Клетки", "getCells.sql");
        QueryStrToFile.put("Корма", "getStern.sql");
        QueryStrToFile.put("Лечение", "getTreatment.sql");
        QueryStrToFile.put("Медосмотр", "getMedical.sql");
        QueryStrToFile.put("Обитатели", "getInhabitants.sql");
        QueryStrToFile.put("Поставки", "getSupplies.sql");
        QueryStrToFile.put("Поставщики", "getSuppliers.sql");
        QueryStrToFile.put("Прививки", "getVaccinations.sql");
        QueryStrToFile.put("Привитые", "getVaccinated.sql");
        QueryStrToFile.put("Производство", "getProduction.sql");
        QueryStrToFile.put("Стационар", "getHospital.sql");
        QueryStrToFile.put("Совместимость", "getCompatibility.sql");
        QueryStrToFile.put("Типы", "getTypes.sql");
        QueryStrToFile.put("Склад", "getStock.sql");
        QueryStrToFile.put("Рекомендации", "getRec.sql");
        QueryStrToFile.put("Транспортировка", "getTransp.sql");
        QueryStrToFile.put("Строители", "Stroi.sql");
        QueryStrToFile.put("Рацион", "getPit.sql");

        QueryStrToFile.put("Получить список и общее число служащих зоопарка", "oneone.sql");
        QueryStrToFile.put("Получить перечень и общее число животных в зоопарке и их клетки", "4one.sql");
        QueryStrToFile.put("Получить список и общее число служащих администрации","oneAdmin.sql");
        QueryStrToFile.put("Получить список и общее число ветеринаров","oneVet.sql");
        QueryStrToFile.put("Получить список и общее число строителей-ремонтников","oneStroi.sql");
        QueryStrToFile.put("Получить список и общее число дрессировщиков","oneDre.sql");
        QueryStrToFile.put("Получить перечень и общее число нуждающихся в теплом помещении на зиму", "5one.sql");
        QueryStrToFile.put("Получить перечень и общее число поставщиков кормов", "8one.sql");
        QueryStrToFile.put("Получить перечень и общее число поставщиков кормовпоставляющих только определенный корм", "8first.sql");
        QueryStrToFile.put("Получить перечень и общее число поставщиков кормовпоставляющих в указанный период", "8second.sql");
        QueryStrToFile.put("Получить перечень и объем кормов, производимых зоопарком полностью", "9one.sql");
        QueryStrToFile.put("Получить перечень и объем кормов, производимых зоопарком в поставках которых зоопарк не нуждается", "9two.sql");
        QueryStrToFile.put("Получить перечень и общее число поставщиков кормовпоставляюзих только определенный корм, поставляющих в указанный период", "8third.sql");

        QueryStrToFile.put("Получить список и общее число служащих зоопаркаимеющих доступ к указанному виду", "onefirst.sql");
        QueryStrToFile.put("Получить список и общее число служащих зоопаркаимеющих доступ к конкретной особи", "onesecond.sql");
        QueryStrToFile.put("Получить перечень и общее число нуждающихся в теплом помещении на зимутолько указанного вида", "5first.sql");
        QueryStrToFile.put("Получить перечень и общее число нуждающихся в теплом помещении на зимутолько указанного возраста", "5second.sql");


        QueryStrToFile.put("Получить перечень и общее число животных в зоопарке и их клеткиживотных указанного вида, живших в указанной клетке", "4second.sql");
        QueryStrToFile.put("Получить перечень и общее число животных в зоопарке и их клеткиживших в указаной клетке", "4first.sql");

        QueryStrToFile.put("Получить перечень животных", "Animal.sql");
        QueryStrToFile.put("Получить перечень животныхкоторым поставлены указанная прививка", "6first.sql");
        QueryStrToFile.put("Получить перечень животныхпереболевших некоторой болезнью", "6second.sql");
        QueryStrToFile.put("Получить перечень животныхсовместимых с указанным видом", "7first.sql");
        QueryStrToFile.put("Получить перечень животныхсовместимых с указанным видом и нуждаются в теплом помещении", "7second.sql");
QueryStrToFile.put("Получить перечень и общее число животных которым необходим определенный тип кормов", "ten.sql");
        QueryStrToFile.put("Получить перечень и общее число животных которым необходим определенный тип кормовуказанного вида", "10first.sql");
        QueryStrToFile.put("Получить перечень и общее число животных которым необходим определенный тип кормовв указанном возрасте", "10second.sql");
        QueryStrToFile.put("Получить перечень и общее число животных которым необходим определенный тип кормовуказанного вида в указанном возрасте", "10third.sql");

        QueryStrToFile.put("Получить полную информацию о всех животных", "11one.sql");
        QueryStrToFile.put("Получить полную информацию о всех животныхо животных только данного вида", "11first.sql");
        QueryStrToFile.put("Получить полную информацию о всех животныхо конкретном животном", "11second.sql");
        QueryStrToFile.put("Получить полную информацию о всех животныхоб особи, живущей в указанной клетке", "11third.sql");
        QueryStrToFile.put("Получить информацию о прививках животных", "111one.sql");
        QueryStrToFile.put("Получить информацию о прививках животныхо животных только данного вида", "111first.sql");
        QueryStrToFile.put("Получить информацию о прививках животныхо конкретном животном", "111second.sql");
        QueryStrToFile.put("Получить информацию о прививках животныхоб особи, живущей в указанной клетке", "111third.sql");
        QueryStrToFile.put("Получить информацию о болезнях животных", "112one.sql");
        QueryStrToFile.put("Получить информацию о болезнях животныхо животных только данного вида", "112first.sql");
        QueryStrToFile.put("Получить информацию о болезнях животныхо конкретном животном", "112second.sql");
        QueryStrToFile.put("Получить информацию о болезнях животныхоб особи, живущей в указанной клетке", "112third.sql");
        QueryStrToFile.put("Получить перечень животных, от которых можно оживать потомство в преспективе", "12one.sql");
        QueryStrToFile.put("Получить перечень животных, от которых можно оживать потомство в преспективев указанный период", "12first.sql");
        QueryStrToFile.put("Получить перечень и общее число зоопарков, с которыми был произведен обмен животными в целом","13one.sql");
        QueryStrToFile.put("Получить перечень и общее число зоопарков, с которыми был произведен обмен животными в целомо животных только указанного вида","13first.sql");


        QueryStrToFile.put("Дрессировщики полные данные", "fgetTrainers.sql");
        QueryStrToFile.put("Администрация полные данные", "fgetAdministration.sql");
        QueryStrToFile.put("Ветеринары полные данные", "fgetVetetinatians.sql");
        QueryStrToFile.put("Работники полные данные", "fgetWorkers.sql");
        QueryStrToFile.put("Обитатели полные данные", "fgetInhabitants.sql");
        QueryStrToFile.put("Клетки полные данные", "fgetCells.sql");
        QueryStrToFile.put("Строители полные данные", "fStroi.sql");
        QueryStrToFile.put("Стационар полные данные", "fgetHospital.sql");

        QueryStrToFile.put("УдалитьДрессировщики полные данные", "dTrainers.sql");
        QueryStrToFile.put("УдалитьАдминистрация полные данные", "dAdministration.sql");
        QueryStrToFile.put("УдалитьВетеринары полные данные", "dVetetinatians.sql");
        QueryStrToFile.put("УдалитьРаботники полные данные", "dWorkers.sql");
        QueryStrToFile.put("УдалитьОбитатели полные данные", "dInhabitants.sql");
        QueryStrToFile.put("УдалитьКлетки полные данные", "dCells.sql");
        QueryStrToFile.put("УдалитьСтроители полные данные", "dStroi");
        QueryStrToFile.put("УдалитьСтационар полные данные", "dHospital.sql");

        QueryStrToFile.put("УдалитьЖивотные", "dAnimals.sql");
        QueryStrToFile.put("УдалитьКорма", "dStern.sql");
        QueryStrToFile.put("УдалитьТипы", "dTypes.sql");
        QueryStrToFile.put("УдалитьЗоопарки", "dZoo.sql");
        QueryStrToFile.put("УдалитьПоставщики", "dSuppliers.sql");
        QueryStrToFile.put("УдалитьПроизводство", "dProduction.sql");
        QueryStrToFile.put("УдалитьСклад", "dStock.sql");
        QueryStrToFile.put("УдалитьБолезни", "dDisease.sql");
        QueryStrToFile.put("УдалитьПрививки", "dVaccinations.sql");

        QueryStrToFile.put("Доступ полные данные", "fAccess.sql");
        QueryStrToFile.put("Совместимость полные данные", "fCompatibility.sql");
        QueryStrToFile.put("УдалитьДоступ полные данные", "dAcces.sql");
        QueryStrToFile.put("УдалитьСовместимость полные данные", "dCompatibility.sql");

        QueryStrToFile.put("Рацион полные данные", "fgetPit.sql");
        QueryStrToFile.put("УдалитьРацион полные данные", "dPit.sql");
        QueryStrToFile.put("Лечение полные данные", "fgetTreatment.sql");
        QueryStrToFile.put("УдалитьЛечение полные данные", "dTreatment.sql");

        QueryStrToFile.put("Работа полные данные", "fWork.sql");
        QueryStrToFile.put("УдалитьРабота полные данные", "dWork.sql");
        QueryStrToFile.put("Медосмотр полные данные", "getMedical.sql");
        QueryStrToFile.put("Поставки полные данные", "getSupplies.sql");
        QueryStrToFile.put("Привитые полные данные", "getVaccinated.sql");

        QueryStrToFile.put("Рекомендации полные данные", "getRec.sql");
        QueryStrToFile.put("Транспортировка полные данные", "getTransp.sql");




    }

}
