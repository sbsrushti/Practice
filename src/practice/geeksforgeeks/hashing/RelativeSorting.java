package practice.geeksforgeeks.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RelativeSorting {

    public static void main(String[] args) {

        int[] arr1 = {2, 6, 7, 5, 2, 6, 8, 4};
        int[] arr2 = {2, 6, 4, 5};

        //2 6 7 5 2 6 8 4
        //2 6 4 5

        List<Integer> remElements = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < arr2.length; i++) {
            list.add(arr2[i]);
        }

        for (int i = 0; i < arr1.length; i++) {
            if (list.contains(arr1[i])) {
                if (count.containsKey(arr1[i])) {
                    count.put(arr1[i], count.get(arr1[i]) + 1);
                } else {
                    count.put(arr1[i], 1);
                }
            } else {
                remElements.add(arr1[i]);
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 1; j <= count.get(arr2[i]); j++) {
                System.out.print(arr2[i] + " ");
            }
        }

        Collections.sort(remElements);

        for (Integer val : remElements) {
            System.out.print(val + " ");
        }
    }
}
