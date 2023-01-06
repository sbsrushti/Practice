package practice.microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ACMaxNetworkRank {

    public static void main(String[] args) {

        int[] A = new int[] {1,2,3,3};
        int[] B = new int[] {2,3,1,4};
        int N = 4;

        Map<Integer, List<Integer>> map = new HashMap();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            List<Integer> temp = null;
            if (map.containsKey(A[i])) {
                temp = map.get(A[i]);
            } else {
                list.add(A[i]);
                temp = new ArrayList<>();
            }
            temp.add(B[i]);
            map.put(A[i], temp);

            List<Integer> temp_b = null;
            if (map.containsKey(B[i])) {
                temp_b = map.get(B[i]);
            } else {
                list.add(B[i]);
                temp_b = new ArrayList<>();
            }
            temp_b.add(A[i]);
            map.put(B[i], temp_b);
        }

        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                int count = map.get(list.get(i)).size() + map.get(list.get(j)).size();
                if (map.get(list.get(i)).contains(list.get(j))) {
                    count--;
                }
                System.out.println(String.format("For cities %s %s : Rank is %s", i+1, j+1, count));
            }
        }
    }
}
