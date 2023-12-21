package pract23;

public class ArrayQueueADT {
    private int[] queue;
    private int front = -1;
    private int rear = -1;
    private int size = 0;

    public ArrayQueueADT(int capacity) {
        queue = new int[capacity];
    }

    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.size == 0;
    }

    public static int getSize(ArrayQueueADT queue) {
        return queue.size;
    }

    public static void clear(ArrayQueueADT queue) {
        queue.front = -1;
        queue.rear = -1;
        queue.size = 0;
    }

    public static void enqueue(ArrayQueueADT queue, int item) {
        if (queue.size == queue.queue.length) {
            throw new IllegalStateException("Очередь заполнена");
        }
        queue.rear = (queue.rear + 1) % queue.queue.length;
        queue.queue[queue.rear] = item;
        queue.size++;
        if (queue.front == -1) {
            queue.front = queue.rear;
        }
    }

    public static int dequeue(ArrayQueueADT queue) {
        if (isEmpty(queue)) {
            throw new IllegalStateException("Очередь пуста");
        }
        int item = queue.queue[queue.front];
        queue.front = (queue.front + 1) % queue.queue.length;
        queue.size--;
        if (isEmpty(queue)) {
            queue.front = -1;
            queue.rear = -1;
        }
        return item;
    }

    public static int peek(ArrayQueueADT queue) {
        if (isEmpty(queue)) {
            throw new IllegalStateException("Очередь пуста");
        }
        return queue.queue[queue.front];
    }
}
