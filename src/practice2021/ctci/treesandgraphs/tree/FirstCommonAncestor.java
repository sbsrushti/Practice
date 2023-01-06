package practice2021.ctci.treesandgraphs.tree;

public class FirstCommonAncestor {

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

        TreeNode x = findCommonAncestor(root, node4, node2);
        if (x != null)
            System.out.println(x.val);
        else
            System.out.println("null");
    }

    private static TreeNode findCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {

        if (root == null) return null;
        if (node1 == node2 || root == node1) return node1;
        if (root == node2) return node2;

        if (!ifPresent(root.leftChild, node1)) {
            return findCommonAncestor(root.rightChild, node1, node2);
        } else {
            if (ifPresent(root.leftChild, node2)) {
                return findCommonAncestor(root.leftChild, node1, node2);
            } else {
                return root;
            }
        }
    }

    private static boolean ifPresent(TreeNode root, TreeNode node) {
        if (root == null) return false;
        if (root == node) return true;
        return ifPresent(root.leftChild, node) || ifPresent(root.rightChild, node);
    }
}
