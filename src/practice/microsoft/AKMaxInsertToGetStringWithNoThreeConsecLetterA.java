package practice.microsoft;

public class AKMaxInsertToGetStringWithNoThreeConsecLetterA {

    public static void main(String[] args) {

        //String str = "aabab";
        //String str = "dog";
        //String str = "aa";
        String str = "baaaa";
        int res = 0;

        for(int i = 0; i < str.length(); i++) {
            int count = 0;
            if (str.charAt(i) == 'a') count = 1;
            while (str.charAt(i) == 'a' && i+1 < str.length() && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            if (count >= 3) {
                System.out.println(-1);
                return;
            }
            if (str.charAt(i) == 'a' && count <= 1) {
                res = res + (2 - count);
            }
            if (str.charAt(i) != 'a') {
                if ((i > 0 && str.charAt(i-1) != 'a') || (i == 0)) {
                    res = res + 2;
                }
            }
        }
        if (str.charAt(str.length()-1) != 'a') {
            res = res + 2;
        }

        System.out.println(res);
    }
}
