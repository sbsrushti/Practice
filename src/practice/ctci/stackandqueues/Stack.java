package practice.ctci.stackandqueues;

import practice.ctci.linkedlists.Node;

public class Stack {

    private Node top;

    public void push(int val) {
        Node newNode = new Node(val);
        newNode.setNext(this.top);
        this.top = newNode;
    }

    public Node pop() {
        if (this.top == null) return null;
        Node popNode = this.top;
        this.top = top.getNext();
        return popNode;
    }

    public void printStack() {
        this.top.printList();
    }
}
