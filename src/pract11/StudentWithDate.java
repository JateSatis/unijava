package pract11;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class StudentWithDate {
    private String firstName;
    private String lastName;
    private String major;
    private int year;
    private String group;
    private int gpa;
    private Date birth;

    public StudentWithDate(String firstName, String lastName, String major, int year, String group, int gpa, Date birth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.year = year;
        this.group = group;
        this.gpa = gpa;
        this.birth = birth;
    }

    // Геттеры и сеттеры для каждой переменной экземпляра
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public String shortDateFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d");
        return sdf.format(this.birth);
    }

    public String mediumDateFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d 'в' hh:mm:ss");
        return sdf.format(this.birth);
    }

    public String longDateFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, yyyy, MMM d 'в' hh:mm:ss");
        return sdf.format(this.birth);
    }

    public String toString(String format) {
        if (format.equals("Короткий")) {
            return shortDateFormat();
        } else if (format.equals("Средний")) {
            return mediumDateFormat();
        } else {
            return longDateFormat();
        }
    }
}