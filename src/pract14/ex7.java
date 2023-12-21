package pract14;

import java.util.regex.*;

public class ex7 {
    public static void main(String[] args) {
        String password = "smart_pasS";
        boolean isStrong = isPasswordStrong(password);

        if (isStrong) {
            System.out.println("Пароль надежный.");
        } else {
            System.out.println("Пароль не надежный.");
        }
    }

    public static boolean isPasswordStrong(String password) {
        if (password.length() < 8) {
            return false;
        }

        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            return false;
        }

        if (!Pattern.compile("[a-z]").matcher(password).find()) {
            return false;
        }

        if (!Pattern.compile("\\d").matcher(password).find()) {
            return false;
        }

        return true;
    }
}