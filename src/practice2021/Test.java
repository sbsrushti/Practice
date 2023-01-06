package practice2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[][] myNumbers = new int[2][3];
        int[] test = new int[3];
        int[] ex;
        Arrays.fill(test, 1);
//        for (int i = 0; i < myNumbers.length; ++i) {
//            for(int j = 0; j < myNumbers[i].length; ++j) {
//                System.out.println(myNumbers[i][j]);
//            }
//        }
//        for (int i = 0; i < test.length; i++) {
//            System.out.println(test[i]);
//        }

//        int num = 1;
//        test(num);
//        System.out.println(num);
//        Integer object_num = 1;
//        test2(object_num);
//        System.out.println(object_num);

//        HashMap<String, String> map = new HashMap<>();
//        System.out.println(map.size());
//        test3(map);
//        System.out.println(map.size());
//        boolean[] visited = new boolean[1];
//        System.out.println(visited[0]);
//        test4(visited);
//        System.out.println(visited[0]);

    }

    private static void test(int num) {
        System.out.println(num);
        num++;
        System.out.println(num);
    }

    private static void test2(Integer num) {
        System.out.println(num);
        num++;
        System.out.println(num);
    }

    private static void test3(HashMap<String, String> map) {
        map.put("a", "b");
    }

    private static void test4(boolean[] visited) {
        visited[0] = true;
    }
}
