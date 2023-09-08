package vlas;

import vlas.entity.Roles;
import vlas.repository.RoleRepository;
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

        Scanner sc= new Scanner(System.in);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        RoleRepository roleRepository = new RoleRepository();
        /*System.out.println("Добрый день. Введи имя и пароль для входа в БД:");
        String user = sc.nextLine();
        String password = sc.nextLine();
        conn = DriverManager.getConnection("jdbc:oracle:thin:@scomplat.scx:1521:komplat",user,password);*/


        System.out.println("Добро пожаловать в базу данных ОАО 'В ГОСТЯХ У ВЛАСА' \nСалам, Женя! \n Выберите таблицу или действие:\n" +
                "1 - Users  \n2 - Roles \n3 - Product \n4 - Product_type \n5 - Orders \n6 -Просмотр заказов ");
        int operator = sc.nextInt();
        switch (operator) {
            case 1:

            case 2:
                        Roles newRole = new Roles(6,"Loh");
                       // roleRepository.create(newRole);
                        System.out.println(roleRepository.getAll());
                        roleRepository.delete(3);
                         System.out.println(roleRepository.getAll());
                break;
            default:
                throw new IllegalArgumentException("Enter number from 1 to 7!");
        }

    }
}