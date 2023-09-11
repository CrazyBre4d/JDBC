package vlas.services;
import vlas.*;
import vlas.entity.*;
import vlas.repository.*;
import vlas.validation.Validator;


import java.util.Scanner;


public class Menu  {

    RoleRepository r = new RoleRepository();
    OrdersRepository o = new OrdersRepository();
    ProductRepository p = new ProductRepository();
    ProdTypeRepository p1 = new ProdTypeRepository();
    UsersRepository u = new UsersRepository();
    ViewRepo v = new ViewRepo();

    public void start(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Добрый день. Вы желаете войти (dungeon master) или зарегистрироваться? (f*cking slave) ");
        int operator = sc.nextInt();
        switch (operator){
            case 1: {
                System.out.println("Введите имя и пароль:");
                sc.nextLine();
                String user1 = sc.nextLine();

                String password1 = sc.nextLine();
                sc.nextLine();

                if(  Validator.getMD5Hash(password1).equals(u.getPasswordFromDB(user1) ) ){
                System.out.println("входи");
                 int a = u.getRoleFromDB(user1);
                 next(a);
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
                u.create(new Users(id,firstName,lastName,2, user, Validator.getMD5Hash(password) ));
                break; }
        }


    }
    private void next(int i) {
        switch (i) {
            case 1: forAdmin();
            case 2: forUser();
        }
    }

    private void forUser() {
        System.out.println("Добро пожаловать в базу данных ОАО 'В ГОСТЯХ У ВЛАС\n" +
                "1 - Просмотр заказа");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i) {
            case 1:
               v.getView("Vlas");
            case 2:
        }
    }
    private void forAdmin() {
        System.out.println("Салам, Женя! \n Выберите таблицу или действие:\n" +
                            "1 - Users  \n2 - Roles \n3 - Product \n4 - Product_type \n5 - Orders \n6 -Просмотр заказов");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i) {
            case 1:
                System.out.println(u.getAll());
                break;
            case 2:
                System.out.println(r.getAll());
                break;
            case 3:
                System.out.println(p.getAll());
                break;
            case 4:
                System.out.println(p1.getAll());
            case 5:
                System.out.println(o.getAll());
        }
    }
}
