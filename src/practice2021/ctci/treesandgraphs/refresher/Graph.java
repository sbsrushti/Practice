package practice2021.ctci.treesandgraphs.refresher;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    List<Integer>[] graph;
    boolean directed = false;

    public Graph(int size, boolean directed) {
        graph = new ArrayList[size];
        this.directed = directed;
        for (int i = 0; i < size; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void addEdge(int s, int d) {
        this.graph[s].add(d);
        if (!this.directed)
            this.graph[d].add(s);
    }

    public List<Integer> getChildren(int s) {
        return this.graph[s];
    }

    public int size() {
        return this.graph.length;
    }
}
