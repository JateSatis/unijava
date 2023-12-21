package pract13;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ex6 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        FileReader fileReader = new FileReader(filename);

        StringBuilder contents = new StringBuilder();
        int c;
        while ((c = fileReader.read()) != -1) {
            contents.append((char)c);
        }

        System.out.println(sortByLastChar(contents.toString()));
    }

    public static String sortByLastChar(String line) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList(line.split(" ")));
        StringBuilder result = new StringBuilder(words.get(0));
        char currentLastChar = words.get(0).charAt(words.get(0).length() - 1);
        words.remove(0);
        while (!words.isEmpty()) {
            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                if (word.charAt(0) == currentLastChar) {
                    result.append(" ").append(word);
                    currentLastChar = word.charAt(word.length() - 1);
                    words.remove(i);
                    break;
                }
            }
        }
        return result.toString();
    }
}
