package practice.microsoft;

import java.util.HashMap;
import java.util.Map;

public class AAMaxSumOfTwoNumsWithEqualDigitSum {

    public static void main(String[] args) {

        int[] A = new int[4];
        A[0] = 51;
        A[1] = 32;
        A[2] = 43;
        A[3] = 42;

        System.out.print(solution(A));
    }

    private static int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            int val = sumDigits(A[i]);
            if(map.containsKey(val)) {
                if (max < (A[i] + map.get(val))) {
                    max = A[i] + map.get(val);
                }
                if (map.get(val) < A[i]) {
                    map.put(val, A[i]);
                }
            } else {
                map.put(val, A[i]);
            }
        }
        return max;
    }

    private static int sumDigits(int num) {
        int sum = 0;

        while (num != 0) {
            sum = sum + (num % 10);
            num = num/10;
        }
        return sum;
    }
}
