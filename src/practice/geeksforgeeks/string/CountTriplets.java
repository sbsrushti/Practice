package practice.geeksforgeeks.string;

import java.util.Arrays;

public class CountTriplets {

    public static void main(String[] args) {

        int[] arr = {3, 2, 7};

        if (arr.length < 3) {
            System.out.println(-1);
            return;
        }

        int count = 0;
        Arrays.sort(arr);

        for (int i = arr.length-1; i >= 2; i--) {

            int val = arr[i];
            int x = 0;
            int y = i-1;

            while (y > x) {
                if (arr[x] + arr[y] == val) {
                    count++;
                    x++;
                    y--;
                } else if (arr[x] + arr[y] > val) {
                    y--;
                } else {
                    x++;
                }
            }
        }
        System.out.println(count);
    }
}
