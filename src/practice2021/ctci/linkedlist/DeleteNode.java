package practice2021.ctci.linkedlist;

public class DeleteNode {

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        Node node4 = new Node(3);
        head.addNextNode(node2);
        node2.addNextNode(node3);
        node3.addNextNode(node4);

        head = deleteNode(head, 3);
        head.printLinkedList();
    }

    private static Node deleteNode(Node head, int delVal) {
        if (head == null) {
            return null;
        }
        if (head.val == delVal) {
            return head.next;
        }
        Node iterator = head.next;
        Node prev = head;
        while(iterator != null) {
            if (iterator.val == delVal) {
                prev.next = iterator.next;
                return head;
            }
            prev = iterator;
            iterator = iterator.next;
        }
        return head;
    }
}
