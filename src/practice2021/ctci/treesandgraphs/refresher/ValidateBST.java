package practice2021.ctci.treesandgraphs.refresher;

public class ValidateBST {

    private static boolean validateBST(Node node) {

        if (node == null)
            return true;

        if (node.left != null) {
            if (node.val < node.left.val)
                return false;
        }

        if (node.right != null) {
            if (node.val > node.right.val)
                return false;
        }

        return validateBST(node.left) && validateBST(node.right);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.left = node2;
        node1.right = node3;

        System.out.println(validateBST(node1));
    }
}
