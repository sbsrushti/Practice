package practice.ctci.stackandqueues;

public class TestQueueArr {

    public static void main(String[] args) {

        Queue_arr queue_arr = new Queue_arr(10);
        queue_arr.enqueue(1);
        queue_arr.printQueue();
        queue_arr.dequeue();
        queue_arr.printQueue();
        queue_arr.enqueue(1);
        queue_arr.enqueue(2);
        queue_arr.enqueue(3);
        queue_arr.dequeue();
        queue_arr.printQueue();
        queue_arr.dequeue();
        queue_arr.dequeue();
        queue_arr.dequeue();
        queue_arr.printQueue();
    }
}
