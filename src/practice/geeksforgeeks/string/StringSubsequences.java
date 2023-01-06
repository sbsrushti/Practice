package practice.geeksforgeeks.string;

import java.util.ArrayList;
import java.util.List;

public class StringSubsequences {

    public static void main(String[] args) {

        String str = "abcd";
        List<String> list = new ArrayList<>();
        list = subsequences(str, 0, "");
        System.out.println(list.toString());
    }

    private static List<String> subsequences(String str, int idx, String curr) {

        List<String> list = new ArrayList<>();
        if (idx == str.length()) {
            return list;
        }

        for(int i = idx; i < str.length(); i++) {
            list.add(curr + str.charAt(i));
            list.addAll(subsequences(str, i+1, curr + str.charAt(i)));
        }
        return list;
    }
}
