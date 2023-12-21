package pract11;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex5 {
    public static void main(String[] args) {
        addingTime();
        deletingTime();
        insertionTime();
    }

    public static void addingTime() {
        ArrayList<Integer> testArr = new ArrayList<>();
        LinkedList<Integer> testLinked = new LinkedList<>();

        System.out.println("Операция добавления: ");
        long startArr = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            testArr.add(i);
        }

        long endArr = System.currentTimeMillis();

        System.out.println("ArrayList time: " + (endArr - startArr));

        long startLinked = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            testLinked.add(i);
        }

        long endLinked = System.currentTimeMillis();

        System.out.println("LinkedList time: " + (endLinked - startLinked));
    }

    public static void deletingTime() {
        ArrayList<Integer> testArr = new ArrayList<>();
        LinkedList<Integer> testLinked = new LinkedList<>();

        for (int i = 0; i < 10000; i++) {
            testArr.add(i);
            testLinked.add(i);
        }

        System.out.println("Операция удаления: ");

        long startArr = System.currentTimeMillis();

        for (int i = 0; i < testArr.size(); i++) {
            testArr.remove(0);
        }

        long endArr = System.currentTimeMillis();

        System.out.println("ArrayList time: " + (endArr - startArr));

        long startLinked = System.currentTimeMillis();

        for (int i = 0; i < testLinked.size(); i++) {
            testLinked.remove(0);
        }

        long endLinked = System.currentTimeMillis();

        System.out.println("LinkedList time: " + (endLinked - startLinked));
    }

    public static void insertionTime() {
        ArrayList<Integer> testArr = new ArrayList<>();
        LinkedList<Integer> testLinked = new LinkedList<>();

        System.out.println("Операция вставки: ");
        long startArr = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            testArr.add(0, i);
        }

        long endArr = System.currentTimeMillis();

        System.out.println("ArrayList time: " + (endArr - startArr));

        long startLinked = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            testLinked.add(0, i);
        }

        long endLinked = System.currentTimeMillis();

        System.out.println("LinkedList time: " + (endLinked - startLinked));
    }
}
