package practice.geeksforgeeks.hashing;

import java.util.ArrayList;
import java.util.List;

public class ArrayPairSumDivisibilityProblem {

    public static void main(String[] args) {

        int[] arr = {91, 74, 66, 48};
        int k = 10;

        int[] check = new int[k];

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i] % k;

            if (check[k - val] > 0) {
                check[k - val]--;
            } else {
                check[val]++;
            }
        }

        for (int i = 0; i < check.length; i++) {
            if (check[i] > 0) {
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
    }
}
