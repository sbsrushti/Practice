package practice.geeksforgeeks.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleDirectedGraph {

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdges(0, 1);
        graph.addEdges(2, 0);
        graph.addEdges(1, 3);
        graph.addEdges(2, 2);

        boolean[] arr = new boolean[4];
        detectCycle(graph, arr);
    }

    private static void detectCycle(Graph graph, boolean[] arr) {

        int[] in_degree = new int[graph.getNoOfNode()];

        for (int i = 0; i < graph.getNoOfNode(); i++) {
            for (Integer node : graph.getAdj(i)) {
                in_degree[node]++;
            }
        }
        int visited_count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < in_degree.length; i++) {
            if (in_degree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            visited_count++;
            Integer val = queue.remove();
            for (int node : graph.getAdj(val)) {
                in_degree[node]--;
                if (in_degree[node] == 0) {
                    queue.add(node);
                }
            }
        }

        if (visited_count == graph.getNoOfNode()) {
            System.out.println("No Cycle");
        } else {
            System.out.println("Cycle is found");
        }
    }
}
