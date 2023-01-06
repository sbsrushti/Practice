package practice.microsoft;

import java.util.Arrays;

public class AIMinStepsToMakePileSameLength {

    public static void main(String[] args) {

        int[] piles = new int[] {5, 5, 3, 2, 2, 1};
        Arrays.sort(piles);
        // 1 2 2 3 5 5
        // 1 1  1  1  1 1
        int res = 0;
        int temp = 0;
        for (int i = 0; i+1 < piles.length; i++) {
            int count = 1;
            while (i+1 < piles.length && piles[i] == piles[i+1]) {
                i++;
                count++;
            }
            res = res + (temp * count);
            temp++;
        }

        if (piles[piles.length - 1] != piles[piles.length -2]) {
            res = res + temp;
        }

        System.out.println(res);
    }
}
