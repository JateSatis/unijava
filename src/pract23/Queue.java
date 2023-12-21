package pract23;

public interface Queue {
    void enqueue(int item);

    int dequeue();

    int peek();

    boolean isEmpty();

    void clear();

    int getSize();
}
