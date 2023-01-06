package practice2021.ctci.linkedlist;

public class Partition {

    public static void main(String[] args) {

        Node node1 = new Node(3);
        Node node2 = new Node(5);
        node1.next = node2;
        Node node3 = new Node(8);
        node2.next = node3;
        Node node4 = new Node(5);
        node3.next = node4;
        Node node5 = new Node(10);
        node4.next = node5;
        Node node6 = new Node(2);
        node5.next = node6;
        Node node7 = new Node(2);
        node6.next = node7;

        node1.printLinkedList();
        Node new_head = partition(node1, 2);
        new_head.printLinkedList();
    }

    private static Node partition(Node head, int k) {

        Node temp = head;
        Node p = null;
        Node p_it = null;
        Node q = null;
        Node q_it = null;

        while(temp != null) {
            if (temp.val < k) {
                if (p == null) {
                    p = temp;
                    p_it = p;
                } else {
                    p_it.next = temp;
                    p_it = p_it.next;
                }
            } else {
                if (q == null) {
                    q = temp;
                    q_it = q;
                } else {
                    q_it.next = temp;
                    q_it = q_it.next;
                }
            }
            temp = temp.next;
        }

        if (p == null) return q;
        p_it.next = q;
        if (q_it != null) q_it.next = null;
        return p;
    }
}
