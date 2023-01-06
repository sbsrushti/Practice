package practice.geeksforgeeks.string;

public class RemoveDuplicates {

    public static void main(String[] args) {

        String str = "geeks for geeks";
        StringBuilder res = new StringBuilder();

        int val = 0;

        for (int i = 0; i < str.length(); i++) {
            int move = str.charAt(i);
            int temp = 1 << move;
            if ((val & temp) == 0) {
                val = val | temp;
                res.append(str.charAt(i));
            }
        }

        System.out.println(res.toString());
    }
}
