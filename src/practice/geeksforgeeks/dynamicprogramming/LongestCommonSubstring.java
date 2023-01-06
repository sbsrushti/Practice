package practice.geeksforgeeks.dynamicprogramming;

public class LongestCommonSubstring {

    public static void main(String[] args) {

        String str1 = "ABCDGH";
        String str2 = "ACDGHR";

//        String str1 = "ABC";
//        String str2 = "BC";

        int[][] dp = new int[str1.length()+1][str2.length()+1];
        int res = 0;

        for (int i = 1; i < str1.length()+1; i++) {
            for (int j = 1; j < str2.length()+1; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if (res < dp[i][j]) {
                        res = dp[i][j];
                    }
                }
            }
        }


//        for (int i = 0; i < str1.length(); i++) {
//            for (int j = 0; j < str2.length(); j++) {
//
//                if (str1.charAt(i) == str2.charAt(j)) {
//                    int prev = 0;
//                    if (i-1 >= 0 && j-1 >= 0) {
//                        prev = dp[i-1][j-1];
//                    }
//                    dp[i][j] = 1 + prev;
//
//                    if (res < dp[i][j]) {
//                        res = dp[i][j];
//                    }
//                }
//            }
//        }

        System.out.println(res);
    }
}
