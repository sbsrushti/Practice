package practice.geeksforgeeks.random;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class ChocolateDistributionProblem {

    public static void main(String[] args) {

        int n = 5;
        Integer[] arr = {3, 4, 1, 9, 56, 7, 9, 12};
        solutionNotAllPacketsNeedToBeDistributed(n, arr);
    }

    //if not all choco packets need to be distributed
    private static void solutionNotAllPacketsNeedToBeDistributed(int n, Integer[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length-n+1; i++) {
            if (arr[i + n - 1] - arr[i] < min) {
                min = arr[i + n - 1] - arr[i];
            }
        }
        System.out.println(min);
    }


    // If all the choco packets needs to be distributed
    private void solution(int n, Integer[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i = 0;
        for (i = 0; i < n; i++) {
            pq.add(arr[i]);
        }

        while (i < arr.length) {
            int val = pq.remove();
            pq.add(val + arr[i]);
            i++;
        }

        int min = pq.peek();
        System.out.println(min);

        while (pq.size() != 1) {
            pq.remove();
        }
        int max = pq.remove();
        System.out.println(max - min);
    }
}
