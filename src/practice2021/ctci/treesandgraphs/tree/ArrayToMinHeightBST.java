package practice2021.ctci.treesandgraphs.tree;

public class ArrayToMinHeightBST {

    public static void main(String[] args) {

        int[] arr = {2,4,5,6,7};
        //int[] arr = {1,2,3,4};
        TreeNode treeNode = convertToBST(arr, 0, arr.length-1);
        BST bst = new BST(treeNode);
        bst.bfs();
    }

    private static TreeNode convertToBST(int[] arr, int i, int j) {
        if (j < i) return null;

        int m = i+(j-i)/2;
        TreeNode node = new TreeNode(arr[m]);
        node.leftChild = convertToBST(arr, i, m-1);
        node.rightChild = convertToBST(arr, m+1, j);
        return node;
    }
}
