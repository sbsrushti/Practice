package practice.ctci.stackandqueues;

public class Stack_arr {

    int top = -1;
    int[] arr;

    public Stack_arr(int s) {
        this.arr = new int[s];
    }

    public void push(int val) {
        if(this.top == this.arr.length - 1) {
            System.out.println("Stack is full");
            return;
        }

        this.arr[++this.top] = val;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }

        int popVal = this.arr[top];
        top--;
        return popVal;
    }

    public void printStack() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }

        for (int i = 0; i < this.top; i++) {
            System.out.print(this.arr[i] + "->");
        }
        System.out.println(this.arr[top]);
    }
}
