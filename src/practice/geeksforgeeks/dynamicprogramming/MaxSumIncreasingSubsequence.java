package practice.geeksforgeeks.dynamicprogramming;

public class MaxSumIncreasingSubsequence {

    public static void main(String[] args) {

        int[] arr = {1, 101, 2, 3, 100, 4, 5};
        int[] dp = new int[arr.length];
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int max = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (max < dp[j] + arr[i]) {
                        max = dp[j] + arr[i];
                    }
                }
            }
            dp[i] = max;
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }
}
