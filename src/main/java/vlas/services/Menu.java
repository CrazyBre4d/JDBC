package vlas.services;

import vlas.entity.*;
import vlas.repository.*;
import java.util.Scanner;


public class Menu  {


    Scanner sc = new Scanner(System.in);
    Class.forName("oracle.jdbc.driver.OracleDriver");

    RoleRepository roleRepository = new RoleRepository();
    OrdersRepository o = new OrdersRepository();
    ProductRepository p = new ProductRepository();
    ProdTypeRepository p1 = new ProdTypeRepository();
    UsersRepository u = new UsersRepository();
        /*System.out.println("Добрый день. Введи имя и пароль для входа в БД:");
        String user = sc.nextLine();
        String password = sc.nextLine();
        conn = DriverManager.getConnection("jdbc:oracle:thin:@scomplat.scx:1521:komplat",user,password);*/


        System.out.println("Добро пожаловать в базу данных ОАО 'В ГОСТЯХ У ВЛАСА' \nСалам, Женя! \n Выберите таблицу или действие:\n"+
                "1 - Users  \n2 - Roles \n3 - Product \n4 - Product_type \n5 - Orders \n6 -Просмотр заказов ");
    int operator = sc.nextInt();

        switch(operator)

    {
        case 1:
            System.out.println(u.getAll());
            break;
        case 2:
            Roles newRole = new Roles(6, "Loh");
            // roleRepository.create(newRole);
            System.out.println(roleRepository.getAll());
            roleRepository.delete(3);
            // System.out.println(roleRepository.getAll());
            break;
        case 3:
            System.out.println(p.getAll());
            break;
        case 4:
            System.out.println(p1.getAll());
            break;
        case 5:
            System.out.println(o.getAll());
            break;
        case 6:
        default:
            throw new IllegalArgumentException("Enter number from 1 to 7!");
    }
}
