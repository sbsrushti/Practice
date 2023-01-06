package practice.geeksforgeeks.string;

public class RemoveAdjDups {

    public static void main(String[] args) {

        String str = "acaaabbbacdddd";
        //gksforgk

        if(str.length() == 0) {
            System.out.println(str);
            return;
        }

        StringBuilder res = new StringBuilder();
        char prev = str.charAt(0);
        int i = 1;
        if (i == str.length() || (i < str.length() && (str.charAt(i) != prev))) res.append(prev);
        while (i < str.length() && str.charAt(i) == prev) {
            i++;
        }

        if (i == str.length()) {
            return;
        }

        while (i < str.length()) {
            Character ch = str.charAt(i);
            i++;
            if (i == str.length() || (i < str.length() && (str.charAt(i) != ch) && (ch != prev))) {
                res.append(ch);
                prev = ch;
            }
            while (i < str.length() && ch == str.charAt(i)) {
                i++;
            }
        }

        System.out.println(res.toString());
    }
}
