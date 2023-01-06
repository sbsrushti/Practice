package practice2021.ctci.recursionAndDynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class PermutationWithoutDups {

    public static void main(String[] args) {
        String str = "abcd";
        Set<String> permutations = new HashSet<>();
        findPermutationsWithDups("", str, permutations);
        System.out.println(permutations);
    }

    private static void findPermutationsWithoutDups(String root, String str, Set<String> permutations) {

        if (str.isEmpty()) {
            permutations.add(root);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            findPermutationsWithoutDups(root + str.charAt(i), str.substring(0, i) + str.substring(i+1), permutations);
        }
    }

    private static void findPermutationsWithDups(String root, String str, Set<String> permutations) {
        if (str.isEmpty()) {
            permutations.add(root);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            findPermutationsWithoutDups(root + str.charAt(i), str.substring(0, i) + str.substring(i+1), permutations);
        }
    }
}
