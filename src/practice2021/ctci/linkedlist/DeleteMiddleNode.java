package practice2021.ctci.linkedlist;

public class DeleteMiddleNode {

    public static void main(String[] args) {

        Node node1 = new Node(7);
        Node node2 = new Node(2);
        node1.next = node2;
        Node node3 = new Node(5);
        node2.next = node3;
        Node node4 = new Node(3);
        node3.next = node4;
        Node node5 = new Node(1);
        node4.next = node5;

        deleteMiddleNode(node2);
        node1.printLinkedList();
    }

    private static void deleteMiddleNode(Node m) {

        Node prev = m;
        Node temp = m;

        while(temp.next != null) {
            temp.val = temp.next.val;
            prev = temp;
            temp = temp.next;
        }

        prev.next = null;
    }
}
