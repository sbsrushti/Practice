package practice.geeksforgeeks.random;

import practice.ctci.linkedlists.Node;

public class SwapElementsLinkedList {

    public static void main(String[] args) {

        //1 2 2 4 5 6 7 8
        Node node = new Node(1);
        Node head = node;
        node.setNext(new Node(2));
        node = node.getNext();
        node.setNext(new Node(2));
        node = node.getNext();
        node.setNext(new Node(4));
        node = node.getNext();
        node.setNext(new Node(5));
        node = node.getNext();
        node.setNext(new Node(6));
        node = node.getNext();
        node.setNext(new Node(7));
        node = node.getNext();
        node.setNext(new Node(8));

        head = swapFunc(head);

        head.printList();
    }

    private static Node swapFunc(Node node) {

        Node cur = node;
        if (cur == null || cur.getNext() == null) {
            return cur;
        }

        Node temp = cur;
        cur = cur.getNext();
        Node future = cur.getNext();
        cur.setNext(temp);
        Node head = cur;
        Node prev = cur.getNext();


        while (future != null) {
            cur = future;
            if (cur.getNext() == null) {
                prev.setNext(cur);
                break;
            }

            temp = cur;
            cur = cur.getNext();
            prev.setNext(cur);
            future = cur.getNext();
            cur.setNext(temp);
            prev = cur.getNext();
        }
        prev.setNext(null);
        return head;
    }
}
