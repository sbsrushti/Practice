package practice2021.ctci.treesandgraphs.refreshertwo;
import java.util.*;

public class DFSandBFS {

    public static void main(String[] args) {

        List<Integer>[] nodes = new ArrayList[4];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        nodes[0].add(0);
//        nodes[0].add(2);
//        nodes[0].add(3);

        nodes[1].add(3);
        nodes[2].add(1);

        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[nodes.length];

        for (int i = 0; i < nodes.length; i++) {
            if (!visited[i])
                dfs(nodes, i, res, visited);
        }

        System.out.println(res);

        List<Integer> bfsRes = new ArrayList<>();
        bfs(nodes, bfsRes, visited);
        System.out.println(bfsRes);
    }

    private static void dfs(List<Integer>[] nodes, int node, List<Integer> res, boolean[] visited) {
        res.add(node);
        visited[node] = true;

        List<Integer> children = nodes[node];

        for (Integer child : children) {
            if (!visited[child]) {
                dfs(nodes, child, res, visited);
            }
        }
    }

    private static void bfs(List<Integer>[] nodes, List<Integer> res, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nodes.length; i++) {
            queue.add(i);
            visited[i] = true;
        }

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size != 0) {
                Integer x = queue.remove();
                res.add(x);

                for (Integer y: nodes[x]) {
                    if (!visited[y]) {
                        queue.add(y);
                        visited[y] = true;
                    }
                }

                size--;
            }
        }

    }
}
