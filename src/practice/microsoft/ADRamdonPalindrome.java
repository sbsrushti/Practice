package practice.microsoft;

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class ADRamdonPalindrome
{
    public static void main (String[] args) throws IOException {
        // your code goes here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            String str = br.readLine();

            if (str.equals("0")) break;
            int val = findMinSwaps(str);
            if (val == -1) {
                System.out.println("Impossible");
            } else {
                System.out.println(val);
            }
        }
    }

    private static int findMinSwaps(String str) {

        Map<Integer, Integer> map = new HashMap<>();
        if (str == null) return -1;
        if (str.length() == 0) return -1;
        Set<Character> set = new HashSet<Character>();

        for (int i = 0; i < str.length(); i++) {

            if (set.contains(str.charAt(i))) {
                set.remove(str.charAt(i));
            } else {
                set.add(str.charAt(i));
            }
        }

        if (set.size() > 1) return -1;
        char[] charArr = str.toCharArray();
        int n = str.length();
        int count = 0;

        for (int i = 0; i < (str.length()/2); i++) {

            int j = n-1-i;

            if (charArr[i] != charArr[j]) {

                int k = j-1;
                for (k = j-1; k > i; k--) {
                    if (charArr[k] == charArr[i]) {
                        break;
                    }
                }

                for (int p = k; p <= j-1; p++) {
                    count++;
                    char temp = charArr[p];
                    charArr[p] = charArr[p+1];
                    charArr[p+1] = temp;
                }
            }
        }

        return count;
    }
}
