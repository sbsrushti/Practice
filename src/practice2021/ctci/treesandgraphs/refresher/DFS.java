package practice2021.ctci.treesandgraphs.refresher;

import java.util.*;
import java.util.stream.Collectors;

public class DFS {

    List<Integer>[] graph;

    public DFS(int size) {
        graph = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    private void addEdge(int s, int d) {
        this.graph[s].add(d);
        this.graph[d].add(s);
    }

    private Set<Integer> dfsTraversal() {
        Set<Integer> visited = new LinkedHashSet<>();
        for (int i = 0; i < this.graph.length; i++) {
            if (!visited.contains(i)) {
                dfsRecur(i, visited);
            }
        }
        return visited;
    }

    private void dfsRecur(int source, Set<Integer> visited) {
        visited.add(source);
        for (Integer adj: this.graph[source]) {
            if (!visited.contains(adj)) {
                dfsRecur(adj, visited);
            }
        }
    }

    private List<Integer> topologicalSorting() {
        List<Integer> topologicalSort = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (!topologicalSortRecur(i, visited, topologicalSort)) {
                    System.out.println("It has a cycle! So no topological order!");
                    return new ArrayList<>();
                }
            }
        }
        return topologicalSort;
    }

    private boolean topologicalSortRecur(int s, boolean[] visited, List<Integer> topologicalSort) {
        visited[s] = true;
        for (Integer adj: this.graph[s]) {
            if (visited[adj] || !topologicalSortRecur(adj, visited, topologicalSort)) {
                return false;
            }
        }
        topologicalSort.add(s);
        return true;
    }

    private boolean detectCycleInUndirectedGraph() {
        boolean[] visited = new boolean[this.graph.length];

        for (int i = 0; i < this.graph.length; i++) {
            if (!visited[i]) {
                if(!detectCycle(i, visited, -1))
                    return false;
            }
        }
        return true;
    }

    private boolean detectCycle(int s, boolean[] visited, int parent) {
        visited[s] = true;
        for (Integer adj: this.graph[s]) {
            if (adj != parent) {
                if (visited[adj] || !detectCycle(adj, visited, s)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DFS graph = new DFS(10);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1,3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(2, 7);

        System.out.println(graph.dfsTraversal());
        System.out.println(graph.topologicalSorting());
        System.out.println(graph.detectCycleInUndirectedGraph());
    }
}
