package practice2021.ctci.strings;

public class CheckIfTwoStringsArePermutations {

    public static void main(String[] args) {

        String s1 = " srushti";
        String s2 = "SRUSHTI ";

        System.out.printf("checkIfTheyArePermutationsCaseSensitive: %s", checkIfTheyArePermutationsCaseSensitive(s1, s2));
        System.out.printf("\ncheckIfTheyArePermutationsCaseInSensitive: %s", checkIfTheyArePermutationsCaseInSensitive(s1, s2));
    }

    private static boolean checkIfTheyArePermutationsCaseSensitive(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        int[] countArr = new int[256]; //assume it is a 256 ASCII character set

        for (int i = 0; i < s1.length(); i++) {
            int ch_ascii_value = s1.charAt(i);
            countArr[ch_ascii_value]++;
        }

        for(int i = 0; i < s2.length(); i++) {
            int ch_ascii_value = s2.charAt(i);
            if (countArr[ch_ascii_value] == 0)
                return false;
            else
                countArr[ch_ascii_value]--;
        }
        return true;
    }

    private static boolean checkIfTheyArePermutationsCaseInSensitive(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int[] countArr = new int[256]; //assume it is a 256 ASCII character set

        for (int i = 0; i < s1.length(); i++) {
            int ch_ascii_value = s1.charAt(i);
            if (65 <= ch_ascii_value &&  ch_ascii_value <= 90) {
                ch_ascii_value += 32;
            }
            countArr[ch_ascii_value]++;
        }

        for(int i = 0; i < s2.length(); i++) {
            int ch_ascii_value = s2.charAt(i);
            if (65 <= ch_ascii_value &&  ch_ascii_value <= 90) {
                ch_ascii_value += 32;
            }
            if (countArr[ch_ascii_value] == 0)
                return false;
            else
                countArr[ch_ascii_value]--;
        }
        return true;
    }
}
