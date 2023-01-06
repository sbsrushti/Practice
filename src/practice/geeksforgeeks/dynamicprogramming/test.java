package practice.geeksforgeeks.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        Integer test = 1;
        String str = "test";
        sol(list, test, str);
        System.out.println(list.toString());
        System.out.println(test);
        System.out.println(str);
    }

    private static void sol(List<Integer> list, Integer test, String str) {
        list.add(2);
        test = test + 1;
        str = str.concat("1");
    }
}
