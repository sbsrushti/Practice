package practice.geeksforgeeks.string;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

    public static void main(String[] args) {
        String str = "abcd";
        List<Character> ch = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            ch.add(str.charAt(i));
        }
        List<String> list = permutations("", ch);
        System.out.println(list.toString());
    }

    private static List<String> permutations(String str, List<Character> ch) {
        List<String> list = new ArrayList<>();
        if (ch.size() == 0) {
            list.add(str);
            return list;
        }
        for (Character c : ch) {
            List<Character> copy = new ArrayList<>(ch);
            copy.remove(c);
            list.addAll(permutations(str + c, copy));
        }
        return list;
    }
}
