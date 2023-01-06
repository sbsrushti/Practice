package practice2021.ctci.recursionAndDynamicProgramming.refresher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {

    public static void main(String[] args) {

        String str = "abcc";

        Set<String> result = new HashSet<>();
        permutation("", str, result, str.length());

        System.out.println(result);
    }

    private static void permutation(String prefix, String rem, Set<String> result, int len) {

        if (prefix.length() == len) {
            result.add(prefix);
            return;
        }

        for (int i = 0; i < rem.length(); i++) {
            permutation(prefix + rem.charAt(i), rem.substring(0, i) + rem.substring(i+1), result, len);
        }
    }
}
