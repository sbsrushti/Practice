package practice.microsoft;

import java.util.Arrays;

public class ALLargestInteger {

    public static void main(String[] args) {

        int[] arr = new int[] {-1, -4, 3, 2, -2, 5, -3};
//        int[] arr = new int[] {1, 2, 3, -4};
        // -4, -3, -2, -1, 2, 3, 5
        if (arr.length == 0 || arr.length == 1) {
            System.out.println(0);
            return;
        }

        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;

        while (i < j && arr[i] < 0) {
            if ((arr[i] * -1)  == arr[j]) {
                System.out.println(arr[j]);
                return;
            }

            while (i < j && arr[i] < 0 && ((arr[i] * -1) > arr[j])) {
                i++;
            }

            while (i < j && arr[i] < 0 && ((arr[i] * -1) < arr[j])) {
                j--;
            }
        }
        System.out.println(0);
    }
}