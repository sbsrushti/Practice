package practice2021.ctci.recursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RobotInAGrid {

    public static void main(String[] args) {
        boolean[][] arr = new boolean[3][3];
        for (int i = 0 ; i < arr.length; i++)
            Arrays.fill(arr[i], true);
        arr[1][2] = false;
        List<String> list = new ArrayList<>();
        findPath(2, 2, arr, list);
        System.out.println(list);
    }

    private static boolean findPath(int x, int y, boolean[][] arr, List<String> list) {

        if (x == 0 && y == 0) return true;
        if (x < 0 || y < 0) return false;
        if (!arr[x][y]) return false;
        boolean flag = findPath(x-1, y, arr, list);
        if (flag) {
            list.add("(" + x + "," + y + ")");
            return flag;
        } else {
            flag = findPath(x, y-1, arr, list);
            if (flag) {
                list.add("(" + x + "," + y + ")");
            }
            return flag;
        }
    }
}
