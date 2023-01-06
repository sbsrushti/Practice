package practice2021.ctci.treesandgraphs.graph;

import java.util.LinkedList;

public class DFSinGraph {

    public static void main(String[] args) {

        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1,3);
        graph.addEdge(3, 2);
        graph.addEdge(2, 1);
        graph.addEdge(4, 0);
        graph.print();
        boolean[] visited = new boolean[graph.adjList.length];
        visited[0] = true;
        dfs(0, graph, visited);
        for (int i = 0; i < visited.length; i++)
            System.out.print(visited[i] + " ");
    }

    //incorrect code!!! refer DFS under refresher package
    private static void dfs(int s, Graph graph, boolean[] visited) {
        System.out.print(s + " ");
        LinkedList<Integer> children = graph.adjList[s];
        for (int x : children) {
            if (!visited[x]) {
                dfs(x, graph, visited);
                visited[x] = true;
            }
        }
    }
}
