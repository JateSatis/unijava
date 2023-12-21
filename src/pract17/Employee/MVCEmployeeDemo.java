package pract17.Employee;

public class MVCEmployeeDemo {
    public static void main(String[] args) {
        Employee model = retrieveEmployeeFromDatabase();
        EmployeeView view = new EmployeeView();

        EmployeeController controller = new EmployeeController(model, view);

        controller.updateView();

        controller.setEmployeeName("Danil");
        controller.setEmployeeHoursPerMonth(350);
        controller.setEmployeeRublesPerHour(16);

        controller.updateView();
    }

    public static Employee retrieveEmployeeFromDatabase() {
        return new Employee(200, 8, "Andrew");
    }
}
