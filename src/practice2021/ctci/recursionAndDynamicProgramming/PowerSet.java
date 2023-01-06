package practice2021.ctci.recursionAndDynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class PowerSet {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        Set<Set<Integer>> result = getAllSubsets(arr);
        for (Set<Integer> set : result) {
            System.out.println(set);
        }
    }

    private static Set<Set<Integer>> getAllSubsets(int[] arr) {
        Set<Set<Integer>> subsets = new HashSet<>();
        for (int j : arr) {
            Set<Set<Integer>> subsets_temp = new HashSet<>();
            for (Set<Integer> set : subsets) {
                Set<Integer> newSet = new HashSet<>(set);
                newSet.add(j);
                subsets_temp.add(newSet);
            }
            Set<Integer> newSet = new HashSet<>();
            newSet.add(j);
            subsets.add(newSet);
            subsets.addAll(subsets_temp);
        }
        return subsets;
    }

//    private static Set<Set<Integer>> getAllSubsetsTopDownApproach(int[] arr, int i, Set<Set<Integer>> res) {
//
//        if (i >= arr.length)
//            return new HashSet<>();
//        Set<Set<Integer>> set = new HashSet<>(res);
//        res.addAll(getAllSubsetsTopDownApproach(arr, i+1, addElementstToSets(set, arr[i])));
//        res.addAll(getAllSubsetsTopDownApproach(arr, i+1, res));
//        return res;
//    }

//    private static Set<Set<Integer>> addElementstToSets(Set<Set<Integer>> set, int elem) {
//        Set<Set<Integer>> res = new HashSet<>(set);
//        res.add(new HashSet<>(elem));
//
//        for (Set<Integer> nums: set) {
//            Set<Integer> temp = new HashSet<>(nums);
//            temp.add(elem);
//            res.add(temp);
//        }
//        return res;
//    }

}
