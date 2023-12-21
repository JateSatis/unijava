package pract14;

import java.util.regex.*;

public class ex5 {
    public static void main(String[] args) {
        String dateString = "31/11/1800";

        boolean isValid = isDateValid(dateString);

        if (isValid) {
            System.out.println("Дата допустима.");
        } else {
            System.out.println("Дата недопустима.");
        }
    }

    public static boolean isDateValid(String dateString) {
        String datePattern = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19\\d{2}|[2-9]\\d{3})$";

        Pattern pattern = Pattern.compile(datePattern);
        Matcher matcher = pattern.matcher(dateString);

        if (matcher.matches()) {
            int year = Integer.parseInt(dateString.substring(6));
            if (year >= 1900 && year <= 9999) {
                return true;
            }
        }

        return false;
    }
}
