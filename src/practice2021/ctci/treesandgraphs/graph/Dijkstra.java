package practice2021.ctci.treesandgraphs.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dijkstra {

    public static void main(String[] args) {

        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        int noOfNodes = graph.length;
        int[] weight = new int[noOfNodes];
        Arrays.fill(weight, Integer.MAX_VALUE);
        weight[0] = 0;
        int[] parent = new int[noOfNodes];
        //Arrays.fill(parent, -1);
        Set<Integer> allowedNodes = new HashSet<>();

        while (allowedNodes.size() != noOfNodes) {

            int minIdx = findMinIdx(weight);
            allowedNodes.add(minIdx);

            for (int i = 0; i < graph[minIdx].length; i++) {
                if (!allowedNodes.contains(i) && graph[minIdx][i] != 0) {
                    if (weight[i] > weight[minIdx] + graph[minIdx][i]) {
                        weight[i] = weight[minIdx] + graph[minIdx][i];
                        parent[i] = weight[i];
                    }
                }
            }
            weight[minIdx] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < parent.length; i++) {
            System.out.println( i + " : " + parent[i]);
        }
    }

    private static int findMinIdx(int[] weight) {
        int min = Integer.MAX_VALUE;
        int min_idx = -1;

        for (int i = 0; i < weight.length; i++) {
            if (weight[i] < min) {
                min = weight[i];
                min_idx = i;
            }
        }
        return min_idx;
    }
}
