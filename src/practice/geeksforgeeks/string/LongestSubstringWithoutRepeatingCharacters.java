package practice.geeksforgeeks.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        String str = "ABDEFCABEF";
        int max = 0;
        Set<Character> set = new HashSet<>();

        int i = 0;
        int j = 0;

        while (i < str.length() && j < str.length()) {

            if (!set.contains(str.charAt(j))) {
                set.add(str.charAt(j));
                max = Math.max(max, j - i + 1);
                j++;
            } else {
                set.remove(str.charAt(i));
                i++;
            }
        }
        System.out.println(max);
    }
}
