package practice.geeksforgeeks.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinRoomToAccomodateAllIntervals {

    public static void main(String[] args) {

        int[][] pairs = { { 5, 10}, { 3, 7 }, { 1, 2 } , {8, 9}};

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(final int[] o1, final int[] o2) {
                if (o1[0] < o2[0])
                    return -1;
                if (o1[0] > o2[0])
                    return 1;
                return 0;
            }
        });

        pq.addAll(Arrays.asList(pairs));

        int res = 0;
        while (!pq.isEmpty()) {
            int[] pair = pq.peek();
            pq.remove(pair);
            int min = pair[1];
            while (!pq.isEmpty()){
                int[] peek = pq.peek();
                if (peek[0] > min) {
                    min = peek[1];
                    pq.remove(peek);
                }
            }
            res++;
        }

        System.out.println(res);
    }
}
