package practice.geeksforgeeks.dynamicprogramming;

public class EditDistance {

    public static void main(String[] args) {

        String str1 = "srushti";
        String str2 = "shruthi";

        int[][] dp = new int[str1.length()+1][str2.length()+1];
//        boolean check = false;
//        for (int i = 0; i < str2.length(); i++) {
//            int val = i+1;
//            if (str1.charAt(0) == str2.charAt(i)) {
//                check = true;
//            }
//            if (check) val--;
//            dp[0][i] = val;
//        }
//
//        check = false;
//        for (int i = 0; i < str1.length(); i++) {
//            int val = i+1;
//            if (str2.charAt(0) == str1.charAt(i)) {
//                check = true;
//            }
//            if (check) val--;
//            dp[i][0] = val;
//        }

        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int val = Math.min(dp[i][j-1] + 1, dp[i-1][j] + 1);
                    dp[i][j] = Math.min(val, dp[i-1][j-1] + 1);
                }
            }
        }
        System.out.println(dp[str1.length()][str2.length()]);
    }
}
