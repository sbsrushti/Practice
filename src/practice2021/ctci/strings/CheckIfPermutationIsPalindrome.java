package practice2021.ctci.strings;

public class CheckIfPermutationIsPalindrome {

    public static void main(String[] args) {

        //String str = "  !)";
        String str = "Tact Coa";
        System.out.print(checkIfPermutationIsPalindrome(str));
    }

    private static boolean checkIfPermutationIsPalindrome(String str) {

        if (str == null || str.length() == 0)
            return false;

        int[] charCount = new int[26]; //consider only letters [a-z]; [A-Z] is converted to [a-z]
        boolean checkIfLettersArePresent = false;

        for (int i = 0; i < str.length(); i++) {
            int char_ascii_value = str.charAt(i);
            if (char_ascii_value >= 'A' && char_ascii_value <= 'Z') {
                char_ascii_value += 'a' - 'A';
                if (!checkIfLettersArePresent) checkIfLettersArePresent = true;
            }
            if (char_ascii_value >= 'a' && char_ascii_value <= 'z') {
                charCount[char_ascii_value - 'a']++;
                if (!checkIfLettersArePresent) checkIfLettersArePresent = true;
            }
        }

        if(!checkIfLettersArePresent)
            return false;

        boolean foundOddCharCount = false;

        for (int i: charCount) {
            if (charCount[i] % 2 != 0) {
                if (foundOddCharCount)
                    return false;
                foundOddCharCount = true;
            }
        }
        return true;
    }
}
