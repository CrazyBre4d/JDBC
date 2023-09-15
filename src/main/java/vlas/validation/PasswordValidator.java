package vlas.validation;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordValidator {
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
    }


