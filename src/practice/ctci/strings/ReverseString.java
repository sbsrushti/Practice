package practice.ctci.strings;

public class ReverseString {

    public static void main(String[] args) {

        String str = "abcdefa";
        if (str.length() == 0)
            return;

        // creating byte array is better
        byte[] bytes = str.getBytes();
        byte[] copys = new byte[bytes.length];

        for(int i = 0; i < bytes.length ; i++) {
            copys[i] = bytes[bytes.length-1-i];
        }
        System.out.println(new String(copys));

        // everytime a new copy is created within the loop - so bad
        String copy = "";
        for (int i = str.length()-1; i >= 0; i--) {
            copy += str.charAt(i);
        }
        System.out.println(copy);

        // String buffer creates an array of strings (which is unnecessary here for chars)
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = str.length()-1; i >= 0; i--) {
            stringBuffer.append(str.charAt(i));
        }
        System.out.println(stringBuffer.toString());
    }
}
