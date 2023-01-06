package practice.geeksforgeeks.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsConnectedGraph {

    public static void main(String[] args) {

        Graph graph = new Graph(4);
        graph.addEdges(0, 1);
        graph.addEdges(0, 2);
        graph.addEdges(1, 2);
        graph.addEdges(2, 0);
        graph.addEdges(2, 3);
        graph.addEdges(3, 3);

        //graph.addEdges(2, 3);
        //graph.addEdges(2, 3);

        boolean[] visited = new boolean[4];
        bfs(graph, 2, visited);
    }

    private static void bfs(Graph graph, int v, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            int val = queue.remove();
            System.out.println(val);
            visited[val] = true;
            List<Integer> childern = graph.getAdj(val);
            for (Integer node: childern) {
                if(!visited[node]) {
                    queue.add(node);
                }
            }
        }
    }
}
