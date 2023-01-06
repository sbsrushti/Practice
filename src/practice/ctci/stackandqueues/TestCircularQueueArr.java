package practice.ctci.stackandqueues;

public class TestCircularQueueArr {

    public static void main(String[] args) {

        Circular_Queue_arr cir_queue_arr = new Circular_Queue_arr(5);
        cir_queue_arr.enqueue(1);
        cir_queue_arr.enqueue(2);
        cir_queue_arr.enqueue(3);
        cir_queue_arr.enqueue(4);
        cir_queue_arr.enqueue(5);
        cir_queue_arr.printQueue();
        cir_queue_arr.enqueue(6);
        cir_queue_arr.enqueue(7);
        cir_queue_arr.dequeue();
        cir_queue_arr.enqueue(6);
        cir_queue_arr.printQueue();
    }
}
