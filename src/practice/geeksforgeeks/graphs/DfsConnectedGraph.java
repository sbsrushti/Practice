package practice.geeksforgeeks.graphs;

import java.util.List;

public class DfsConnectedGraph {

    public static void main(String[] args) {

        Graph g = new Graph(4);

        g.addEdges(0, 1);
        g.addEdges(0, 2);
        g.addEdges(1, 2);
        g.addEdges(2, 0);
        g.addEdges(2, 3);
        g.addEdges(3, 3);

        boolean[] visited = new boolean[4];
        dfsUtil(g, 2, visited);
    }

    private static void dfsUtil(Graph graph, int v, boolean[] visited) {

        System.out.println(v);
        System.out.println("->");
        visited[v] = true;

        List<Integer> adj = graph.getAdj(v);
        for (Integer node : adj) {
            if (!visited[node]) {
                dfsUtil(graph, node, visited);
            }
        }
    }
}
