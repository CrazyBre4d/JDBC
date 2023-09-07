package vlas;

import java.sql.*;
import java.util.Scanner;

/*
JDBC
Statement
PreparedStatement
callablestatement

слоистая архитектура

 md5
 entity model

 разделение по правам: админ может все, а пользователь ток добавлять удалять и просматривать

 connection pull

 property file ( настройки бд )

!!!!добавление редактирование, просмотр, вьюшка заказов
View в базе данных
и не только читать
а реализовывать программу
С авторизацией и регистрацией на JAva
В консольке с подключенной бд. Ну думаю, что пока что все*/

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Scanner sc= new Scanner(System.in);
        Class.forName("oracle.jdbc.driver.OracleDriver");

        System.out.println("Добрый день. Введи имя и пароль для входа в БД:");
        String user = sc.nextLine();
        String password = sc.nextLine();
        conn = DriverManager.getConnection("jdbc:oracle:thin:@scomplat.scx:1521:komplat",user,password);


        System.out.println("Добро пожаловать в базу данных ОАО 'В ГОСТЯХ У ВЛАСА' \nСалам, Женя! \n Выберите таблицу или действие:\n" +
                "1 - Users  \n2 - Roles \n3 - Product \n4 - Product_type \n5 - Orders \n6 -Просмотр заказов ");
        int operator = sc.nextInt();
        switch (operator) {
            case 1:
                st = conn.createStatement();
                rs = st.executeQuery("SELECT * FROM USERSS ");
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
                            + rs.getString(3) + " " + rs.getInt(4) + " " + rs.getString(5) + " " + rs.getString(6));
                }
                System.out.println("Выберите операцию: \n1 - Добавление сущности \n2 - Удаление сущности \3 ");
                break;
            case 2:
                st = conn.createStatement();
                rs = st.executeQuery("SELECT * FROM ROLESS ");
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2));
                }

                break;
            case 3:
                st = conn.createStatement();
                rs = st.executeQuery("SELECT * FROM PRODUCT ");
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
                            + rs.getInt(3) + " " + rs.getString(4) + " " + rs.getInt(5));
                }

                break;
            case 4:
                st = conn.createStatement();
                rs = st.executeQuery("SELECT * FROM PRODUCT_TYPE ");
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2) );
                }
                break;

            case 5:
                st = conn.createStatement();
                rs = st.executeQuery("SELECT * FROM ORDERS ");
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " "
                            + rs.getInt(3) + " " + rs.getInt(4) + " " + rs.getString(5));
                }
                System.out.println("Выберите операцию: \n1 - Добавление сущности \n2 - Удаление сущности \3 ");
                int input = sc.nextInt();

                switch (input){
                    case 1:
                String sql = "INSERT INTO ORDERS (ORDER_ID, USER_ID, PRODUCT_ID, IS_ORDERED, PURCHASE_DATE) " +
                        "values ( 4, 1, 1, 1, '10.11.2023')";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.executeUpdate();

                break;
                    case 2:
                }

            case 6:

                break;

            default:
                throw new IllegalArgumentException("Enter number from 1 to 7!");
        }











         if (rs != null) {rs.close();}
         if (st != null) {st.close();}
         if (conn != null) {conn.close();}



    }
}