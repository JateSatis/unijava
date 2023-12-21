package pract19.student;
import java.util.List;
import java.util.Scanner;

public class LabClassUI {
    private LabClass labClass;
    private Scanner scanner;

    public LabClassUI() {
        labClass = new LabClass();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            Student student1 = new Student("Максим Данилов", 190);
            Student student2 = new Student("Артём Лихачев", 191);
            Student student3 = new Student("Андрей Соболев", 170);

            labClass.addStudent(student1);
            labClass.addStudent(student2);
            labClass.addStudent(student3);

            System.out.println("Выберите действие: ");
            System.out.println("1. Вывести остортированный массив студентов");
            System.out.println("2. Найти студента по имени");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    sortStudents();
                    break;
                case 2:
                    findStudent();
                    break;
                default:
                    System.out.println("Цифра выбрана неверно.");
            }
        }
    }

    private void addStudent() {
    }

    private void sortStudents() {
        labClass.sortByAverageScore();
        List<Student> students = labClass.getStudents();
        System.out.println("Отсортированный массив студентов:");
        for (Student student : students) {
            System.out.println("Студент по имени: " + student.getFullName() + " набрал: " + student.getAverageScore());
        }
    }

    private void findStudent() {
        System.out.print("Введите полное имя студента: ");
        String fullName = scanner.nextLine();

        Student student = null;
        try {
            student = labClass.findStudentByFullName(fullName);
        } catch (StudentNoEx e) {
            throw new RuntimeException(e);
        }
        System.out.println("Найденный студент: " + student.getFullName() + " набрал " + student.getAverageScore());
    }
}
