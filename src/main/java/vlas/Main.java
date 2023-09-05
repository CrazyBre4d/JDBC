package vlas;

import java.sql.*;
import java.util.Scanner;

/*
JDBC
Statement
PreparedStatement
callablestatement


!!!!добавление редактирование просмотр вьюшка заказа
!!! сделать так кабы динамически обновлялись таблицы в командной строке
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



        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@scomplat.scx:1521:komplat","kabakov","kabakov");


        Scanner sc= new Scanner(System.in);
        int operator = sc.nextInt();
        System.out.println("Добро пожаловать в базу данных ОАО 'В ГОСТЯХ У ВЛАСА' \n Салам, Женя!\n Выберите доступную операцию:\n" +
                "1 - Просмотр таблиц \n2 - Удаление   ");
        switch (operator) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:
                break;
            default:
                throw new IllegalArgumentException("Enter number from 1 to 4!");
        }


        st = conn.createStatement();
        rs = st.executeQuery("SELECT * FROM USERSS");



        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
                    + rs.getString(3) + " " + rs.getInt(4) + " " + rs.getString(5) + " " + rs.getString(6));
        }
        conn.close();



         if (rs != null) {rs.close();}
         if (st != null) {st.close();}
         if (conn != null) {conn.close();}



    }
}