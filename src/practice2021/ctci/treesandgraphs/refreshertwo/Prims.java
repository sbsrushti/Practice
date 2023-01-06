package practice2021.ctci.treesandgraphs.refreshertwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class Node {
    int v;
    int dist;

    Node(int v, int dist) {
        this.v = v;
        this.dist = dist;
    }
}

public class Prims {

    public static void main(String[] args) {

        List<Node>[] adjList = new ArrayList[6];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        adjList[0].add(new Node(1, 5));
        adjList[0].add(new Node(2, 3));
        adjList[0].add(new Node(3, 2));

        adjList[1].add(new Node(3, 1));
        adjList[1].add(new Node(0, 5));

        adjList[2].add(new Node(0, 3));
        adjList[2].add(new Node(3, 6));
        adjList[2].add(new Node(4, 10));

        adjList[3].add(new Node(0, 2));
        adjList[3].add(new Node(1, 1));
        adjList[3].add(new Node(2, 6));
        adjList[3].add(new Node(4, 3));
        adjList[3].add(new Node(5, 4));

        adjList[4].add(new Node(2, 10));
        adjList[4].add(new Node(3, 3));
        adjList[4].add(new Node(5, 1));

        adjList[5].add(new Node(3, 4));
        adjList[5].add(new Node(4, 1));

        findMST(adjList);
        //prims(adjList);
    }

    private static void prims(List<Node>[] adjList) {

        int[] dist = new int[adjList.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        int[] parent = new int[adjList.length];
        parent[0] = -1;

        Set<Integer> mstSet = new HashSet<>();

        while (mstSet.size() != adjList.length) {

            int minVertex = findMin(dist, mstSet);
            System.out.println(minVertex);
            mstSet.add(minVertex);

            for (Node child: adjList[minVertex]) {
                if (!mstSet.contains(child.v) && dist[child.v] > child.dist) {
                    dist[child.v] = child.dist;
                    parent[child.v] = minVertex;
                }
            }
        }

        for (int i = 0; i < parent.length; i++) {
            System.out.println(parent[i] + ", " + i);
        }
    }

    // dist = [0, 1, 3, 2, 3, 1]
    // mstSet = 0, 3, 1, 2, 4, 5
    // parent = [-1, 3, 1, "0", 2, 4]


    // (1,3), (2, 1), (3,0), (4, 2), (5, 4)
    private static int findMin(int[] dist, Set<Integer> mstSet) {

        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        int i = 0;

        while (i < dist.length) {

            if (mstSet.contains(i)) {
                i++;
                continue;
            }

            if (min > dist[i]) {
                min = dist[i];
                minIdx = i;
            }
            i++;
        }

        return minIdx;
    }


    private static void findMST(List<Node>[] adjList) {

        Node[] distArr = new Node[adjList.length];  // distArr: [{0, 0}, {1, +}, {2, +}, {3, +}, {4, +}, {5, +}]
        int[] parent = new int[adjList.length];     // parent: [0, 0, 0, 0, 0, 0]
        boolean[] visited = new boolean[adjList.length];

        PriorityQueue<Node> distQueue = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b) {
                return a.dist - b.dist;
            }
        });

        for (int i = 0; i < adjList.length; i++) {
            int dist = Integer.MAX_VALUE;
            if (i == 0) {
                dist = 0;
                parent[0] = -1;
            }
            distArr[i] = new Node(i, dist);
            distQueue.add(distArr[i]);
        }

        while (!distQueue.isEmpty()) {                      // distArr: [{1, 5}, {2, 3}, {3, 2}, {4, +}, {5, +}]
                                                            // parent: [-1, 0, 0, 0, 0, 0]// sum = 0 + 2 +
            Node shortest = distQueue.remove();             // prev = 3
            visited[shortest.v] = true;

            for (Node child: adjList[shortest.v]) {
                if (!visited[child.v] && distArr[child.v].dist > child.dist) {
                    distQueue.remove(distArr[child.v]);
                    distArr[child.v].dist = child.dist;
                    distQueue.add(distArr[child.v]);
                    parent[child.v] = shortest.v;
                }
            }
        }

        for (int i = 0; i < adjList.length; i++) {
            System.out.println(i + ", " + parent[i]);
        }
    }
}
