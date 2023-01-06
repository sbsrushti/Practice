package practice2021.ctci.treesandgraphs.refresher;

public class Successor {

    static class Node {
        int val;
        Node left;
        Node right;
        Node parent;

        Node(int val) {
            this.val = val;
        }
    }

    private int successor(Node node) {

        if (node.right == null)
            return -1;

        Node curr = node.right;

        while (curr.left != null) {
            curr = curr.left;
        }

        return curr.val;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.left = node2;
        node1.right = node3;
        node2.parent = node1;
        node3.parent = node1;

        System.out.println();
    }
}
