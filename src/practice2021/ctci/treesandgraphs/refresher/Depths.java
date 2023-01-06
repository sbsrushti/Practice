package practice2021.ctci.treesandgraphs.refresher;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Depths {

    public static List<List<Integer>> getDepths(Node root) {

        List<List<Integer>> depths = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> level = new ArrayList<>();
            while (size != 0) {
                Node node = queue.remove();

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);

                level.add(node.val);
                size--;
            }
            depths.add(level);
        }

        return depths;
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.left = node2;
        node1.right = node3;
        node2.right = new Node(6);
        Node node4 = new Node(4);
        node2.left = node4;
        Node node5 = new Node(5);
        node3.right = node5;

        List<List<Integer>> depths = getDepths(node1);

        for (List<Integer> list : depths) {
            System.out.println(list);
        }
    }
}
