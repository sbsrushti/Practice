package practice.geeksforgeeks.dynamicprogramming.subsetsum;

public class MinCoinsNeedsForSum {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 5};
        int k = 4;

        int[][] dp = new int[arr.length+1][k+1];
        for (int i = 0; i < arr.length+1; i++) {
            for (int j = 0; j < k+1; j++) {
                if(j == 0) dp[i][j] = 0;
                else dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < arr.length+1; i++) {
            for (int j = 1; j < k+1; j++) {
                if (arr[i-1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j-arr[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[arr.length][k]);
    }
}
