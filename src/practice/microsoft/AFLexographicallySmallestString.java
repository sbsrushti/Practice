package practice.microsoft;

public class AFLexographicallySmallestString {

    public static void main(String[] args) {

        String str = "azyabczd";
        if (str == null) return;

        if (str.length() == 0 || str.length() == 1) System.out.println(str);

        int idx = 0;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(idx) < str.charAt(i)) {
                idx = i;
            } else {
                break;
            }
        }

        if (idx == 0) System.out.println(str.substring(1));
        else if (idx == str.length()-1) System.out.println(str.substring(0, str.length()-1));
        else System.out.println(str.substring(0, idx) + str.substring(idx+1));
    }
}
