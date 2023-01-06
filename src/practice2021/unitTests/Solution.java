package practice2021.unitTests;

import java.util.*;
import org.junit.*;
import org.junit.runner.JUnitCore;
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
public class Solution {

    MinimumSpanningWeight msw = new MinimumSpanningWeight();

    public static void main(String[] args) {
        JUnitCore.main(args);
    }

    @Test
    public void testMSTWeightPos() {
        Edge[] edges = new Edge[10];
        edges[0] = new Edge(0, 1, 5);
        edges[1] = new Edge(1, 4, 4);
        edges[2] = new Edge(3, 4, 9);
        edges[3] = new Edge(1, 3, 3);
        edges[4] = new Edge(2, 3, 6);
        edges[5] = new Edge(0, 2, 1);
        edges[6] = new Edge(0, 3, 2);
        edges[7] = new Edge(1, 2, 3);
        edges[8] = new Edge(2, 5, 7);
        edges[9] = new Edge(3, 5, 6);

        int v = 6;

        Assert.assertEquals(16, msw.findMinSpanningWeight(edges, v));
    }

    @Test
    public void testMSTWeightPos1() {
        Assert.assertEquals(0, msw.findMinSpanningWeight(new Edge[0], 0));
    }
}

class Edge {
    int src;
    int dest;
    int w;

    Edge(int src, int dest, int w) {
        this.src = src;
        this.dest = dest;
        this.w = w;
    }
}

class MinimumSpanningWeight {

    class Parent {
        int val;
        int rank = 1;

        Parent(int val) {
            this.val = val;
        }
    }

    public int findMinSpanningWeight(Edge[] edges, int v) {

        int result = 0;
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge a, Edge b) {
                return a.w - b.w;
            }
        });

        Parent[] parent = new Parent[v];
        for (int i = 0; i < v; i++) {
            parent[i] = new Parent(i);
        }
        // 0, 1, 2, 3, 4, 5

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i].src;
            int dest = edges[i].dest;

            int find_src = find(src, parent);
            int find_dest = find(dest, parent);

            if (find_src != find_dest) {
                System.out.println("src: " + src + ", dest: " + dest + ", w: " + edges[i].w);
                result += edges[i].w;
                union(find_src, find_dest, parent);
            }
        }

        return result;
    }


    private int find(int x, Parent[] parent) {

        if (parent[x].val != x) {
            parent[x].val = find(parent[x].val, parent);
        }

        return parent[x].val;
    }

    private void union(int find_x, int find_y, Parent[] parent) {

        if (parent[find_x].rank == parent[find_y].rank) {
            parent[find_x].val = find_y;
            parent[find_y].rank += parent[find_x].rank;

        } else if (parent[find_x].rank > parent[find_y].rank) {
            parent[find_y].val = find_x;
            parent[find_x].rank += parent[find_y].rank;

        } else {
            parent[find_x].val = find_y;
            parent[find_y].rank += parent[find_x].rank;
        }
    }
}
