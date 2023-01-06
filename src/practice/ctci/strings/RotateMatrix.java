package practice.ctci.strings;

public class RotateMatrix {

    public static void main(String[] args) {

        int[][] arr = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        int n = arr.length;
        int[][] copy = new int[n][n];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = arr[n-1-j][i];
                System.out.println(copy[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
}
