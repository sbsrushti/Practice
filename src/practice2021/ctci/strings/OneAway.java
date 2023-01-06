package practice2021.ctci.strings;

public class OneAway {

    public static void main(String[] args) {

        String s1 = "pale";
        String s2 = "pales";

        System.out.print(checkIfOneAway(s1, s2));
    }

    private static boolean checkIfOneAway(String s1, String s2) {

        String maxString = s1;
        String minString = s2;
        int maxLen = maxString.length();
        int minLen = minString.length();

        if (maxLen < minLen)
            maxString = s2;
            minString = s1;

        if (maxLen - minLen > 1)
            return false;

        if (maxLen == minLen)
            return checkOneCharReplacement(s1, s2);

        return  checkOneCharAddition(maxString, minString);
    }

    private static boolean checkOneCharReplacement(String s1, String s2) {
        boolean allowOneAway = true;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (allowOneAway)
                    allowOneAway = false;
                else
                    return false;
            }
        }
        return true;
    }

    private static boolean checkOneCharAddition(String max, String min) {

        boolean allowOneAway = true;
        int j = 0;
        for(int i = 0; i < max.length() && j < min.length(); i++) {
            if (max.charAt(i) != min.charAt(j)) {
                if (allowOneAway) {
                    allowOneAway = false;
                    j--;
                } else
                    return false;
            }
            j++;
        }
        return true;
    }
}
