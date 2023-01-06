package practice.ctci.linkedlists;

public class DeleteNode {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.setNext(node2);
        Node node3 = new Node(3);
        node2.setNext(node3);
        Node node4 = new Node(4);
        node3.setNext(node4);
        Node node5 = new Node(5);
        node4.setNext(node5);
        Node head = deleteNode(node2, node1);
        head.printList();
    }

    private static Node deleteNode(Node delNode, Node head) {
        if(head == delNode) {
            return head.getNext();
        }
        Node curr = head.getNext();
        Node prev = head;
        while (curr != null) {
            if (delNode == curr) {
                prev.setNext(curr.getNext());
                break;
            }
            prev = curr;
            curr = curr.getNext();
        }
        return head;
    }
}
