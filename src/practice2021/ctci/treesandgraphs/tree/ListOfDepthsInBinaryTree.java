package practice2021.ctci.treesandgraphs.tree;

import java.util.ArrayList;
import java.util.List;

public class ListOfDepthsInBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.leftChild = node1;
        root.rightChild = node2;
        TreeNode node3 = new TreeNode(3);
        node1.leftChild = node3;
        TreeNode node4 = new TreeNode(4);
        node2.rightChild = node4;
        TreeNode node5 = new TreeNode(5);
        node4.rightChild = node5;

        List<List<TreeNode>> list = new ArrayList<>();
        fetchListOfDepths(root, list, 0);
        for (List<TreeNode> nodes: list) {
            for (TreeNode node: nodes) {
                System.out.print(node.val + ", ");
            }
            System.out.print("\n");
        }
    }

    private static void fetchListOfDepths(TreeNode root, List<List<TreeNode>> list, int depth) {
        if (root == null) return;
        if (list.size() < depth+1) {
            List<TreeNode> childList = new ArrayList<>();
            childList.add(root);
            list.add(childList);
        } else {
            List<TreeNode> childList = list.get(depth);
            childList.add(root);
        }
        fetchListOfDepths(root.leftChild, list, depth+1);
        fetchListOfDepths(root.rightChild, list, depth+1);
    }
}
