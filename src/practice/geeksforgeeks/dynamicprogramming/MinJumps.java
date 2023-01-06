package practice.geeksforgeeks.dynamicprogramming;

public class MinJumps {

    public static void main(String[] args) {

        //int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int[] arr = {5, 4, 3, 2, 1};
        int[] dp = new int[arr.length];
        dp[0] = 0;

        for (int i = 1; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (i - j <= arr[j]) {
                    if (min > dp[j] + 1) {
                        min = dp[j] + 1;
                    }
                }
            }
            dp[i] = min;
        }
        System.out.println(dp[arr.length-1]);
    }
}
