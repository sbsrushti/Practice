package practice.microsoft;

public class AGStringWithNoThreeSameConsecutiveLetters {

    public static void main(String[] args) {

        //String str = "eedaaad";
        //String str = "xxxtxxx";
        String str = "uuuuxaaaaxuuu";
        if (str.length() == 1) System.out.println(str);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length()-1; i++) {
            sb.append(str.charAt(i));
            int count = 1;
            while (i+1 < str.length() && (str.charAt(i) == str.charAt(i+1))) {
                count++;
                i++;
            }
            if (count >= 2) {
                sb.append(str.charAt(i));
            }
        }
        if (str.charAt(str.length()-1) != str.charAt(str.length()-2)) sb.append(str.charAt(str.length()-1));

        System.out.println(sb.toString());
    }
}
