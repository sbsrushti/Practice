package practice2021.ctci.treesandgraphs.refresher;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RouteBetweenNodes {

    private static List<Integer> route(int s, int d, Graph graph) {
        List<Integer> result = new ArrayList<>();
        if (s == d) {
            result.add(s);
            return result;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            Integer curr = queue.remove();
            result.add(curr);
            if (curr == d)
                return result;
            for (Integer adj: graph.getChildren(curr)) {
                if (!result.contains(adj))
                    queue.add(adj);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Graph graph = new Graph(10, true);
        graph.addEdge(0, 1);
        graph.addEdge(1, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 5);

        System.out.println(route(0, 5, graph));
    }
}
