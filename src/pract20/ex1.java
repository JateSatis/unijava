package pract20;

import java.io.Serializable;

class Animal {}

class GenericClass<T extends Comparable<T>, V extends Animal & Serializable, K> {
    private T first;
    private V second;
    private K third;

    public GenericClass(T first, V second, K third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public K getThird() {
        return third;
    }

    public void showClasses() {
        System.out.println(first.getClass());
        System.out.println(second.getClass());
        System.out.println(third.getClass());
    }
}
