package practice2021.ctci.treesandgraphs.graph;

public class RouteBetweenNodes {

    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 0},
                {0, 1, 0, 0}
        };
        boolean[] visited = new boolean[matrix.length];
        System.out.println(checkIfRouteExists(3, 0, matrix, visited));
    }

    private static boolean checkIfRouteExists(int s, int d, int[][] matrix, boolean[] visited) {
        visited[s] = true;
        if (s == d) return true;

        for (int i = 0; i < matrix[s].length; i++) {
            if (matrix[s][i] != 0 && !visited[i]) {
                if (checkIfRouteExists(i, d, matrix, visited)) return true;
            }
        }
        return false;
    }
}
