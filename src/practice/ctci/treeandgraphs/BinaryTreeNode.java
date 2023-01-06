package practice.ctci.treeandgraphs;

public class BinaryTreeNode {

    private int val = 0;
    public BinaryTreeNode left = null;
    public BinaryTreeNode right = null;

    public BinaryTreeNode(int value) {
        this.val = value;
    }

    public int getVal() {
        return this.val;
    }
}
