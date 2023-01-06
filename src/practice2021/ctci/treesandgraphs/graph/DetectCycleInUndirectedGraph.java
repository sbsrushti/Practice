package practice2021.ctci.treesandgraphs.graph;

public class DetectCycleInUndirectedGraph {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        //graph.addEdge(0, 2);
        graph.addEdge(1,0);
        graph.addEdge(1,3);
        //graph.addEdge(1,4);
        //graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 3);
        //graph.addEdge(4, 1);

        graph.print();
        System.out.println(detectCycle(graph));
    }

    private static boolean detectCycle(Graph graph) {
        boolean[] visited = new boolean[graph.noOfNodes];
        for(int i = 0; i < graph.noOfNodes; i++) {
            if (!visited[i]) {
                if(isCyclic(i, visited, graph, -1)) return true;
            }
        }
        return false;
    }

    private static boolean isCyclic(int node, boolean[] visited, Graph graph, int parent) {
        visited[node] = true;
        for(Integer x : graph.adjList[node]) {
            if (!visited[x]) {
                if(isCyclic(x, visited, graph, node)) return true;
            } else {
                if (x != parent) return true;
            }
        }
        return false;
    }

    //node = 0, visited = [all false], parent = -1
    //visited[0] = true
    //x: 1

    //isCyclic: node = 1, visited = [T, F, F, F, F], parent = 0
    //visited[1] = true
    //x: 0 3 4

    //isCyclic: node = 3, visited = [T, T, F, F, F], parent = 1
    //visited[3] = true
    //x = 1 2 4

    //isCyclic: node = 4, visited = [T, T, F, T, F], parent = 3
    //visited[4] = true
    //x = 3 1
}
