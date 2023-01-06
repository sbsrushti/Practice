package practice.geeksforgeeks.hashing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortingElementsByFrequency {

    public static void main(String[] args) {

        class CustomComparator implements Comparator<Integer> {

            Map<Integer, Integer> count;
            CustomComparator(Map<Integer, Integer> count) {
                this.count = count;
            }

            @Override
            public int compare(Integer val1, Integer val2) {
                if (this.count.get(val1).equals(this.count.get(val2))) {
                    return val1 - val2;
                } else {
                    return this.count.get(val2) - this.count.get(val1);
                }
            }
        }

        Integer[] arr = {5, 5, 5, 4, 6, 4};
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        Arrays.sort(arr, new CustomComparator(map));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
