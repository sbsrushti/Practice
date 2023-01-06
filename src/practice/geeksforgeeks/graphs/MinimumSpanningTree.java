package practice.geeksforgeeks.graphs;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinimumSpanningTree {

    public static void main(String[] args) {

        class Node {
            int v;
            int cost;

            Node (int v, int cost) {
                this.v = v;
                this.cost = cost;
            }
        }

        int nodes = 3;
        int[][] adj = new int[][]{{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}};

//        int[][] adj = {
//            {0, 5, 3},
//            {0, 0, 2},
//            {0, 0, 0}
//        };

        Set<Integer> visited = new HashSet<>();
        int[] parent = new int[nodes];
        parent[0] = -1;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(final Node node1, final Node node2) {
                if (node1.cost < node2.cost)
                    return -1;
                if (node1.cost > node2.cost)
                    return 1;
                return 0;
            }
        });
        priorityQueue.add(new Node(0, 0));
        int[] weight = new int[nodes];

        for (int i = 1; i < nodes; i++) {
            weight[i] = Integer.MAX_VALUE;
        }

        while (visited.size() != nodes) {
            Node node = priorityQueue.remove();
            visited.add(node.v);
            for (int i = 0; i < adj[node.v].length; i++) {
                if (adj[node.v][i] != 0 && !visited.contains(i)) {
                    if (weight[i] > adj[node.v][i]) {
                        weight[i] = adj[node.v][i];
                    }
                    parent[i] = node.v;
                    priorityQueue.add(new Node(i, weight[i]));
                }
            }
        }
        for (int i = 1; i < parent.length; i++) {
            System.out.println("Path from " + parent[i] + " to " + i + " costs " + adj[parent[i]][i]);
        }
    }
}