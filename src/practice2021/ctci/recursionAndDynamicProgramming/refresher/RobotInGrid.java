package practice2021.ctci.recursionAndDynamicProgramming.refresher;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class RobotInGrid {

    private static boolean findPath(boolean[][] grid, List<Pair<Integer, Integer>> path,
                                 Pair<Integer, Integer> source, Pair<Integer, Integer> destination) {

        path.add(source);

        if (source.getKey().equals(destination.getKey()) && source.getValue().equals(destination.getValue())) {
            return true;
        }

        if (source.getKey() + 1 < grid.length && grid[source.getKey()+1][source.getValue()]) {
            if(findPath(grid, path, new Pair<>(source.getKey()+1, source.getValue()), destination))
                return true;
        }

        if (source.getValue() + 1 < grid[0].length && grid[source.getKey()][source.getValue()+1]) {
            if(findPath(grid, path, new Pair<>(source.getKey(), source.getValue()+1), destination))
                return true;
        }
        path.remove(source);
        return false;
    }

    public static void main(String[] args) {

        boolean[][] grid = {{true, false, false, false},
                            {true, true, false, false},
                            {false, true, true, true}};

        List<Pair<Integer, Integer>> path = new ArrayList<>();
        Pair<Integer, Integer> source = new Pair<>(0, 0);
        Pair<Integer, Integer> destination = new Pair<>(grid.length-1, grid[0].length-1);

        findPath(grid, path, source, destination);

        System.out.println(path);
    }
}
