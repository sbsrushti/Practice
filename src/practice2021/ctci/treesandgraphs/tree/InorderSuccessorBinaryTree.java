package practice2021.ctci.treesandgraphs.tree;

public class InorderSuccessorBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.leftChild = node2;
        TreeNode node3 = new TreeNode(3);
        root.rightChild = node3;
        TreeNode node4 = new TreeNode(4);
        node2.leftChild = node4;
        TreeNode node5 = new TreeNode(5);
        node2.rightChild = node5;
        TreeNode node6 = new TreeNode(6);
        node3.leftChild = node6;
        TreeNode node7 = new TreeNode(7);
        node3.rightChild = node7;

        TreeNode treeNode = inorderSuccessor(root, node5, null, null);
        if (treeNode != null)
            System.out.print(treeNode.val);
        else
            System.out.print("null");
    }

    private static TreeNode inorderSuccessor(TreeNode root, TreeNode node, TreeNode p, TreeNode p_p) {

        if (root == null) return null;
        if (node == root) {
            if (node.leftChild != null) return node.leftChild;
            if (node.rightChild != null) return node.rightChild;

            if (p != null) {
                if (node == p.leftChild) return p.rightChild;
                if (node == p.rightChild) {
                    if (p_p == null) return null;
                    if (p == p_p.leftChild) return p_p.rightChild;
                    else return null;
                }
            }
        }

        TreeNode temp = inorderSuccessor(root.leftChild, node, root, p);
        if (temp == null)
            temp = inorderSuccessor(root.rightChild, node, root, p);
        return temp;
    }
}
