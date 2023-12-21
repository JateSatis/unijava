package pract14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ex3 {
    public static void main(String[] args) {
        String text = "Список цен: $10.99, 150 RUB, 8.50 EU, $25.00, 500 RUB, 12.75 EU";

        String usdPattern = "\\$(\\d+\\.\\d+)";
        String rubPattern = "(\\d+)\\s*RUB";
        String euPattern = "(\\d+\\.\\d+)\\s*EU";

        Pattern usdRegex = Pattern.compile(usdPattern);
        Pattern rubRegex = Pattern.compile(rubPattern);
        Pattern euRegex = Pattern.compile(euPattern);

        Matcher usdMatcher = usdRegex.matcher(text);
        Matcher rubMatcher = rubRegex.matcher(text);
        Matcher euMatcher = euRegex.matcher(text);

        System.out.println("Цены в USD:");
        while (usdMatcher.find()) {
            System.out.println(usdMatcher.group(1));
        }

        System.out.println("Цены в RUB:");
        while (rubMatcher.find()) {
            System.out.println(rubMatcher.group(1));
        }

        System.out.println("Цены в EU:");
        while (euMatcher.find()) {
            System.out.println(euMatcher.group(1));
        }
    }
}
