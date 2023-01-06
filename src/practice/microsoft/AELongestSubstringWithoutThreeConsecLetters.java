package practice.microsoft;

public class AELongestSubstringWithoutThreeConsecLetters {

    public static void main(String[] args) {

        String str = "abaaaab";
        String max_str = str;
        int max = 0;
        int start_idx = 0;
        int end_idx = 0;

        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            while (i+1 < str.length() && (str.charAt(i) == str.charAt(i+1))) {
                count++;
                if (count == 3) {
                    end_idx = i;
                    if (max < (end_idx +1 - start_idx)) {
                        max = end_idx +1 - start_idx;
                        max_str = str.substring(start_idx, end_idx+1);
                    }

                    while (i+1 < str.length() && (str.charAt(i) == str.charAt(i+1))) {
                        i++;
                    }

                    if (i+1 < str.length()) {
                        i = i-1;
                        start_idx = i;
                    }
                }
                i++;
            }
        }
        System.out.println(max_str);
    }
}
