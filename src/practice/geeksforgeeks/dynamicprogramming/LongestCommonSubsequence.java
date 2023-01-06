package practice.geeksforgeeks.dynamicprogramming;

public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String str1 = "XYZ";
        String str2 = "AXBZC";

        int[][] dp = new int[str1.length()+1][str2.length()+1];
        int max = 0;

        for (int i = 1; i < str1.length()+1; i++) {
            for (int j = 1; j < str2.length()+1; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        max = dp[str1.length()][str2.length()];
//
//        for (int i = 0; i < str1.length(); i++) {
//            for (int j = 0; j < str2.length(); j++) {
//                if (str1.charAt(i) == str2.charAt(j)) {
//                    int prev = 0;
//                    if (i - 1 >= 0 && j - 1 >= 0) prev = dp[i-1][j-1];
//                    dp[i][j] = 1 + prev;
//                } else {
//                    int prev = 0;
//                    if (j-1 >= 0) prev = dp[i][j-1];
//                    if (i-1 >= 0) {
//                        if (dp[i-1][j] > prev)
//                            prev = dp[i-1][j];
//                    }
//                    dp[i][j] = prev;
//                }
//                if (dp[i][j] > max) max = dp[i][j];
//            }
//        }

        System.out.println(max);
    }
}
