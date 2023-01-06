package practice2021.ctci.recursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Parens {

    public static void main(String[] args) {

        int n = 3;

        List<String> res = new ArrayList<>();
        parens("", n, 0, 0, res);
        System.out.println(res);
    }

    private static void parens(String root, int n, int open, int close, List<String> res) {

        if (open == close && close == n) {
            res.add(root);
            return;
        }

        if (open == close) {
            parens(root + "(", n, open+1, close, res);
        } else {
            if (open < n) {
                parens(root + "(", n, open+1, close, res);
            }
            if (close < n) {
                parens(root + ")", n, open, close+1, res);
            }
        }
    }
}
