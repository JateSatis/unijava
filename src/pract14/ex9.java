package pract14;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ex9 {
    public static void main(String[] args) {
        String text = "Это текст для анализа";

        Map<Character, Integer> letterFrequency = new HashMap<>();

        Pattern pattern = Pattern.compile("[а-яА-Яa-zA-Z]");

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            char letter = matcher.group().charAt(0);
            letter = Character.toLowerCase(letter);
            letterFrequency.put(letter, letterFrequency.getOrDefault(letter, 0) + 1);
        }

        System.out.println("Частотный словарь букв:");
        for (char letter = 'а'; letter <= 'я'; letter++) {
            int frequency = letterFrequency.getOrDefault(letter, 0);
            System.out.println(letter + ": " + frequency);
        }
    }
}

