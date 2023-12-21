package pract11;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите любое время в виде hh:mm:ss: ");
        String userInput = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalTime userTime = LocalTime.parse(userInput, formatter);
        LocalTime currentTime = LocalTime.now();

        if (userTime.isBefore(currentTime)) {
            System.out.println("Введенное вами время раньше системного.");
        } else if (userTime.isAfter(currentTime)) {
            System.out.println("Введенное вами время позднее системного.");
        } else {
            System.out.println("Введенное вами время совпадает с текущим.");

        }
    }
}
