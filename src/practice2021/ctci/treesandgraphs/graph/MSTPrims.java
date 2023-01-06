package practice2021.ctci.treesandgraphs.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MSTPrims {

    public static void main(String[] args) {

        int[][] graph = new int[][]{{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}};

        int noOfNodes = graph.length;
        Set<Integer> includedNodes = new HashSet<>();
        int[] weights = new int[noOfNodes];
        Arrays.fill(weights, Integer.MAX_VALUE);
        weights[0] = 0;
        int[] parent = new int[noOfNodes];

        while (includedNodes.size() != noOfNodes) {
            int idx = findMinIdx(weights);
            includedNodes.add(idx);
            weights[idx] = Integer.MAX_VALUE;
            for (int i = 0; i < graph[idx].length; i++) {
                if (!includedNodes.contains(i) && graph[idx][i] != 0) {
                    if (weights[i] > graph[idx][i]) {
                        weights[i] = graph[idx][i];
                        parent[i] = idx;
                    }
                }
            }
        }

        for (int i = 0; i < parent.length; i++){
            System.out.println(parent[i] + " -> " + i + " : " + graph[parent[i]][i]);
        }
    }

    private static int findMinIdx(int[] weights) {
        int min = Integer.MAX_VALUE;
        int min_idx = -1;
        for (int i = 0; i < weights.length; i++) {
            if (min > weights[i]) {
                min = weights[i];
                min_idx = i;
            }
        }
        return min_idx;
    }

}
