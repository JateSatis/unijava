package pract14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ex2 {
    public static void main(String[] args) {
        String input = "abcdefghijklmnopqrstuv18340";
        String pattern = "abcdefghijklmnopqrstuv18340";

        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(input);

        if (matcher.matches()) {
            System.out.println("Строка равна паттерну");
        } else {
            System.out.println("Строка не равна паттерну");
        }
    }
}




