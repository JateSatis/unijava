package pract23;

public abstract class AbstractQueue {
    protected int size;

    public AbstractQueue() {
        size = 0;
    }

    public abstract void enqueue(int item);

    public abstract int dequeue();

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
