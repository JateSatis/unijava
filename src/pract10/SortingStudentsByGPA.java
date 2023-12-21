package pract10;

import java.util.ArrayList;
import java.util.Comparator;

public class SortingStudentsByGPA {
    private ArrayList<Student> iDNumber;

    public SortingStudentsByGPA() {
        iDNumber = new ArrayList<>();
    }

    public void setArray(ArrayList<Student> students) {
        iDNumber = students;
    }

    public void quicksort() {
        quicksort(0, iDNumber.size() - 1);
    }

    private void quicksort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quicksort(low, pivotIndex - 1);
            quicksort(pivotIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        Student pivot = iDNumber.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (iDNumber.get(j).getGpa() >= pivot.getGpa()) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        Student temp = iDNumber.get(i);
        iDNumber.set(i, iDNumber.get(j));
        iDNumber.set(j, temp);
    }

    public void mergesort() {
        mergesort(0, iDNumber.size() - 1);
    }

    private void mergesort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergesort(low, mid);
            mergesort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    private void merge(int low, int mid, int high) {
        ArrayList<Student> temp = new ArrayList<>();
        int i = low;
        int j = mid + 1;

        while (i <= mid && j <= high) {
            if (iDNumber.get(i).getGpa() >= iDNumber.get(j).getGpa()) {
                temp.add(iDNumber.get(i));
                i++;
            } else {
                temp.add(iDNumber.get(j));
                j++;
            }
        }

        while (i <= mid) {
            temp.add(iDNumber.get(i));
            i++;
        }

        while (j <= high) {
            temp.add(iDNumber.get(j));
            j++;
        }

        for (int k = low; k <= high; k++) {
            iDNumber.set(k, temp.get(k - low));
        }
    }

    public void outArray() {
        for (Student student : iDNumber) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + ": " + student.getGpa());
        }
    }

    public void sortByField(Comparator<Student> comparator) {
        iDNumber.sort(comparator);
    }
}
