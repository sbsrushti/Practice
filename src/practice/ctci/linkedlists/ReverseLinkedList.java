package practice.ctci.linkedlists;

public class ReverseLinkedList {

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

        if(head.getNext() == null) {
            head.printList();
            return;
        }

        Node p = head;
        Node q = head.getNext();
        p.setNext(null);

        while (q != null) {
            Node next = q.getNext();
            q.setNext(p);
            p = q;
            q = next;
        }
        p.printList();
    }
}
