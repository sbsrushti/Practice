package practice2021.ctci.recursionAndDynamicProgramming;

public class Coins {

    public static void main(String[] args) {

        int n = 4;
        System.out.println(findPaths(n));
    }

    private static Integer findPaths(int n) {

        if (n == 0)
            return 1;

        if (n < 0)
            return 0;

        return findPaths(n-1) + findPaths(n-2) + findPaths(n-3);
    }
}
