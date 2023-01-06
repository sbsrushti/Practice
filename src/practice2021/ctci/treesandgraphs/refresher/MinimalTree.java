package practice2021.ctci.treesandgraphs.refresher;

import java.util.List;

public class MinimalTree {

    private static Node createBinaryTree(int[] arr, int start, int end) {

        if (start == end) {
            return new Node(arr[start]);
        }

        if (start > end)
            return null;

        int mid = start + (end - start)/2;
        Node node = new Node(arr[mid]);
        node.left = createBinaryTree(arr, start, mid-1);
        node.right = createBinaryTree(arr, mid+1, end);
        return node;
    }

    private static void printBfs(Node node) {
        List<List<Integer>> depths = Depths.getDepths(node);
        for (List<Integer> list : depths) {
            System.out.println(list);
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};

        Node root = createBinaryTree(arr, 0, arr.length-1);
        printBfs(root);
    }
}
