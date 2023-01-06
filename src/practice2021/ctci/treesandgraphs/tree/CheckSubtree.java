package practice2021.ctci.treesandgraphs.tree;

public class CheckSubtree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        root.leftChild = node2;
        TreeNode node3 = new TreeNode(4);
        root.rightChild = node3;
        TreeNode node4 = new TreeNode(1);
        node2.leftChild = node4;
        TreeNode node5 = new TreeNode(5);
        node3.rightChild = node5;

        TreeNode nodea = new TreeNode(4);
        TreeNode nodeb = new TreeNode(5);
        nodea.rightChild = nodeb;

        TreeNode node1 = findNode(root, nodea);
        System.out.println(isItSubtree(node1, nodea));
    }

    private static boolean isItSubtree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;
        return isItSubtree(node1.leftChild, node2.leftChild) && isItSubtree(node1.rightChild, node2.rightChild);
    }

    private static TreeNode findNode(TreeNode root, TreeNode node) {

        if (root == null)
            return null;

        if (root.val == node.val)
            return root;

        TreeNode temp = findNode(root.leftChild, node);
        if (temp != null)
            return temp;

        return findNode(root.rightChild, node);
    }
}
