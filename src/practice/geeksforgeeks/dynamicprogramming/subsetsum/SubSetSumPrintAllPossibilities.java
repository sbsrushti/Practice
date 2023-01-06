package practice.geeksforgeeks.dynamicprogramming.subsetsum;

import java.util.ArrayList;
import java.util.List;

public class SubSetSumPrintAllPossibilities {

    public static void main(String[] args) {

        int[] arr = { 1, 6, 7, 4};
        int k = 5;

        boolean[][] dp = new boolean[ arr.length + 1 ][ k + 1 ];
        for (int i = 0; i < arr.length + 1; i++) {
            dp[ i ][ 0 ] = true;
        }

        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                if (arr[ i - 1 ] <= j) {
                    dp[ i ][ j ] = dp[ i - 1 ][ j ] || dp[ i - 1 ][ j - arr[ i - 1 ] ];
                } else {
                    dp[ i ][ j ] = dp[ i - 1 ][ j ];
                }
            }
        }
        System.out.println(dp[ arr.length ][ k ]);

        List<List<Integer>> list = new ArrayList<>();
        if (dp[ arr.length ][ k ]) {
            printAll(list, new ArrayList<>(), k, arr.length, dp, arr);
        }
        System.out.println(list.size());
        for (List<Integer> items : list) {
            System.out.println(items.toString());
        }
    }

    private static void printAll(List<List<Integer>> list, List<Integer> cur, int sum, int idx, boolean[][] dp, int[] arr) {

        if (sum < 0) return;

        if (sum == 0) {
            List<Integer> items = new ArrayList<>(cur);
            list.add(items);
            return;
        }

        for (int i = idx; i > 0; i--) {
            if (dp[i][sum]) {
                cur.add(arr[i-1]);
                printAll(list, cur, sum-arr[i-1], i-1, dp, arr);
                cur.remove(cur.size()-1);
            }
        }
    }
}
