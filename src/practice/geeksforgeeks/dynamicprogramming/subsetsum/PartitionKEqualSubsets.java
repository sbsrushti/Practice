package practice.geeksforgeeks.dynamicprogramming.subsetsum;

import java.util.ArrayList;
import java.util.List;

public class PartitionKEqualSubsets {

    public static void main(String[] args) {

        int[] arr = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        int target = sum/k;

        if (k > arr.length || (sum%k != 0)) {
            System.out.println("False");
            return;
        }

        boolean[] visited = new boolean[arr.length];
        List<List<Integer>> list = new ArrayList<>();
        System.out.println(findAllPartitions(list, new ArrayList<>(), target, visited, 0, arr, k, target));
    }

    private static boolean findAllPartitions(List<List<Integer>> list, List<Integer> cur, int target, boolean[] visited, int idx, int[] arr, int k, int sum) {

        if (target == 0) {
            List<Integer> items = new ArrayList<>(cur);
            list.add(items);
            if (k == 1) return true;
            return findAllPartitions(list, new ArrayList<>(), sum, visited, 0, arr, k-1, sum);
        }
        for (int i = idx; i < arr.length; i++) {
            if (target - arr[i] >= 0 && !visited[i]) {
                visited[i] = true;
                cur.add(arr[idx]);
                if (findAllPartitions(list, cur, target-arr[i], visited, i+1, arr, k, sum)) {
                    return true;
                }
                visited[i] = false;
                cur.remove(cur.size()-1);
            }
        }
        return false;
    }
}
