package practice.ctci.strings;

public class LongestCommonSubstring {

    public static void main(String[] args) {

        String s1 = "geeksforgeek";
        String s2 = "iamwithgeeksnow";
        int[][] arr = new int[s1.length()][s2.length()];
        int max = 0;
        int max_i = 0;
        int max_j = 0;

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = 1 + arr[i-1][j-1];
                    }
                }
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    max_i = i;
                    max_j = j;
                }
            }
        }

        while (max_i >= 0 && max_j >= 0 && arr[max_i][max_j] != 0 ) {
            System.out.print(s1.charAt(max_i));
            max_i--;
            max_j--;
        }
    }
}
