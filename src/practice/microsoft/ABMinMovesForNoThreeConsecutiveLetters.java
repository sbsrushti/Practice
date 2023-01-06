package practice.microsoft;

public class ABMinMovesForNoThreeConsecutiveLetters {

    public static void main(String[] args) {

        String str = "baaaaa";
        //String str = "baaabbaabbba";
        //String str = "baabab";

        System.out.print(solution(str));
    }

    private static int solution(String str) {
        StringBuilder newStr = new StringBuilder();
        int i = 0;
        int j = str.length() - 1;
        int result = 0;

        while (i <= j) {
            int count = 1;
            char x = str.charAt(i);
            newStr.append(x);
            while ((i+1) <= j && x == str.charAt(i+1)) {
                count++;
                i++;
                if (count == 3) break;
            }
            if (count == 2) {
                newStr.append(x);
            }
            if (count == 3){
                if (i+2 <= j) {
                    if (str.charAt(i+2) == x) {
                        newStr.append(x);
                        newStr.append(complimentOfX(x));
                    } else {
                        newStr.append(complimentOfX(x));
                        newStr.append(x);
                    }
                } else {
                    newStr.append(x);
                    newStr.append(complimentOfX(x));
                }
                result++;
            }
            i++;
        }
        System.out.println(newStr.toString());
        return result;
    }

    private static char complimentOfX(char x) {
        if (x == 'a') return 'b';
        else return 'a';
    }
}
