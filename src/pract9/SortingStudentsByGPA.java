package pract9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class SortingStudentsByGPA implements Comparator<Student> {

    ArrayList<Student> students = new ArrayList<>();

    @Override
    public int compare(Student a, Student b) {
        return Integer.compare(a.getGpa(), b.getGpa());
    }

    public void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int start, int end) {
        Student pivot = students.get(end);
        int pIndex = start;
        for (int j = start; j <= end - 1; j++) {
            if (compare(students.get(j), pivot) <= 0) {
                Collections.swap(students, pIndex, j);
                pIndex++;
            }
        }
        Collections.swap(students, pIndex, end);
        return pIndex;
    }

    public void setArray(ArrayList<Student> students) {
        this.students = students;
    }
    public void printArray() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void mergeSort(ArrayList<Student> arr) {
        if (arr == null || arr.size() <= 1) {
            return;
        }
        int middle = arr.size() / 2;

        ArrayList<Student> left = new ArrayList<>(arr.subList(0, middle));
        ArrayList<Student> right = new ArrayList<>(arr.subList(middle, arr.size()));

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private void merge(ArrayList<Student> arr, ArrayList<Student> left, ArrayList<Student> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (compare(left.get(i), right.get(j)) < 0) {
                arr.set(k++, left.get(i++));
            }
            else {
               arr.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            arr.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            arr.set(k++, right.get(j++));
        }
    }

    public void insertionSort(ArrayList<Student> arr) {
        int n = arr.size();
        for (int i = 1; i < n; i++) {
            Student key = arr.get(i);
            int j = i - 1;

            while (j >= 0 && compare(arr.get(j), key) > 0) {
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }
            arr.set(j + 1,  key);
        }
    }
}
