package practice.geeksforgeeks.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllFourSumNumbers {

    public static void main(String[] args) {

        //int[] arr = {10, 2, 3, 4, 5, 9, 7, 8};
        //int[] arr = {3, 5, 7, 8};
        int[] arr = {2, 2, 1, 1, 1, 1, 2, 2};
        //int[] arr = {0, 0, 2, 1, 1};
//        int[] arr = {10, 2, 3, 4, 5, 7, 8};

        Set<List<Integer>> set = new HashSet<>();
        solution(arr, set, 0, new ArrayList<>(), 0, 6);

        for (List<Integer> list : set) {
            for (Integer val : list) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    private static void solution(int[] arr, Set<List<Integer>> set, int idx, List<Integer> curr, int currSum, int K) {

        if (curr.size() == 4) {
            if (currSum == K) {
                List<Integer> list = new ArrayList<>(curr);
                set.add(list);
            }
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if ((arr.length - idx) < (4 - curr.size())) return;
            curr.add(arr[i]);
            int sum = currSum + arr[i];
            solution(arr, set, i+1, curr, sum, K);
            curr.remove(curr.size()-1);
        }
    }
}
