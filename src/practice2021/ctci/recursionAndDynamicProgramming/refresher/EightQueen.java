package practice2021.ctci.recursionAndDynamicProgramming.refresher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EightQueen {

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();

        findPath(0, result, new Integer[8]);

        result.forEach(System.out::println);
    }

    private static void findPath(int row, List<List<Integer>> result, Integer[] cols) {

        if (row == 8) {
            List<Integer> list = new ArrayList<>(Arrays.asList(cols));
            result.add(list);
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (checkValid(row, i, cols)) {
                cols[row] = i;
                findPath(row+1, result, cols);
            }
        }
    }

    private static boolean checkValid(int row, int col, Integer[] cols) {

        for (int i = 0; i < row; i++) {
            if (col == cols[i])
                return false;

            if (Math.abs(i - row) == Math.abs(cols[i] - col))
                return false;
        }

        return true;
    }
}
