package practice.geeksforgeeks.string;

public class MinInsertionsToFormPalindrome {

    public static void main(String[] args) {

        String str = "geeks";

        int res = solution(str, 0, str.length()-1);
        System.out.println(res);
    }

    private static int solution(String str, int i, int j) {

        if (i == j) {
            return 0;
        }

        if (i > j || i < 0) return 0;

        if (str.charAt(i) == str.charAt(j)) {
            return solution(str, i+1, j-1);
        }

        return Math.min(1 + solution(str, i+1, j), 1 + solution(str, i, j-1));
    }
}
