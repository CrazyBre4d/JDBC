package vlas.validation;


import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Validator {

        public static String getMD5Hash(String input) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8));
                String myHash = DatatypeConverter.printHexBinary(messageDigest).toUpperCase();
                return myHash;

            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("MD5 должен быть поддержан вашей Java Virtual Machine.", e);
            }
        }


   /* public static boolean validatePassword(String username, String enteredPassword) {
        String dbPassword = getPasswordFromDatabase(username);
        if (dbPassword != null) {
            // Хеширование введенного пароля (это должно быть вашей логикой хеширования)
            String hashedEnteredPassword = hashPassword(enteredPassword);

            // Сравниваем хешированный введенный пароль с хешем из базы данных
            return hashedEnteredPassword.equals(dbPassword);
        }
        return false; // Пользователь не найден в базе данных
    }*/
    }


