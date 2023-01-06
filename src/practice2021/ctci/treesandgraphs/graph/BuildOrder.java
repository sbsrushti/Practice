package practice2021.ctci.treesandgraphs.graph;

import java.util.ArrayList;
import java.util.List;

public class BuildOrder {

    public static void main(String[] args) {

       int[][] arr = {
               {0, 0, 0, 1, 0, 0},
               {0, 0, 0, 1, 0, 0},
               {0, 0, 0, 0, 0, 0},
               {0, 0, 1, 0, 0, 0},
               {0, 0, 0, 0, 0, 0},
               {1, 1, 0, 0, 0, 0},
       };

       boolean[] visited = new boolean[arr.length];
       List<Integer> list = new ArrayList<>();
       order(arr, list, visited);
       System.out.println(list);
    }

    private static void order(int[][] arr, List<Integer> list, boolean[] visited) {
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i])
                topologySort(arr, list, visited, i);
        }
    }

    private static void topologySort(int[][] arr, List<Integer> list, boolean[] visited, int node) {

        visited[node] = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[node][i] != 0 && !visited[i]) {
                topologySort(arr, list, visited, i);
            }
        }
        list.add(0, node);
    }
}