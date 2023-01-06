package practice.geeksforgeeks.graphs;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int v;
    private List<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public int getNoOfNode() {
        return v;
    }

    public void addEdges(int v, int w) {
        this.adj[v].add(w);
    }

    public List<Integer> getAdj(int v) {
        return this.adj[v];
    }
}
