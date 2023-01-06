package practice2021.ctci.recursionAndDynamicProgramming.refresher;

import java.util.ArrayList;
import java.util.List;

public class Parens {

    public static void main(String[] args) {

        int n = 3;
        List<String> result = new ArrayList<>();
        findAll(n, n, n, result, "");
        System.out.println(result);
    }

    private static void findAll(int n, int open, int close, List<String> result, String parens) {

        if (parens.length() == n * 2) {
            result.add(parens);
            return;
        }

        if (open == close) {
            findAll(n, open-1, close, result, parens + "(");
        } else {
            if (open != 0)
                findAll(n, open-1, close, result, parens + "(");

            if (close != 0)
                findAll(n, open, close-1, result, parens + ")");
        }
    }
}
