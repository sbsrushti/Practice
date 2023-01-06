package practice.microsoft;

public class AMminAdjacentSwapsToGroupRedBalls {

    public static void main(String[] args) {

        //String str = "WRRWWR";
        //String str = "RRRWRWWWWR";
        //String str = "RRRRRR";
        //String str = "WWWWW";
        String str = "RRWWRRRWWW";
        int result = 0;
        int idx = 0;
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'R') {
                count++;
                idx = idx + i;
            }
        }

        if (count == 0 || count == 1) {
            System.out.println(0);
            return;
        }

        idx = idx / count;

        int i = idx-1;
        int temp = idx-2;
        int count_left = 0;
        while (temp >= 0) {
            while (temp > 0 && str.charAt(temp) != 'R') {
                temp--;
            }
            if (str.charAt(temp) == 'R') {
                count_left++;
                if (str.charAt(i) != 'R') {
                    result = result + (i - temp);
                    i--;
                } else {
                    result = result + (i - temp - 1);
                    i--;
                }
            }
            temp--;
        }

        //String str = "WRRWRW";
        int j = idx+1;
        temp = idx+2;
        int count_right = 0;

        while (temp < str.length()) {
            while (temp < str.length()-1 && str.charAt(temp) != 'R') {
                temp++;
            }
            if (str.charAt(temp) == 'R') {
                count_right++;
                if (str.charAt(j) != 'R') {
                    result = result + (temp - j);
                    j++;
                } else {
                    result = result + (temp - j - 1);
                    j++;
                }
            }
            temp++;
        }

        if (str.charAt(idx) == 'R') {
            System.out.println(result);
        } else {
            if (count_left > count_right) {
                result = result + count_right;
            } else {
                result = result + count_left;
            }
            System.out.println(result);
        }
    }
}
