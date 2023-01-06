package practice.ctci.strings;

import java.util.ArrayList;
import java.util.List;

public class FindAllPermutations {

    public static void main(String[] args) {

        String str = "abbb";

        List<String> list = new ArrayList<>();
        solution(list, "", str);
        System.out.println(list.toString());
    }

    private static void solution(List<String> list, String curr, String rem) {

        if (rem.length() == 0) {
            list.add(curr);
            return;
        }
        boolean[] check = new boolean[26];
        for (int i = 0; i < rem.length(); i++) {
            if (!check[rem.charAt(i) - 'a']) {
                String remStr = rem.substring(0, i) + rem.substring(i+1);
                solution(list, curr + rem.charAt(i), remStr);
                check[rem.charAt(i) - 'a'] = true;
            }
        }
    }
}
