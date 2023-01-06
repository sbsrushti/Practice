package practice.geeksforgeeks.string;

public class CheckIfStringIsRotated {

    public static void main(String[] args) {

        //azonamazonam
        //onamazonamaz
        //geeksgeeksforgeeksgeeksfor

        String str1 = "geeksforgeeks";
        String str2 = "geeksgeeksfor";

        String str3 = str2 + str2;

        int idx = str3.indexOf(str1);

        if (idx == -1) {
            System.out.println(0);
            return;
        }

        int left = idx;
        int right = (str1.length()*2) - (idx + str1.length());

        if (left == 2 || right == 2) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
        return;
    }
}
