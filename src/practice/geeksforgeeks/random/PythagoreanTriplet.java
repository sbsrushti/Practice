package practice.geeksforgeeks.random;

public class PythagoreanTriplet {

    public static void main(String[] args) {

        int a = 5;
        int b = 4;
        int c = 1;

        int max = a;
        int x = b;
        if (max < b) {
            x = max;
            max = b;
        }
        int y = c;
        if (max < c) {
            y = max;
            max = c;
        }

        if ((max * max) == ((x * x) + (y * y))) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
