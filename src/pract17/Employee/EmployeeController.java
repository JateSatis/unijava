package pract17.Employee;

public class EmployeeController {
    private Employee model;
    private EmployeeView view;

    public EmployeeController(Employee model, EmployeeView view) {
        this.model = model;
        this.view = view;
    }

    public void setEmployeeName(String name) {
        model.setName(name);
    }

    public String getEmployeeName() {
        return model.getName();
    }

    public void setEmployeeHoursPerMonth(int hoursPerMonth) {
        model.setHoursPerMonth(hoursPerMonth);
    }

    public int getEmployeeHoursPerMonth() {
        return model.getHoursPerMonth();
    }

    public void setEmployeeRublesPerHour(int rublesPerHour) {
        model.setRublesPerHour(rublesPerHour);
    }

    public int getEmployeeRublesPerHour() {
        return model.getRublesPerHour();
    }

    public void updateView() {
        view.showEmployeeInformation(getEmployeeName(), wageCalculator());
    }

    public int wageCalculator() {
        return model.getHoursPerMonth() * model.getRublesPerHour();
    }

}
