package pract6;

import java.util.Scanner;

public interface Customizable {
    default String getValueFromUser(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
