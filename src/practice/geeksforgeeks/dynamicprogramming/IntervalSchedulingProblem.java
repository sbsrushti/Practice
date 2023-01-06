package practice.geeksforgeeks.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

public class IntervalSchedulingProblem {

    public static void main(String[] args) {

        int[][] pairs = {{2,3}, {3,4}, {1,2}};

        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                return arr1[1] - arr2[1];
            }
        });

        int n = pairs.length;
        int res = 0;
        int min = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (min < pairs[i][0]) {
                min = pairs[i][1];
                res++;
            }
        }
        System.out.println(res);
    }
}
