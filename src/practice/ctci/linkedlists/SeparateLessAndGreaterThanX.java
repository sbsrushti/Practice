package practice.ctci.linkedlists;

public class SeparateLessAndGreaterThanX {

    public static void main(String[] args) {

        Node head = new Node(5);
        Node node2 = new Node(6);
        head.setNext(node2);
        Node node3 = new Node(7);
        node2.setNext(node3);
        Node node4 = new Node(8);
        node3.setNext(node4);
        Node node5 = new Node(1);
        node4.setNext(node5);
        Node node6 = new Node(2);
        node5.setNext(node6);
        Node node7 = new Node(3);
        node6.setNext(node7);
        Node node8 = new Node(4);
        node7.setNext(node8);
        head.printList();

        int x = 1;
        Node cur = head;
        Node left = null;
        Node right = null;
        Node left_head = null;
        Node right_head = null;

        while ( cur != null) {
            if (cur.getValue() < x) {
                if (left == null) {
                    left_head = cur;
                    left = cur;
                }
                else {
                    left.setNext(cur);
                    left = left.getNext();
                }
            } else {
                if (right == null) {
                    right_head = cur;
                    right = cur;
                } else {
                    right.setNext(cur);
                    right = right.getNext();
                }
            }
            cur = cur.getNext();
        }
        if (left != null) left.setNext(right_head);
        else left_head = right_head;
        left_head.printList();
    }
}
