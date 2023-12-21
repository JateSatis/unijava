package pract23;

public class TestQueue {
    public static void main(String[] args) {
        ArrayQueueModule aqm = new ArrayQueueModule(5);
        aqm.enqueue(10);
        System.out.println(aqm.isEmpty());
        System.out.println(aqm.peek());
        System.out.println(aqm.dequeue());
        System.out.println(aqm.isEmpty());

        ArrayQueue aq = new ArrayQueue(3);
        aq.enqueue(333);
        aq.enqueue(222);
        aq.enqueue(111);
        System.out.println(aq.isEmpty());
        System.out.println(aq.peek());
        System.out.println(aq.isEmpty());

        ArrayQueueADT queue = new ArrayQueueADT(5);
        ArrayQueueADT.enqueue(queue, 10);
        ArrayQueueADT.enqueue(queue, 20);
        ArrayQueueADT.enqueue(queue, 30);
        System.out.println(ArrayQueueADT.isEmpty(queue));
        System.out.println(ArrayQueueADT.dequeue(queue));
        System.out.println(ArrayQueueADT.isEmpty(queue));
    }
}
