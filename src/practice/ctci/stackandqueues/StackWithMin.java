package practice.ctci.stackandqueues;

import practice.ctci.linkedlists.Node;

public class StackWithMin {
    Node top = null;
    Node min = null;

    public void push(int val) {
        Node newNode = new Node(val);
        if (top == null) {
            top = newNode;
            min = newNode;
        } else {
            newNode.setNext(top);
            top = newNode;
            if (newNode.getValue() < min.getValue()) {
                min = top;
            }
        }
    }

    public Node pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return null;
        }
        Node popNode = top;
        top = top.getNext();
        return popNode;
    }

    public Node min() {
        if (top == null) {
            System.out.println("Stack is empty");
            return null;
        }
        return min;
    }
}
