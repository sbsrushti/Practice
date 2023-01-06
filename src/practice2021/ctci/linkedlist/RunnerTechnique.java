package practice2021.ctci.linkedlist;

public class RunnerTechnique {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(3);
        node1.next = node2;
        Node node3 = new Node(5);
        node2.next = node3;
        Node node4 = new Node(7);
        node3.next = node4;
        Node node5 = new Node(9);
        node4.next = node5;
        Node node6 = new Node(2);
        node5.next = node6;
        Node node7 = new Node(4);
        node6.next = node7;
        Node node8 = new Node(6);
        node7.next = node8;
        Node node9 = new Node(8);
        node8.next = node9;
        Node node10 = new Node(10);
        node9.next = node10;

        Node head = node1;
        head.printLinkedList();
        head = mergeNodes(head);
        head.printLinkedList();
    }

    private static Node mergeNodes(Node head) {
        if (head == null) return null;
        Node slow_ptr = head;
        Node fast_ptr = head;

        while(fast_ptr != null) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next;
            if (fast_ptr != null) fast_ptr = fast_ptr.next;
        }

        Node q = slow_ptr;
        Node p = head;

        while(q != null) {
            Node temp_p = p.next;
            Node temp_q = q.next;
            p.next = q;
            if (q.next != null)
                q.next = temp_p;
            p = temp_p;
            q = temp_q;
        }
        return head;
    }
}
