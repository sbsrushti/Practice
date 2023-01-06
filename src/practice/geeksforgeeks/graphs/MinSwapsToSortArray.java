package practice.geeksforgeeks.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinSwapsToSortArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        Collections.sort(list);

        int res = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != list.get(i)) {
                int idx = list.indexOf(arr[i]);
                res++;
                swap(arr, i, idx);
                i--;
            }
        }

        System.out.println(res);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
