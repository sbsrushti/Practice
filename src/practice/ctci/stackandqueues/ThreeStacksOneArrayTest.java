package practice.ctci.stackandqueues;

public class ThreeStacksOneArrayTest {

    public static void main(String[] args) {
        ThreeStacksOneArray stack1 = new ThreeStacksOneArray();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.printStack();
        stack1.push(4);
        stack1.printStack();
        stack1.pop();
        stack1.printStack();

        ThreeStacksOneArray stack2 = new ThreeStacksOneArray();
        stack2.push(4);
        stack2.push(5);
        stack2.push(6);
        stack2.printStack();
        stack2.push(6);
        stack2.pop();
        stack2.pop();
        stack2.pop();
        stack2.pop();
        stack2.printStack();

        ThreeStacksOneArray stack3 = new ThreeStacksOneArray();
        stack3.push(4);
        stack3.push(5);
        stack3.push(6);
        stack3.printStack();
        stack3.push(6);
    }
}
