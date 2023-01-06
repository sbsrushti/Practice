package practice.microsoft;

public class APCropWords {

    public static void main(String[] args) {

        String message = "Codility We test coders and this";
        int K = 25;

        if (K > message.length()) {
            System.out.println(message);
            return;
        }
        int i = message.length()-1;

        while (message.charAt(i) == ' ') {
            i--;
        }
        if (i != message.length()-1) {
            message = message.substring(0, i+1);
        }

        if (message.length() < K) {
            System.out.println(message);
            return;
        }

        int temp = message.length()-1;
        int count = 0;

        while(count != (message.length() - K)) {
            temp--;
            count++;
        }

        if (message.charAt(temp+1) != ' ') {
            while(message.charAt(temp) != ' ') {
                temp--;
            }
        }

        while(message.charAt(temp) == ' ') {
            temp--;
        }

        System.out.println(message.substring(0, temp+1));
    }
}
