package practice.geeksforgeeks.dynamicprogramming.subsetsum;

public class Knapsack {

    public static void main(String[] args) {

        int[] value = {4,5,6};
        int[] weight = {2,6,4};
        int W = 5;

        int[][] dp = new int[weight.length+1][W+1];

        for (int i = 0; i < weight.length+1; i++) {
            for (int j = 0; j < W+1; j++) {
                if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MIN_VALUE;
                }
            }
        }

        for (int i = 1; i < weight.length+1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (weight[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], value[i-1]);
                    if (dp[i-1][j-weight[i-1]] != Integer.MIN_VALUE)
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]] + value[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[weight.length][W]);
    }
}
