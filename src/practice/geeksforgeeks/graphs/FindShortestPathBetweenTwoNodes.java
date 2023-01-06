package practice.geeksforgeeks.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindShortestPathBetweenTwoNodes {

    public static void main(String[] args) {

        class Node {
            int v;
            int dist;

            Node(int v, int dist) {
                this.v = v;
                this.dist = dist;
            }
        }
        int N = 6;
        Graph graph = new Graph(N);
        graph.addEdges(0, 1);
        graph.addEdges(0, 2);
        graph.addEdges(1, 3);
        graph.addEdges(1, 4);
//        graph.addEdges(3, 6);
//        graph.addEdges(5, 6);
        graph.addEdges(2, 5);
        graph.addEdges(3, 5);
        graph.addEdges(4, 5);

        List<Integer> visited = new ArrayList<>();
        int[] weights = new int[N];
        for (int i = 1; i < N; i++) {
            weights[i] = Integer.MAX_VALUE;
        }
        int[] parent = new int[N];
        parent[0] = -1;

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return node1.dist - node2.dist;
            }
        });
        pq.add(new Node(0, 0));

        while (visited.size() != N) {
            Node cur = pq.poll();
            visited.add(cur.v);

            for (Integer item : graph.getAdj(cur.v)) {
                if (!visited.contains(item) && weights[item] > 1 + weights[cur.v]) {
                    weights[item] = 1 + weights[cur.v];
                    pq.add(new Node(item, weights[item]));
                    parent[item] = cur.v;
                }
            }
        }

        for (int i = 1; i < N; i++) {
            int temp = i;
            StringBuilder sb = new StringBuilder();
            while (temp != 0) {
                sb.insert(0, temp + " ");
                temp = parent[temp];
            }
            System.out.println("Path from 0 to " + i + ": 0 " + sb.toString());
        }
        //shortestPath(1, 3, graph);
    }
}
