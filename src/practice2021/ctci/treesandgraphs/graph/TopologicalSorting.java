package practice2021.ctci.treesandgraphs.graph;

import java.util.ArrayList;
import java.util.List;

public class TopologicalSorting {

    // doesnt consider cycles
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1,3);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        //graph.addEdge(4, 0);
        graph.print();
        topologySorting(graph);
    }

    private static void topologySorting(Graph graph) {

        if (graph == null) return;
        boolean[] visited = new boolean[graph.noOfNodes];
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < graph.noOfNodes; i++) {
            if (visited[i]) continue;
            recursive(graph, i, visited, list);
        }
        System.out.print(list.toString());
    }

    private static void recursive(Graph graph, int node, boolean[] visited, List<Integer> list) {
        visited[node] = true;
        for (Integer child: graph.adjList[node]) {
            if (!visited[child]) {
                recursive(graph, child, visited, list);
            }
        }
        list.add(0, node);
    }
}
