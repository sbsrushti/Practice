package practice2021.ctci.treesandgraphs.tree;

import java.util.ArrayList;

public class        PathsWithSum {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        root.leftChild = node2;
        TreeNode node3 = new TreeNode(-3);
        root.rightChild = node3;
        TreeNode node4 = new TreeNode(3);
        node2.leftChild = node4;
        TreeNode node5 = new TreeNode(2);
        node2.rightChild = node5;
        TreeNode node6 = new TreeNode(1);
        node5.rightChild = node6;
        TreeNode node7 = new TreeNode(3);
        node4.leftChild = node6;
        TreeNode node8 = new TreeNode(-2);
        node4.rightChild = node6;
        TreeNode node9 = new TreeNode(11);
        node3.rightChild = node9;

        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(countNoOfPaths(root, list,8));
    }

    private static int countNoOfPaths(TreeNode root, ArrayList<Integer> list, int value) {
        int count = 0;
        if (root == null) return 0;
        if (list.isEmpty()) {
            list.add(root.val);
        } else {
            for (int i = 0; i < list.size(); i++) {
                int new_val = list.get(i) + root.val;
                if (new_val == value) {
                   count++;
                }
                list.set(i, new_val);
            }
            list.add(root.val);
        }
        System.out.println(root.val);
        System.out.println(list.toString());
        ArrayList<Integer> newList1 = new ArrayList<>();
        newList1.addAll(list);
        ArrayList<Integer> newList2 = new ArrayList<>();
        newList2.addAll(list);
        count += countNoOfPaths(root.leftChild, newList1, value) + countNoOfPaths(root.rightChild, newList2, value);
        return count;
    }
}
