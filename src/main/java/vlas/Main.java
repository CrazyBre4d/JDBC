package vlas;

import vlas.repository.ProdTypeRepository;
import vlas.services.Menu;

import java.sql.SQLException;

/*меню для пользователя, получение пользователя
* заменить на ?
* можно сделаь один поиск по двум параметрам
* */
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.start();
    }
}


// возможно строки надо будет делать так '?'