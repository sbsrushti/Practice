package practice2021.ctci.treesandgraphs.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFSinGraph {

    public static void main(String[] args) {

        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1,3);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);
        graph.print();
        boolean[] visited = new boolean[graph.adjList.length];
        bfs(0, visited, graph);
    }

    private static void bfs(int s, boolean[] visited, Graph graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (queue.size() != 0) {
            Integer x = queue.poll();
            if (!visited[x]) {
                System.out.print(x + " ");
                queue.addAll(graph.adjList[x]);
                visited[x] = true;
            }
        }
    }
}
