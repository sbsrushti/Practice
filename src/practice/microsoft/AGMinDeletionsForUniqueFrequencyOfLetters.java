package practice.microsoft;

import java.util.HashMap;
import java.util.Map;

public class AGMinDeletionsForUniqueFrequencyOfLetters {

    public static void main(String[] args) {

        //String str = "aabbffddeaee";
        //String str = "eeeeffff";
        //String str = "llll";
        String str = "example";
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }

        int count = 0;

        boolean[] arr = new boolean[str.length()+1];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (arr[entry.getValue()]) {
                count++;
                int val = entry.getValue()-1;
                while (val > 0 && arr[val]) {
                    val--;
                    count++;
                }
                if (val == 0) continue;
                arr[val] = true;
            } else {
                arr[entry.getValue()] = true;
            }
        }
        System.out.println(count);
    }
}
