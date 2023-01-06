package practice.microsoft;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {

        int[] A = new int[] {3, 8, 2, 3, 3, 2};
        // write your code in Java SE 8
        HashMap<Integer, Integer> map = new HashMap();

        for(int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                int val = map.get(A[i]);
                map.put(A[i], val++);
            } else {
                map.put(A[i], 1);
            }
        }

        int max = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() == entry.getValue()) {
                if (entry.getKey() > max) {
                    max = entry.getKey();
                }
            }
        }
        System.out.println(max);
    }
}
