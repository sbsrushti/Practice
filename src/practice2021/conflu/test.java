/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    public static void main(String[] args) {

        System.out.println(isMatch("dog", "d*g"));
        System.out.println(isMatch("dog", "d*ge"));
        System.out.println(isMatch("dog", "dog"));
        System.out.println(isMatch("dog", "*"));
        System.out.println(isMatch("", "*"));
        System.out.println(isMatch("", ""));
        System.out.println(isMatch("cat", ""));
        System.out.println(isMatch("cat", "cat*cat"));
    }

// "dogccbat" "do **** c **** b **** t"
// *ttttp*    ttttttttttttttttttttttttttttp

    static boolean isMatch(String value, String pattern)  {

        if (value == null || pattern == null ||
                (!value.isEmpty() && pattern.isEmpty()) || (value.length() + 1 < pattern.length())) return false;

        int i = value.length() - 1;
        int j = pattern.length() - 1;
        int starIdx = -1;

        while (i >= 0 && j >= 0) {

            if (pattern.charAt(j) == '*') {
                break;
            }

            if (pattern.charAt(j) != value.charAt(i)) {
                starIdx = j;
                return false;
            }

            i--;
            j--;
        }

        if (i < 0 && j < 0) return true;

        i = 0;
        j = 0;

        while (j <= starIdx) {

            if (pattern.charAt(j) != value.charAt(i)) {
                return false;
            }
            i++;
            j++;
        }

        return true;
    }
}

// cat   cat      → true
// ^     ^

// cat   a        → false
// ^     ^

// cat   c*t      → true
//   ^     ^


// caat  ca*t
//

//    ^    ^
//

// cat   *t       → true

// dog   c*t      → false

// dog   d*o
//  ^.     ^

// dooge  do*ge
// ^.

// cat  cat*     -> true
//
