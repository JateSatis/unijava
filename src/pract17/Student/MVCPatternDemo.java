package pract17.Student;

public class MVCPatternDemo {
    public static void main(String[] args) {
        Student model = retrieveStudentFromDatabase();
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        controller.setStudentName("Maxim");
        controller.setStudentRollNo("5");

        controller.updateView();
    }

    public static Student retrieveStudentFromDatabase() {
        return new Student("1", "Artem");
    }
}
