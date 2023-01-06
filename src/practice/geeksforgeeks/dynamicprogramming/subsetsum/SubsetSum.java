package practice.geeksforgeeks.dynamicprogramming.subsetsum;

public class SubsetSum {

    public static void main(String[] args) {

        int[] arr = { 1, 6, 7, 4};
        int k = 5;

        boolean[][] dp = new boolean[arr.length+1][k+1];
        for (int i = 0; i < arr.length+1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < arr.length+1; i++) {
            for (int j = 1; j < k+1; j++) {
                if (arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[arr.length][k]);
//
//        for (int i = 1; i < k+1; i++) {
//            for (int j = 1; j < arr.length+1; j++) {
//                if (arr[j-1] <= i) {
//                    dp[i][j] = dp[i][j-1] || dp[i - arr[j-1]][j-1];
//                } else {
//                    dp[i][j] = dp[i][j-1];
//                }
//            }
//        }
//        System.out.println(dp[k][arr.length]);
    }
}
