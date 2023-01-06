package practice2021.ctci.strings;

public class StringCompression {

    public static void main(String[] args) {

        String s1 = "";
        System.out.println(compressedString(s1));
    }

    private static String compressedString(String str) {

        if (str == null)
            return null;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); ) {
            int count = 1;
            char ch = str.charAt(i);
            i++;
            while(i < str.length() && (str.charAt(i) == ch)) {
                count++;
                i++;
            }
            sb.append(ch);
            sb.append(count);
        }

        if (sb.length() < str.length())
            return sb.toString();
        return str;
    }
}
