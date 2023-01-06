package practice2021.ctci.strings.refresher;

public class UniqueCharacterString {

    public static void main(String[] args) {
        String str = "g";
        System.out.println(findIfStringIsUnique(str));
    }

    private static boolean findIfStringIsUnique(String str) {
        if (str == null)
            return false;
        int checker = 1;
        for (int i = 0; i < str.length(); i++) {
            int temp = 1;
            int chVal = str.charAt(i);
            temp = temp << chVal;
            if ((checker & temp) != 0) {
                return false;
            }
            checker = checker | temp;
        }
        return true;
    }
}
