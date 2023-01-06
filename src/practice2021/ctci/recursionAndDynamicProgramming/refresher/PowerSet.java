package practice2021.ctci.recursionAndDynamicProgramming.refresher;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {

        String str = "abcd";
        List<String> result = new ArrayList<>();
        findAll("", str, result);
        System.out.println(result);
    }

    private static void findAll(String prefix, String rem, List<String> res) {
        for (int i = 0; i < rem.length(); i++) {
            String temp = prefix + rem.charAt(i);
            res.add(temp);
            findAll(temp, rem.substring(i+1), res);
        }
    }
}
