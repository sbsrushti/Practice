package practice.ctci.strings;

import java.util.HashMap;
import java.util.Map;

public class CheckUniqueCharsInString {

    public static void main(String[] args) {
        System.out.println("Check if String has unique characters");
        String str = "abcd";
        //checkUniqueWithBoolArray(str);
        //checkIfStringIsUnique(str);
        check(str);
    }

    // has only lower letters
    private static void check(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                System.out.println("Doesn't have unique characters");
                return;
            }
            checker |= (1 << val);
        }
        System.out.println("Has unique characters");
    }

    private static void checkUniqueWithBoolArray(String str) {
        boolean[] charBoolArray = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charBoolArray[val]) {
                System.out.println("I - Doesn't have unique characters");
                return;
            } else {
                charBoolArray[val] = true;
            }
        }
        System.out.println("I - Has unique characters");
    }

    // need not use map :/
    private static void checkIfStringIsUnique(String str) {
        Map<Character, Boolean> charCheck = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (charCheck.get(str.charAt(i)) != null) {
                System.out.println("II - Doesn't have unique characters");
                return;
            } else {
                charCheck.put(str.charAt(i), true);
            }
        }
        System.out.println("II - Has unique characters");
    }
}
