package vlas;

import vlas.services.Menu;
import java.sql.*;



/*
JDBC
Statement
PreparedStatement
callablestatement

Long type

слоистая архитектура

надо ли закрывать соединение?

 md5 +
 entity model +

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
        Menu menu = new Menu();
        menu.start();


    }
}
