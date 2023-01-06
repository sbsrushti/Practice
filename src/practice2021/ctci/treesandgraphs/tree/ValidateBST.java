package practice2021.ctci.treesandgraphs.tree;

public class ValidateBST {

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

        System.out.print(checkIfValidBST(root));
    }

    private static boolean checkIfValidBST(TreeNode node) {
        if (node == null) return true;
        if (node.leftChild != null) {
            if (node.val < node.leftChild.val)
                return false;
        }
        if (node.rightChild != null) {
            if (node.val > node.rightChild.val)
                return false;
        }
        return checkIfValidBST(node.leftChild) && checkIfValidBST(node.rightChild);
    }
}
