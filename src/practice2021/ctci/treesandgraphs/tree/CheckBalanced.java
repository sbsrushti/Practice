package practice2021.ctci.treesandgraphs.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CheckBalanced {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.leftChild = node2;
        TreeNode node3 = new TreeNode(3);
        root.rightChild = node3;
        TreeNode node4 = new TreeNode(4);
        node2.leftChild = node4;
        TreeNode node5 = new TreeNode(5);
        node4.rightChild = node5;
        bfs(root);
        int val = checkIfBalanced(root);
        if (val == -1) {
            System.out.print("Not balanced");
        } else {
            System.out.print("Balanced");
        }
    }

    private static int checkIfBalanced(TreeNode node) {

        if (node == null) return 0;

        int leftHeight =  checkIfBalanced(node.leftChild);
        if (leftHeight == -1) return -1;
        else
            leftHeight = 1 + leftHeight;

        int rightHeight = checkIfBalanced(node.rightChild);
        if (rightHeight == -1) return -1;
        else
            rightHeight = rightHeight + 1;

        if (leftHeight - rightHeight > 1 || rightHeight - leftHeight > 1)
            return -1;
        return Math.max(leftHeight, rightHeight);
    }

    private static void bfs(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + " -> ");

            if (temp.leftChild != null)
                queue.add(temp.leftChild);

            if (temp.rightChild != null)
                queue.add(temp.rightChild);
        }
        System.out.print("\n");
    }
}
