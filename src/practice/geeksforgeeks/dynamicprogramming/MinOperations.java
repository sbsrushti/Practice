package practice.geeksforgeeks.dynamicprogramming;

public class MinOperations {

    public static void main(String[] args) {

        int n = 7;
        int res = solution(n);
        System.out.println(res);
    }

    private static int solution(int n) {
        if (n >= 0 && n < 4) {
            return n;
        }

        if(n % 2 == 0) {
            return solution(n/2) + 1;
        } else {
            return solution(n-1) + 1;
        }
    }
}
