package practice.ctci.linkedlists;

public class RemoveKthNodeFromLast {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        head.setNext(node2);
        Node node3 = new Node(3);
        node2.setNext(node3);
        Node node4 = new Node(4);
        node3.setNext(node4);
        Node node5 = new Node(5);
        node4.setNext(node5);
        Node node6 = new Node(6);
        node5.setNext(node6);
        Node node7 = new Node(7);
        node6.setNext(node7);
        Node node8 = new Node(8);
        node7.setNext(node8);
        head.printList();

        int k = 9;
        Node final_head = removeKthNode(head, k);
        final_head.printList();
    }

    private static Node removeKthNode(Node head, int k) {

        Node cur = head;
        while ( k != 0 && cur != null) {
            cur = cur.getNext();
            k--;
        }

        if (k == 0 && cur == null) {
            return head.getNext();
        }

        if (cur == null) {
            return head;
        }

        Node prev = null;
        Node temp = head;
        while (cur != null) {
            prev = temp;
            temp = temp.getNext();
            cur = cur.getNext();
        }

        prev.setNext(temp.getNext());
        return head;
    }
}
