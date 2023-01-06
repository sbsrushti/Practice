package practice.geeksforgeeks.hashing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MaxSubArrayWithSumZero {

    public static void main(String[] args) {

        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max_len = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum == 0) {
                if (max_len < i+1) {
                    max_len = i+1;
                }
            }
            if (map.containsKey(sum)) {
                int val = i - map.get(sum);
                if (val > max_len) max_len = val;
                map.put(sum, i);
            }
            map.put(sum, i);
        }

        System.out.println(max_len);
    }
}
