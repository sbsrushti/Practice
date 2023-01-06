package practice2021.ctci.strings;

public class ZeroMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{1,2,0},{1,3,3},{1,0,0}};
        printMatrix(matrix);
        System.out.println("\n");
        zeroMatrix(matrix);
        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {

        for (int[] arr: matrix) {
            for (int i: arr) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }

    private static void zeroMatrix(int[][] matrix) {

        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;

        boolean[] rowCheck = new boolean[m];
        boolean[] colCheck = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowCheck[i] = true;
                    colCheck[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowCheck[i] || colCheck[j])
                    matrix[i][j] = 0;
            }
        }

//        for (int i = 0; i < m; i++) {
//            if (rowCheck[i]) {
//                for (int j = 0; j < n; j++) {
//                   matrix[i][j] = 0;
//                }
//            }
//        }
//
//        for (int j = 0; j < n; j++) {
//            if (colCheck[j]) {
//                for (int i = 0; i < m; i++) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
    }
}
