package practice.ctci.stackandqueues;

public class Queue_arr {

    int[] arr;
    int front = -1;
    int rear = -1;

    public Queue_arr(int s) {
        arr = new int[s];
    }

    public void enqueue(int val) {
        if (this.front < this.arr.length-1) {
            this.arr[++this.front] = val;
            if (this.rear == -1) this.rear = 0;
        }
        else {
            System.out.println("Queue is full");
        }
    }

    public void dequeue() {
        if (this.rear > this.front || this.rear == -1) {
            System.out.println("Queue is empty");
        } else {
            this.rear++;
        }
    }

    public void printQueue() {
        if (this.rear > this.front || this.rear == -1) {
            System.out.println("Queue is empty");
        }
        for (int i = this.rear; i <= this.front; i++) {
            System.out.print(this.arr[i] + "->");
        }
    }
}
