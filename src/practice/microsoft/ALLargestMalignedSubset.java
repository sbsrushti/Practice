package practice.microsoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ALLargestMalignedSubset {

    public static void main(String[] args) {

        int[] A = new int[] {-3, -2, 1, 0, 8, 7, 1};
        int M = 3;
        Set<Integer> set = new HashSet<>();

        Set<Integer> results = findSolution(A, 0, new ArrayList<>(), M, set);
        int result = Integer.MIN_VALUE;

        for(Integer val : results){
            if (val > result) {
                result = val;
            }
        }
        System.out.println(result);
    }

    private static Set<Integer> findSolution(int[] A, int idx, List<Integer> curr, int M, Set<Integer> result) {

        for (int i = idx; i < A.length; i++) {
            if (curr.size() == 0) {
                curr.add(A[i]);
                result.addAll(findSolution(A, i+1, curr, M, result));
                curr.remove(curr.size()-1);
            } else {
                if ((A[i] - curr.get(curr.size()-1)) % M == 0) {
                    curr.add(A[i]);
                    result.addAll(findSolution(A, i+1, curr, M, result));
                    curr.remove(curr.size()-1);
                }
            }
        }
        if(curr.size() > 1) {
            result.add(curr.size());
        }
        return result;
    }
}
