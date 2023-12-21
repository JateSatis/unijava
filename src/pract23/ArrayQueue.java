package pract23;

public class ArrayQueue {
    private int[] queue;
    private int size = 0;
    private int front = -1;
    private int rear = -1;

    public ArrayQueue(int capacity) {
        queue = new int[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int item) {
        if (size == queue.length) {
            throw new IllegalStateException("Очередь заполнена");
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = item;
        size++;
        if (front == -1) {
            front = rear;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста");
        }
        int item = queue[front];
        front = (front + 1) % queue.length;
        size--;
        if (isEmpty()) {
            front = -1;
            rear = -1;
        }
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста");
        }
        return queue[front];
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        front = -1;
        rear = -1;
        size = 0;
    }
}
