package practice.ctci.stackandqueues;

public class ThreeStacksOneArray {
    private static int[] arr = new int[9];
    private static boolean[] check = new boolean[3];
    private int startIndex;
    private int top;
    private int count;

    public ThreeStacksOneArray() {
        if (!check[0]) {
            check[0] = true;
            this.count = 1;
        } else if (!check[1]) {
            check[1] = true;
            this.count = 2;
        } else if (!check[2]) {
            check[2] = true;
            this.count = 3;
        }
        this.startIndex = ((arr.length/3) * (count - 1));
        this.top = this.startIndex - 1;
    }

    public void push(int val) {
        if (this.top == ((arr.length/3 * this.count) - 1)) {
            System.out.println("Stack is full");
            return;
        }
        arr[++this.top] = val;
    }

    public int pop() {
        if (this.top == (this.startIndex - 1)) {
            System.out.println("Stack is empty");
            return -1;
        }
        int popVal = arr[this.top];
        this.top--;
        return popVal;
    }

    public void printStack() {
        if (this.top == (this.startIndex - 1)) {
            System.out.println("Stack is empty");
            return;
        }
        for (int i = this.startIndex; i < top; i++) {
            System.out.print(arr[i] + "->");
        }
        System.out.println(arr[top]);
    }
}
