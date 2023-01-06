package practice2021.ctci.treesandgraphs.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    public TreeNode root;

    public BST(TreeNode node) {
        this.root = node;
    }

    public void bfs() {
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
