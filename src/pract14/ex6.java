package pract14;

import java.util.regex.*;

public class ex6 {
    public static void main(String[] args) {
        String emailAddress = "myhost@@@com.ru";

        boolean isValid = isEmailValid(emailAddress);

        if (isValid) {
            System.out.println("E-mail адрес допустим");
        } else {
            System.out.println("E-mail адрес недопустим");
        }
    }

    public static boolean isEmailValid(String emailAddress) {
        String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(emailAddress);

        return matcher.matches();
    }
}