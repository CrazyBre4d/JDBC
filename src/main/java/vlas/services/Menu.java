package vlas.services;

import vlas.entity.*;
import vlas.repository.*;
import vlas.validation.LoginValidator;
import vlas.validation.PasswordValidator;

import java.io.InvalidObjectException;
import java.sql.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {
   private String user1;
   private String password1;
   private Long roleUser = 2L;
   private static final String text = "1 - Добавить, 2 - Удалить, 3 - Назад";

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
                    user1 = sc.nextLine();
                    password1 = sc.nextLine();
                    sc.nextLine();

                    if (PasswordValidator.getMD5Hash(password1).equals(usersR.getPasswordFromDB(user1))) {
                        System.out.println("входи");
                        int a = usersR.getRoleFromDB(user1);
                        next(a);
                    } else {
                        throw new NoSuchElementException();
                    }
                    break;
                }
                case 2: {
                    sc.nextLine();
                    System.out.println("Введите имя");
                    String firstName = sc.nextLine();
                    System.out.println("Введите фамилию");
                    String lastName = sc.nextLine();
                    System.out.println("Введите никнейм");
                    String user = sc.nextLine();
                    System.out.println("Введите пароль");
                    String password = sc.nextLine();
                    if( (user).equals(LoginValidator.check(user)) ) {
                        throw new RuntimeException();
                    }
                    usersR.create(new Users( firstName, lastName, roleUser, user, PasswordValidator.getMD5Hash(password)));
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value");
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
                default:
                    throw new IllegalStateException("Unexpected value: " + i);
            }
        }
    }
    private void forUser() {
        while (true) {
            System.out.println("Добро пожаловать в базу данных ОАО 'В ГОСТЯХ У ВЛАСА'\n" +
                    "1 - Просмотр товаров \n2 - Просмотр корзины \n3 - Заказ \n4 - Назад");
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    System.out.println(productR.getAll());
                    System.out.println("1 - Добавить товар в корзину \n2 - Назад");
                    i = sc.nextInt();
                    switch (i) {
                        case 1:
                                Long productId = sc.nextLong();
                                ordersR.create(new Orders( (long) usersR.getIdFromDB(user1), productId,0,null));
                                break;
                        case 2: return;
                        default:
                            throw new IllegalStateException("Unexpected value: " + i);
                    } break;

                case 2:
                    System.out.println(viewR.getForUser(user1));
                    System.out.println("1 - Удалить товар из корзины 2 - Назад");
                    i = sc.nextInt();
                    switch (i) {
                        case 1 :
                            int id = sc.nextInt();
                            ordersR.delete1(id);
                        case 2:
                            return;
                        default: throw new IllegalStateException("Unexpected value: " + i);
                    }

                case 3:
                    ordersR.setDate((long) usersR.getIdFromDB(user1));
                    ordersR.updateView(usersR.getIdFromDB(user1));
                    return;
                case 4:
                     start();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + i);
            }
        }
    }

    private void forAdmin()  {
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
                            System.out.println("Введите  f_name, l_name, role_id, login, password");
                            String firstName = sc.nextLine();
                            String lastName = sc.nextLine();
                            Long role = sc.nextLong();
                            sc.nextLine();
                            String user = sc.nextLine();
                            String password = sc.nextLine();

                            usersR.create(new Users( firstName, lastName, role, user, PasswordValidator.getMD5Hash(password)));
                            break;
                        case 2:
                            System.out.println("Введите id который надо удалить");
                            int d = sc.nextInt();
                            usersR.delete(d);
                            break;
                        case 3:  return;
                        default: throw new IllegalStateException("Unexpected value: " + i);
                    }
                    break;
                case 2:
                    System.out.println(roleR.getAll());
                    System.out.println(text);
                    i = sc.nextInt();
                    switch (i) {
                        case 1:
                            System.out.println("Введите  role_name");
                            sc.nextLine();
                            String roleName = sc.nextLine();

                            roleR.create(new Roles( roleName));
                            break;
                        case 2:
                            System.out.println("Введите id который надо удалить");
                            int d = sc.nextInt();
                            roleR.delete(d);
                            break;
                        case 3:  return;
                        default: throw new IllegalStateException("Unexpected value: " + i);
                    }
                    break;
                case 3:
                    System.out.println(productR.getAll());
                    System.out.println(text);
                    i = sc.nextInt();
                    switch (i) {
                        case 1:
                            System.out.println("Введите product_name, product_price, product_desc, type_id");
                            String prodName = sc.nextLine();
                            String prodDesc = sc.nextLine();
                            int prodPrice = sc.nextInt();
                            Long typeId = sc.nextLong();
                            productR.create(new Product( prodName, prodPrice, prodDesc, typeId ));
                            break;
                        case 2:
                            System.out.println("Введите id который надо удалить");
                            int d = sc.nextInt();
                            productR.delete(d);
                            break;
                        case 3:  return;
                        default: throw new IllegalStateException("Unexpected value: " + i);
                    }
                    break;
                case 4:
                    System.out.println(prodTypeR.getAll());
                    System.out.println(text);
                    i = sc.nextInt();
                    switch (i) {
                        case 1:
                            System.out.println("Введите type_name");
                            String typeName = sc.nextLine();
                            prodTypeR.create(new ProductType( typeName));
                            break;
                        case 2:
                            System.out.println("Введите id который надо удалить");
                            int d = sc.nextInt();
                            prodTypeR.delete(d);
                            break;
                        case 3:  return;
                        default: throw new IllegalStateException("Unexpected value: " + i);
                    }
                    break;
                case 5:
                    System.out.println(ordersR.getAll());
                    System.out.println(text);
                    i = sc.nextInt();
                    switch (i) {
                        case 1:
                            System.out.println("Введите user_id, product_id, is_Ordered, purchase_date");
                            Long userId = sc.nextLong();
                            Long prodId = sc.nextLong();
                            int isOrdered = sc.nextInt();
                            sc.nextLine();
                            Date date = Date.valueOf(sc.nextLine());
                           ordersR.create(new Orders( userId,  prodId, isOrdered, date));
                            break;
                        case 2:
                            System.out.println("Введите id который надо удалить");
                            int d = sc.nextInt();
                            ordersR.delete1(d);
                            break;
                        case 3:  return;
                        default: throw new IllegalStateException("Unexpected value: " + i);
                    }
                    break;
                case 6:
                    start();
                    break;
                case 7:
                    System.out.println(viewR.getAll());
                    return;
                default:
                    throw new IllegalStateException("Unexpected value: " + i);
            }
        }
    }
}