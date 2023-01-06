package practice.ctci.strings;

public class SetRowColZero {

    public static void main(String[] args) {

        int[][] arr = {{1,2,0},{0,1,1},{1,1,1}};
        int m = arr.length;
        int n = arr[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j++) {
                if (rows[i] || cols[j]) {
                    arr[i][j] = 0;
                }
                System.out.println(arr[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
}
