package practice.ctci.strings;

public class StringRotation {

    public static void main(String[] args) {

        String s1 = "aab";
        String s2 = "aba";
        uff(s1, s2);
    }

    // best way
    private static void uff(String s1, String s2) {
        if(s1.length() != s2.length()) {
            System.out.println("NO");
            return;
        }
        if (isSubstring(s2+s2, s1)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void checkRotation(String s1, String s2) {
        if(s1.length() != s2.length()) {
            System.out.println("NO");
            return;
        }

        if(s1.length() == 1) {
            if (s1.equals(s2)) {
                System.out.println("YES");
                return;
            }
        }

        for (int i = 1; i < s2.length(); i++) {
            if (isSubstring(s1, s2.substring(0, i)) && isSubstring(s1, s2.substring(i, s2.length()))) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    private static boolean isSubstring(String s1, String s2) {
        //youilike
        if (s1.contains(s2)) {
            return true;
        }
        return false;
    }

}
