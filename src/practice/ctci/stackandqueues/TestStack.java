package practice.ctci.stackandqueues;

public class TestStack {

    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.printStack();
    }
}
