package pract14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ex4 {
    public static void main(String[] args) {
        String input = "В этой строке есть знак";

        String regexPattern = ".*\\+.*";

        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            System.out.println("Строка содержит символ +");
        } else {
            System.out.println("Строка не содержит символ +");
        }
    }
}
