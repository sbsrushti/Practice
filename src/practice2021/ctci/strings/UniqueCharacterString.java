package practice2021.ctci.strings;

public class UniqueCharacterString {

    public static void main(String[] args) {
        String str = null;
        System.out.printf("Using usingExtraDataStructure: %s", usingExtraDataStructure(str));
        System.out.printf("\nUsing withoutUsingExtraDataStructure: %s", withoutUsingExtraDataStructure(str));
    }

    private static boolean usingExtraDataStructure(String str) {

        if (str == null)
            return false;

        boolean[] check = new boolean[256]; //ascii contains 256 characters
        for (int i = 0; i < str.length(); i++) {
            int ch_ascii_value = str.charAt(i);
            if(check[ch_ascii_value])
                return false;
            else
                check[ch_ascii_value] = true;
        }
        return true;
    }

    // assuming string contains characters only from [a-z]
    private static boolean withoutUsingExtraDataStructure(String str) {

        if (str == null)
            return false;

        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int ch_ascii_value = str.charAt(i) - 'a';
            if ((checker & (1 << ch_ascii_value)) > 0)
                return false;
            checker = checker | 1 << ch_ascii_value;
        }
        return true;
    }
}
