package practice.ctci.stackandqueues;

public class TestStackArr {

    public static void main(String[] args) {
        Stack_arr stack = new Stack_arr(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.pop();
        stack.printStack();
    }
}
