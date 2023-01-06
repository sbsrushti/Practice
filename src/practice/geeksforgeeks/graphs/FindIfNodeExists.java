package practice.geeksforgeeks.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class FindIfNodeExists {

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdges(0, 1);
        graph.addEdges(0, 2);
        graph.addEdges(1, 3);
        graph.addEdges(1, 4);
//        graph.addEdges(3, 6);
//        graph.addEdges(5, 6);
        graph.addEdges(2, 5);
        graph.addEdges(3, 5);
        graph.addEdges(4, 5);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[6];
        int find = 5;

        while(!queue.isEmpty()) {
            int val = queue.remove();
            visited[val] = true;

            for (Integer item : graph.getAdj(val)) {
                if (item == find) {
                    System.out.println("Found!");
                    return;
                }
                if (!visited[item]) {
                    queue.add(item);
                }
            }
        }
        System.out.println("Not Found!");
    }
}
