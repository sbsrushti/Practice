package practice2021.ctci.treesandgraphs.refreshertwo;

import java.util.*;

public class UnionFind {

    public static void main(String[] args) {

        List<Integer>[] nodes = new ArrayList[5];
        for (int i = 0; i < nodes.length; i++)
            nodes[i] = new ArrayList<>();

        nodes[0].add(1);
        //nodes[0].add(2);
        //nodes[1].add(0);
        //nodes[1].add(2);
        nodes[2].add(0);
        nodes[2].add(1);

        System.out.println(isCyclic(nodes));
    }

    // [0: {1, 2}], [1: {0}], [2: {0}]
    //  0  1  2  3  4
    //  1  2 -1 -1 -1

    // x = 1
    // find_x = 2
    // y = 0
    // find_y = 2

    private static boolean isCyclic(List<Integer>[] nodes) {

        int[] parent = new int[nodes.length];
        Arrays.fill(parent, -1);

        for (int i = 0; i < nodes.length; i++) {

            int x = i;

            for (Integer y : nodes[i]) {
                int find_x = find(parent, x);
                int find_y = find(parent, y);

                if (find_x == find_y) {
                    return true;
                }

                union(parent, find_x, find_y);
            }
        }

        return false;
    }

    private static int find(int[] parent, int x) {
        while (parent[x] != -1) {
            x = parent[x];
        }

        return x;
    }

    private static void union(int[] parent, int x, int y) {
        parent[x] = y;
    }
}
