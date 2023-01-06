package practice.geeksforgeeks.graphs;

import java.util.ArrayList;
import java.util.List;

public class FindAllPathsBetweenTwoNodes {

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

        List<List<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[6];
        findAllPaths(list, new ArrayList<>(), 1, 2, visited, graph);
        for (List<Integer> items : list) {
            System.out.println(items.toString());
        }
    }

    private static void findAllPaths(List<List<Integer>> list, List<Integer> cur, int now, int dest, boolean[] visited, Graph graph) {

        if (now == dest) {
            List<Integer> newList = new ArrayList<>(cur);
            newList.add(now);
            list.add(newList);
            return;
        }

        cur.add(now);
        visited[now] = true;
        for (Integer item : graph.getAdj(now)) {
            if (!visited[item]) {
                findAllPaths(list, cur, item, dest, visited, graph);
            }
        }
        cur.remove(cur.size()-1);
        visited[now] = false;
    }
}
