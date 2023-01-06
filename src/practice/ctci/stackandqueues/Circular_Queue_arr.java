package practice.ctci.stackandqueues;

public class Circular_Queue_arr {

    int front = -1;
    int rear = -1;
    int[] arr;

    public Circular_Queue_arr(int s) {
        this.arr = new int[s];
    }

    public void enqueue(int val) {
        if (this.rear == -1) {
            this.arr[0] = val;
            this.rear++;
            this.front++;
            return;
        }
        if ((this.rear + 1) % this.arr.length == this.front) {
            System.out.println("Queue is full");
            return;
        }
        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = val;
    }

    public void dequeue() {
        if(this.front == -1 || this.rear == -1){
            System.out.println("Queue is empty");
            return;
        }

        this.arr[this.front] = -1;
        if (this.front == this.rear) {
            this.front = -1;
            this.rear = -1;
        } else {
            this.front = (this.front + 1) % this.arr.length;
        }
    }

    public void printQueue() {
        if(this.front == -1 || this.rear == -1){
            System.out.println("Queue is empty");
            return;
        }

        if(arr[this.front] == -1) {
            System.out.println("Queue is empty");
            return;
        }

        int p = this.front;
        int q = this.rear;

        if (p <= q) {
            while (p <= q) {
                System.out.print(this.arr[p] + "->");
                p++;
            }
        } else {
            while (p < this.arr.length) {
                System.out.print(this.arr[p] + "->");
                p++;
            }
            for (int i = 0; i <= q; i++) {
                System.out.print(this.arr[i] + "->");
            }
        }
    }
}
