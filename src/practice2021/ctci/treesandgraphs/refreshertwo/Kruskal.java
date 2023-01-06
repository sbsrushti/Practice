package practice2021.ctci.treesandgraphs.refreshertwo;

import java.util.*;

class Edge {
    int weight;
    int src;
    int dest;

    Edge(int weight, int src, int dest) {
        this.weight = weight;
        this.src = src;
        this.dest = dest;
    }
}

class Graph {
    int V;
    List<Edge> edges;

    Graph(int V) {
        this.V = V;
        this.edges = new ArrayList<>();
    }
    public void addEdge(int weight, int src, int dest) {
        edges.add(new Edge(weight, src, dest));
    }
}

public class Kruskal {

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(1, 3, 1);
        graph.addEdge(5, 0, 1);
        graph.addEdge(3, 2, 0);
        graph.addEdge(2, 0, 3);
        graph.addEdge(6, 3, 2);
        graph.addEdge(3, 4, 3);
        graph.addEdge(10, 2, 4);
        graph.addEdge(4, 3, 5);
        graph.addEdge(1, 5, 4);

        List<Edge> mst = findMST(graph);
        for (Edge edge: mst) {
            System.out.println(edge.src + ", " + edge.dest + " : " + edge.weight);
        }
    }

    private static List<Edge> findMST(Graph graph) {

        List<Edge> res = new ArrayList<>();
        List<Edge> edges = graph.edges;
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.weight - e2.weight;
            }
        });

        int[] parent = new int[graph.V];
        Arrays.fill(parent, -1);

        // 0   1   2   3   4   5
        // 3   3   5   2   5  -1
        //
        for (Edge edge: edges) {
            int x = edge.src;
            int y = edge.dest;

            int find_x = find(x, parent);
            int find_y = find(y, parent);

            if (find_x == find_y) {
                continue;
            }

            union(find_x, find_y, parent);
            res.add(edge);
        }

        return res;
    }

    private static int find(int x, int[] parent) {
        while (parent[x] != -1){
            x = parent[x];
        }
        return x;
    }

    private static void union(int x, int y, int[] parent) {
        parent[x] = y;
    }
}
