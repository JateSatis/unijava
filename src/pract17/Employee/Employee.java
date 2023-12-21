package pract17.Employee;

public class Employee {
    private int hoursPerMonth;
    private int rublesPerHour;
    private String name;

    public Employee(int hoursPerMonth, int rublesPerHour, String name) {
        this.hoursPerMonth = hoursPerMonth;
        this.rublesPerHour = rublesPerHour;
        this.name = name;
    }

    public int getHoursPerMonth() {
        return hoursPerMonth;
    }

    public void setHoursPerMonth(int hoursPerMonth) {
        this.hoursPerMonth = hoursPerMonth;
    }

    public int getRublesPerHour() {
        return rublesPerHour;
    }

    public void setRublesPerHour(int rublesPerHour) {
        this.rublesPerHour = rublesPerHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
