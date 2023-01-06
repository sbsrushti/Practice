package practice2021.ctci.treesandgraphs.refresher;

import javafx.util.Pair;

import java.util.*;

public class MST {

    public static class Node {
        int dist;
        int source;

        public Node(int dist, int source) {
            this.dist = dist;
            this.source = source;
        }
    }

    public static List<Pair<Integer, Integer>> getMST(int[][] graph) {
        List<Pair<Integer, Integer>> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        set.add(0);

        Map<Integer, Node> map = new HashMap<>();
        for (int i = 1; i < graph.length; i++) {
            map.put(i, new Node(Integer.MAX_VALUE, -1));
        }

        int source = 0;
        Pair<Integer, Integer> pair = new Pair<>(-1, source);
        result.add(pair);

        while (set.size() != graph.length) {
            for (int i = 0; i < graph.length; i++) {
                if (!set.contains(i) && graph[source][i] != 0 && graph[source][i] < map.get(i).dist) {
                    map.put(i, new Node(graph[source][i], source));
                }
            }
            int dest = findNextNode(map);
            set.add(dest);
            Pair<Integer, Integer> pair1 = new Pair<>(map.get(dest).source, dest);
            result.add(pair1);
            source = dest;
            map.remove(source);
        }

        return result;
    }

    private static int findNextNode(Map<Integer, Node> map) {
        int lowest_key = Integer.MAX_VALUE;
        int lowest_value = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            if (entry.getValue().dist < lowest_value) {
                lowest_key = entry.getKey();
                lowest_value = entry.getValue().dist;
            }
        }
        return lowest_key;
    }

    public static void main(String[] args) {

        int[][] graph = new int[][]{{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}};

        List<Pair<Integer, Integer>> result = getMST(graph);
        System.out.println(result);
    }


    // 0->1 = 2
    // 0->2 = 3
}
