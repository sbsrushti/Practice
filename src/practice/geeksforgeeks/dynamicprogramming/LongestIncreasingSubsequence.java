package practice.geeksforgeeks.dynamicprogramming;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        //int[] arr = {3, 10, 2, 1, 20};
        //int[] arr = {3, 2};
        int[] arr = {50, 3, 10, 7, 40, 80};

        int[] dp = new int[arr.length];
        dp[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (max < dp[j] + 1) {
                        max = dp[j] + 1;
                    }
                }
            }
            dp[i] = max;
        }
        System.out.println(dp[arr.length-1]);
    }
}
