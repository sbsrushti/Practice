package practice.geeksforgeeks.string;

public class LongestPalindromeSubString {

    public static void main(String[] args) {

        String str = "cbababd";

        int[][] dp = new int[str.length()][str.length()];

        for (int i = 0; i < str.length(); i++) {
            dp[i][i] = 1;
        }

        int max = 1;
        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                dp[i][i+1] = 2;
                max = 2;
            }
        }

        for (int k = 3; k <= str.length(); k++) {
            for (int i = 0; i < str.length()-k+1; i++) {
                int j = i+k-1;
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
                if (max < dp[i][j])
                    max = dp[i][j];
            }
        }

        System.out.println(max);
    }
}
