package pract11;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        Scanner scanner = new Scanner(System.in);
        String surname = scanner.nextLine();
        System.out.println("Фамилия разработчика: " + surname);
        System.out.println("Начало работы программы: " + sdf.format(start));
        System.out.println("Конец работы программы: " + sdf.format(new Date()));
    }
}
