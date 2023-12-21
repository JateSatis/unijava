package pract19.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LabClass {
    private List<Student> students;

    public LabClass() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void sortByAverageScore() {
        Collections.sort(students, Comparator.comparingDouble(Student::getAverageScore));
    }

    public Student findStudentByFullName(String fullName) throws StudentNoEx {
        for (Student student : students) {
            if (student.getFullName().equals(fullName)) {
                return student;
            }
        }
        throw new StudentNoEx("Student with full name '" + fullName + "' not found.");
    }
}