package vlas.services;

import vlas.entity.*;
import vlas.repository.*;
import vlas.validation.Validator;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {

    private static final String text = "1 - Добавить, 2 - Удалить";

    RoleRepository roleR = new RoleRepository();
    OrdersRepository ordersR = new OrdersRepository();
    ProductRepository productR = new ProductRepository();
    ProdTypeRepository prodTypeR = new ProdTypeRepository();
    UsersRepository usersR = new UsersRepository();
    ViewRepo viewR = new ViewRepo();


    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Добрый день. Вы желаете войти (dungeon master) или зарегистрироваться? (f*cking slave) ");
            int operator = sc.nextInt();
            switch (operator) {
                case 1: {
                    System.out.println("Введите имя и пароль:");
                    sc.nextLine();
                    String user1 = sc.nextLine();

                    String password1 = sc.nextLine();
                    sc.nextLine();

                    if (Validator.getMD5Hash(password1).equals(usersR.getPasswordFromDB(user1))) {
                        System.out.println("входи");
                        int a = usersR.getRoleFromDB(user1);
                        next(a);
                    } else {
                        throw new NoSuchElementException();
                    }
                    break;
                }
                case 2: {
                    System.out.println("Введите место в таблице:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Введите имя");
                    String firstName = sc.nextLine();
                    System.out.println("Введите фамилию");
                    String lastName = sc.nextLine();
                    System.out.println("Введите никнейм");
                    String user = sc.nextLine();
                    System.out.println("Введите пароль");
                    String password = sc.nextLine();
                    usersR.create(new Users((long) id, firstName, lastName, 2L, user, Validator.getMD5Hash(password)));
                    break;
                }
                default:
                    System.out.println("Неверная команда. Попробуйте еще раз.");
                    break;
            }
        }
    }

    private void next(int i) {
        while (true) {
            switch (i) {
                case 1:
                    forAdmin();
                    break;
                case 2:
                    forUser();
                    break;
            }
        }
    }

    private void forUser() {
        while (true) {
            System.out.println("Добро пожаловать в базу данных ОАО 'В ГОСТЯХ У ВЛАС\n" +
                    "1 - Просмотр заказа\n2 - Назад");
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    viewR.getView("Vlas"); // FIX
                    break;
                case 2:
                    return;
            }
        }
    }

    private void forAdmin() {
        while (true) {
            System.out.println("Салам, Женя! \n Выберите таблицу или действие:\n" +
                    "1 - Users  \n2 - Roles \n3 - Product \n4 - Product_type \n5 - Orders \n6 - Назад");
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    System.out.println(usersR.getAll());
                    System.out.println(text);
                    i = sc.nextInt();
                    switch (i) {
                        case 1:
                            System.out.println("sadasd");
                        case 2:
                    }
                    break;
                case 2:
                    System.out.println(roleR.getAll());
                    System.out.println(text);
                    break;
                case 3:
                    System.out.println(productR.getAll());
                    System.out.println(text);
                    break;
                case 4:
                    System.out.println(prodTypeR.getAll());
                    System.out.println(text);
                    break;
                case 5:
                    System.out.println(ordersR.getAll());
                    System.out.println(text);
                    break;
                case 6:
                    return;
            }
        }
    }
    public  void crud(){
        while (true) {
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            switch (i) {
                case 1:
                case 2:
            }
        }
    }
}