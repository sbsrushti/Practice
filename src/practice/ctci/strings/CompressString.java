package practice.ctci.strings;

import java.util.ArrayList;
import java.util.List;

public class CompressString {

    public static void main(String[] args) {

        String str = "abcd";
        StringBuilder comp = new StringBuilder();
        int strLength = str.length();
        int i = 0;

        while(i < strLength) {
            char x = str.charAt(i);
            int count = 1;
            i++;
            while (i < strLength && str.charAt(i) == x) {
                i++;
                count++;
            }
            comp.append(x);
            comp.append(count);
        }
        String compString = comp.toString();
        if (compString.length() > strLength) {
            compString = str;
        }
        System.out.println(compString);
    }
}
