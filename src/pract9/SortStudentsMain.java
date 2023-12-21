package pract9;


import java.util.ArrayList;

public class SortStudentsMain {
    public static void main(String[] args) {
        SortingStudentsByGPA sortingStudentsByGPA = new SortingStudentsByGPA();
        ArrayList<Student> studentsToSort = new ArrayList<>();

        studentsToSort.add(new Student("Alice", "Black", "politics", "07", 2, 489));
        studentsToSort.add(new Student("Alice", "Black", "politics", "07", 2, 530));
        studentsToSort.add(new Student("Bob", "Jaeger", "social studies", "01", 5, 487));
        studentsToSort.add(new Student("Charlie", "Puth", "computer science", "10", 4, 544));
        studentsToSort.add(new Student("Alex", "Macedonskiy", "law", "07", 1, 477));
        studentsToSort.add(new Student("Andrew", "Tate", "politics", "06", 3, 492));
        studentsToSort.add(new Student("Ashley", "Usher", "social studies", "05", 4, 372));
        studentsToSort.add(new Student("Albert", "Einstein", "law", "11", 5, 356));
        studentsToSort.add(new Student("Vladimir", "Putin", "computer science", "09", 3, 410));
        studentsToSort.add(new Student("Ivan", "The Bloody", "politics", "12", 1, 490));
        studentsToSort.add(new Student("Nikita", "Anisimov", "politics", "16", 4, 527));
        sortingStudentsByGPA.setArray(studentsToSort);

//        sortingStudentsByGPA.quickSort(0, sortingStudentsByGPA.students.size() - 1);
//        sortingStudentsByGPA.mergeSort(sortingStudentsByGPA.students);
        sortingStudentsByGPA.insertionSort(sortingStudentsByGPA.students);
        sortingStudentsByGPA.printArray();
    }
}