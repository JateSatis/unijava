package pract11;

import java.sql.Date;

public class Ex3 {
    public static void main(String[] args) {
        StudentWithDate student = new StudentWithDate("Максим", "Данилов", "Программная инженерия", 2022, "ИКБО-06-22", 500, new Date(1094988840000L));
        System.out.println(student.toString("Короткий"));
    }
}
