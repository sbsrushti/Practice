package practice.geeksforgeeks.dynamicprogramming;

public class Knapsack {

    public static void main(String[] args) {

        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;

        int[][] dp = new int[value.length][W];

        for (int j = 0; j < W; j++) {
            if (weight[0] <= j+1) {
                dp[0][j] = value[0];
            }
        }

        for (int i = 1; i < value.length; i++) {
            for (int j = 0; j < W; j++) {
                if (weight[i] <= j+1) {
                    int with = dp[i-1][j];
                    int without = dp[i-1][j+1-weight[i]] + value[i];
                    dp[ i ][ j ] = Math.max(with, without);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[value.length-1][W-1]);
    }
}
