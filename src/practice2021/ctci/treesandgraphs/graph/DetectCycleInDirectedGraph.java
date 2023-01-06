package practice2021.ctci.treesandgraphs.graph;

public class DetectCycleInDirectedGraph {

    public static void main(String[] args) {

        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1,3);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);
        graph.print();

        System.out.println(detectCycle(graph));
    }

    private static boolean detectCycle(Graph graph) {

        boolean[] visited = new boolean[graph.noOfNodes];
        boolean[] rec_stack = new boolean[graph.noOfNodes];

        for (int i = 0; i < graph.noOfNodes; i++) {
            if (!visited[i]) {
                if(isCyclic(graph, visited, rec_stack, i)) return true;
            }
        }
        return false;
    }

    private static boolean isCyclic(Graph graph, boolean[] visited, boolean[] rec_stack, int node) {

        visited[node] = true;
        rec_stack[node] = true;

        for (Integer x: graph.adjList[node]) {
            if (rec_stack[x]) return true;
            if (!visited[x]) {
                if(isCyclic(graph, visited, rec_stack, x)) return true;
            }
        }
        rec_stack[node] = false;
        return false;
    }
}

//node: 0, visited=[F, F, F, F, F], rec_stack=[F, F, F, F, F]
//visited[0] = T
//rec_stack[0] = T
//x: 1, 2

//node: 1, visited=[T, F, F, F, F], rec_stack=[T, F, F, F, F]
//visited[1] = T
//rec_stack[1] = T
//x: 3

//node: 3, visited=[T, T, F, F, F], rec_stack=[T, T, F, F, F]
//visited[3] = T
//rec_stack[3] = T
//x: 2, 4

//node: 4, visited=[T, T, F, T, F], rec_stack=[T, T, F, T, F]
//visited[4] = T
//rec_stack[4] = T
//x:
//rec_stack[4] = F

//node: 2, visited=[T, T, F, T, T], rec_stack=[T, T, F, T, F]
//visited[4] = T
//rec_stack[4] = T
//x:



