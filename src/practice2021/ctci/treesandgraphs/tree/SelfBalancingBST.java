package practice2021.ctci.treesandgraphs.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SelfBalancingBST {

    TreeNode root;

    public void insert(int value) {

        TreeNode node = new TreeNode(value);
        if (root == null) {
            root = node;
            return;
        }

        TreeNode cur = root;
        TreeNode p = null;
        TreeNode p_p = null;

        while (true) {
            if (value < cur.val) {
                if (cur.leftChild == null) break;
                p_p = p;
                p = cur;
                cur = cur.leftChild;
            } else {
                if (cur.rightChild == null) break;
                p_p = p;
                p = cur;
                cur = cur.rightChild;
            }
        }

        if (p == null || (p.leftChild != null && p.rightChild != null)) {
            if (value < cur.val) cur.leftChild = node;
            else cur.rightChild = node;
            return;
        }

        TreeNode temp;
        if (value > cur.val) {
            if (p.rightChild == cur) {
                cur.leftChild = p;
                p.rightChild = null;
                cur.rightChild = node;
                temp = cur;
            } else {
                node.leftChild = cur;
                node.rightChild = p;
                p.leftChild = null;
                temp = node;
            }
        } else {
            if (p.rightChild == cur) {
                node.leftChild = p;
                p.rightChild = null;
                node.rightChild = cur;
                temp = node;
            } else {
                cur.leftChild = node;
                cur.rightChild = p;
                p.leftChild = null;
                temp = cur;
            }
        }

        if (p_p == null) {
            root = temp;
            return;
        }
        if (p_p.leftChild == p) {
            p_p.leftChild = temp;
        } else {
            p_p.rightChild = temp;
        }
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

    public static void main(String[] args) {
        SelfBalancingBST bst = new SelfBalancingBST();
        bst.insert(10);
        bst.bfs();
        bst.insert(3);
        bst.bfs();
        bst.insert(2);
        bst.bfs();
        bst.insert(6);
        bst.bfs();
        bst.insert(4);
        bst.bfs();
        bst.insert(1);
        bst.bfs();
        bst.insert(0);
        bst.bfs();
    }
}
