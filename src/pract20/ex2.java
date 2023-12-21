package pract20;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class MinMax<T extends Comparable<T>> {
    private final Collection<T> collection;

    public MinMax(Collection<T> collection) {
        this.collection = collection;
    }

    public T findMin() {
        if (collection == null || collection.isEmpty()) {
            return null;
        }

        Iterator<T> iterator = collection.iterator();
        T min = iterator.next();
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (current.compareTo(min) < 0) {
                min = current;
            }
        }
        return min;
    }

    public T findMax() {
        if (collection == null || collection.isEmpty()) {
            return null;
        }

        Iterator<T> iterator = collection.iterator();
        T max = iterator.next();
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (current.compareTo(max) > 0) {
                max = current;
            }
        }
        return max;
    }
}

class Calculator {
    public static <T extends Number, S extends Number> double add(T first, S second) {
        return first.doubleValue() + second.doubleValue();
    }

    public static <T extends Number, S extends Number> double subtract(T first, T second) {
        return first.doubleValue() - second.doubleValue();
    }

    public static <T extends Number, S extends Number> double multiply(T first, T second) {
        return first.doubleValue() * second.doubleValue();
    }

    public static <T extends Number, S extends Number> double divide(T first, T second) {
        return first.doubleValue() / second.doubleValue();
    }
}

public class ex2 {
    public static void main(String[] args) {
        List<Double> intList = Arrays.asList(5.0, 2.0, 9.0, 1.0, 7.0);
        MinMax<Double> intMinMax = new MinMax<>(intList);


        System.out.println("Minimum value: " + intMinMax.findMin());
        System.out.println("Maximum value: " + intMinMax.findMax());

        System.out.println(Calculator.add(10, 5.4));
    }
}
