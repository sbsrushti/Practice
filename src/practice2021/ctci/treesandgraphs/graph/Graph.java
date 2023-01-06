package practice2021.ctci.treesandgraphs.graph;

import java.util.LinkedList;

public class Graph {

    LinkedList<Integer>[] adjList;
    int noOfNodes;
    public Graph(int m) {
        this.noOfNodes = m;
        adjList = new LinkedList[m];
        for (int i = 0; i < m; i++) {
            adjList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int s, int d) {
        LinkedList<Integer> list = this.adjList[s];
        list.add(d);
    }

    public void print() {
        for (int i = 0; i < adjList.length; i++) {
            System.out.print(i + " -> ");
            for (Integer x: this.adjList[i]) {
                System.out.print(x + " ");
            }
            System.out.print("\n");
        }
    }
}
