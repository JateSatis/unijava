package pract9;

public class Student {
    private String name;
    private String surname;
    private String specialty;
    private String group;
    private int year;
    private int gpa;

    public Student(int gpa) {
        this.gpa = gpa;
    }

    public Student(String name, String surname, String specialty, String group, int year, int gpa) {
        this.name = name;
        this.surname = surname;
        this.specialty = specialty;
        this.group = group;
        this.year = year;
        this.gpa = gpa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getGroup() {
        return group;
    }

    public int getYear() {
        return year;
    }

    public int getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "name: " + name + "; surname: " + surname + "; specialty: " + specialty + "; group: " + group + "; year: " + year + "; GPA: " + gpa;
    }
}
