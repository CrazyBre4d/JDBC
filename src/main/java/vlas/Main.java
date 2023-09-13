package vlas;

import vlas.services.Menu;

/*
Long type +
слоистая архитектура
 property file ( настройки бд ) +

!!!!добавление редактирование, просмотр, вьюшка заказов +
View в базе данных +
и не только читать +
а реализовывать программу +
С авторизацией и регистрацией на JAva +
В консольке с подключенной бд. Ну думаю, что пока что все*/


// меню для пользователя, получение пользователя
public class Main {
    public static void main(String[] args)  {
        Menu menu = new Menu();
        menu.start();
    }
}