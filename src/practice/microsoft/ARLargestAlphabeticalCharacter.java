package practice.microsoft;

public class ARLargestAlphabeticalCharacter {

    public static void main(String[] args) {

        //String str = "admeDCAB";
        String str = "aBeDbCEd";

        int[] arr = new int[26];
        Character result = '\0';
        for (int i = 0; i < str.length(); i++) {
            int idx = 0;
            Character character;
            if (Character.isLowerCase(str.charAt(i))) {
                idx = str.charAt(i) - 'a';
                character = Character.toUpperCase(str.charAt(i));
            } else {
                idx = str.charAt(i) - 'A';
                character = str.charAt(i);
            }
            arr[idx]++;
            if (arr[idx] == 2) {
                if (result < character) {
                    result = character;
                }
            }
        }

        if (result == '\0') {
            System.out.println("NO");
        } else {
            System.out.println(result);
        }

    }
}
