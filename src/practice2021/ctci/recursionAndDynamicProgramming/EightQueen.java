package practice2021.ctci.recursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class EightQueen {

    public static void main(String[] args) {

        int N = 8;
        int[][] arr = new int[N][N];
        List<int[][]> res = new ArrayList<>();
        findPath(N, 0, arr, res);
        List<String> finalStr = new ArrayList<>();

        for (int[][] arr_temp: res) {
            StringBuilder sb = new StringBuilder();
           for (int i = 0; i < arr_temp.length; i++) {
               for (int j = 0; j < arr_temp[i].length; j++) {
                   if (arr_temp[i][j] == 1) {
                       sb.append("(" + i + ", " + j + ")");
                   }
               }
           }
           finalStr.add(sb.toString());
        }
        System.out.println(finalStr);
    }

    private static void findPath(int N, int i, int[][] arr, List<int[][]> res) {

        if (i == N) {
            res.add(arr);
            return;
        }

        for (int j = 0; j < N; j++) {
            if (arr[i][j] != -1) {
                int[][] arr_copy = new int[N][N];
                for (int x = 0; x < arr.length; x++)
                    System.arraycopy(arr[x], 0, arr_copy[x], 0, N);
                invalidateArray(arr_copy, i, j);
                findPath(N, i+1, arr_copy, res);
            }
        }
    }

    private static void invalidateArray(int[][] arr, int i, int j) {
        System.out.println(i + ", " + j);
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length; y++) {
                if (x == i || y == j) {
                    arr[x][y] = -1;
                }
            }
        }
        invalidateTopLeft(arr, i, j);
        invalidateTopRight(arr, i, j);
        invalidateBottomLeft(arr, i, j);
        invalidateBottomRight(arr, i, j);
        arr[i][j] = 1;
    }

    private static void invalidateTopLeft(int[][] arr, int i, int j) {
        if (i < 0 || j < 0) return;
        if (i >= arr.length || j >= arr.length) return;
        arr[i][j] = -1;
        invalidateTopLeft(arr, i-1, j-1);
    }
    private static void invalidateTopRight(int[][] arr, int i, int j) {
        if (i < 0 || j < 0) return;
        if (i >= arr.length || j >= arr.length) return;
        arr[i][j] = -1;
        invalidateTopRight(arr, i-1, j+1);
    }
    private static void invalidateBottomLeft(int[][] arr, int i, int j) {
        if (i < 0 || j < 0) return;
        if (i >= arr.length || j >= arr.length) return;
        arr[i][j] = -1;
        invalidateBottomLeft(arr, i+1, j-1);
    }
    private static void invalidateBottomRight(int[][] arr, int i, int j) {
        if (i < 0 || j < 0) return;
        if (i >= arr.length || j >= arr.length) return;
        arr[i][j] = -1;
        invalidateBottomRight(arr, i+1, j+1);
    }
}
