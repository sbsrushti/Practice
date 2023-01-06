package practice.ctci.stackandqueues;

public class TestQueue {

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        //queue.printQueue();
    }
}
