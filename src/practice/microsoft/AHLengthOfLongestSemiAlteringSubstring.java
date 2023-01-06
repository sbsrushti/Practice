package practice.microsoft;

public class AHLengthOfLongestSemiAlteringSubstring {

    public static void main(String[] args) {

        //String str = "baaaaabbabbb";
        //String str = "babba";
        String str = "abaaaa";

        int max = 0;
        int i = 0;
        int count = 0;

        while (i < str.length()) {
            count++;
            int temp = 1;
            while (i+1 < str.length() && (str.charAt(i) == str.charAt(i+1))) {
                i++;
                temp++;
            }

            if (temp == 2) {
                count++;
            } else if (temp > 2) {
                count++;
                if (count > max) {
                    max = count;
                }
                count = 2;
            }
            i++;
        }

        if (count > max) max = count;

        System.out.println(max);
    }
}
