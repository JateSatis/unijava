package pract23;

public class LinkedQueue {
    private Node front;
    private Node rear;
    private int size;

    private class Node {
        int item;
        Node next;
        Node(int item, Node next) {
            this.item  = item;
            this.next = next;
        }
    }

    public LinkedQueue(int size) {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int item) {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь полна");
        }
        Node oldRear = rear;
        rear = new Node(item, null);

        if (isEmpty()) {
            front = rear;
        }
        else {
            oldRear.next = rear;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста");
        }
        int item = front.item;
        size--;
        front = front.next;
        if (isEmpty()) {
            rear = null;
        }
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста");
        }
        return front.item;
    }
    public int getSize() {
        return size;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }
}
