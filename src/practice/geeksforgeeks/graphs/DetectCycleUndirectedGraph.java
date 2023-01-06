package practice.geeksforgeeks.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleUndirectedGraph {

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdges(0, 1);
        graph.addEdges(1, 2);
        graph.addEdges(2, 0);
        graph.addEdges(2, 3);

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[4];
        queue.add(0);

        while (!queue.isEmpty()) {
            int val = queue.remove();
            if (visited[val]) {
                System.out.println("Cycle detected");
                return;
            }
            visited[val] = true;
            List<Integer> list = graph.getAdj(val);
            for (Integer node: list) {
                if (queue.contains(node)) {
                    System.out.println("Cycle detected");
                    return;
                }
                queue.add(node);
            }
        }
        System.out.println("No Cycle");
    }
}
