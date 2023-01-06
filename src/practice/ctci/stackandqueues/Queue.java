package practice.ctci.stackandqueues;

import practice.ctci.linkedlists.Node;

public class Queue {

    private Node front;
    private Node rear;

    public void enqueue(int val) {
        Node newNode = new Node(val);
        if (this.front == null || this.rear == null) {
            this.front = newNode;
            this.rear = newNode;
        } else {
            this.front.setNext(newNode);
            this.front = newNode;
        }
    }

    public Node dequeue() {
        if (this.rear == null) {
            System.out.println("Queue is empty");
            return null;
        }
        if (this.rear == this.front) {
            this.front = null;
        }
        Node deletedNode = this.rear;
        this.rear = this.rear.getNext();
        return deletedNode;
    }

    public void printQueue() {
        if (this.rear == null) {
            System.out.println("null");
            return;
        }
        this.rear.printList();
    }
}
