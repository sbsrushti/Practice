package practice.ctci.treeandgraphs;

import java.util.LinkedList;
import java.util.Queue;

public class DFS {

    public static void main(String[] args) {

        BinaryTreeNode head = new BinaryTreeNode(1);
        head.left = new BinaryTreeNode(2);
        head.right = new BinaryTreeNode(3);
        BinaryTreeNode x = head.left;
        x.left = new BinaryTreeNode(4);
        x.right = new BinaryTreeNode(5);

        dfs(head);
        bfs(head);
    }

    private static void dfs(BinaryTreeNode head) {

        if (head == null)
            return;

        System.out.print(head.getVal());
        dfs(head.left);
        dfs(head.right);
    }

    private static void bfs(BinaryTreeNode head) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if (head != null) {
            queue.add(head);
        }
        while (!queue.isEmpty()) {
            BinaryTreeNode removed = queue.remove();
            System.out.print(removed.getVal());
            if (removed.left != null) {
                queue.add(removed.left);
            }
            if (removed.right != null) {
                queue.add(removed.right);
            }
        }
    }
}
