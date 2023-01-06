package practice.microsoft;

public class ANMinDeletesToFixString {

    public static void main(String[] args) {

         //String str = "BAABAB";
        //String str = "BBABAA";
        String str = "AABBBB";
        int res = 0;
        int countB = 0;
        if (str.charAt(0) == 'B') {
            res = 1;
            countB++;
        }
        for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) == 'A') {
                    res = min(res + 1, countB);
                } else {
                    countB++;
                }
        }
        System.out.println(res);
    }

    private static int min(int i, int j) {
        if (i < j) return i;
        return j;
    }
}
