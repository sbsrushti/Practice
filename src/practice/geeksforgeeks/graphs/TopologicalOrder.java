package practice.geeksforgeeks.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalOrder {

    public static void main(String[] args) {

        Graph graph = new Graph(4);
        graph.addEdges(0, 1);
        graph.addEdges(2, 1);
        graph.addEdges(2, 0);
        graph.addEdges(2, 3);

        int[] in_degree = new int[graph.getNoOfNode()];

        for(int i = 0; i < graph.getNoOfNode(); i++) {
            for (Integer node : graph.getAdj(i)) {
                in_degree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < in_degree.length; i++) {
            if (in_degree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topoOrder = new LinkedList<>();

        while (!queue.isEmpty()) {
            int val = queue.remove();
            topoOrder.add(val);

            for (Integer node: graph.getAdj(val)) {
                in_degree[node]--;
                if (in_degree[node] == 0) {
                    queue.add(node);
                }
            }
        }

        if (topoOrder.size() != graph.getNoOfNode()) {
            System.out.println("Cycle found");
        } else {
            System.out.println(topoOrder.toString());
        }
    }
}
