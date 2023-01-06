package practice.ctci.linkedlists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public static void main(String[] args) {

        Node hmm = removeDuplicatesInUnsortedList();
        hmm.printList();

        Node unsorted = removeDuplicatesInUnsortedListUsingExtraMem();
        unsorted.printList();

        Node head = removeDuplicatesInSortedList();
        head.printList();
    }

    private static Node removeDuplicatesInUnsortedList() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.setNext(node2);
        Node node3 = new Node(3);
        node2.setNext(node3);
        Node node4 = new Node(4);
        node3.setNext(node4);
        Node node5 = new Node(1);
        node4.setNext(node5);
        Node node6 = new Node(2);
        node5.setNext(node6);
        Node node7 = new Node(3);
        node6.setNext(node7);
        Node node8 = new Node(4);
        node7.setNext(node8);
        node1.printList();

        Node curr = node1;

        while (curr != null) {
            Node temp = curr.getNext();
            Node prev = curr;
            while (temp != null) {
                if (temp.getValue() == curr.getValue()) {
                    prev.setNext(temp.getNext());
                    prev = temp.getNext();
                }
                temp = temp.getNext();
            }
            curr = curr.getNext();
        }
        return node1;
    }

    private static Node removeDuplicatesInUnsortedListUsingExtraMem() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.setNext(node2);
        Node node3 = new Node(3);
        node2.setNext(node3);
        Node node4 = new Node(4);
        node3.setNext(node4);
        Node node5 = new Node(1);
        node4.setNext(node5);
        Node node6 = new Node(2);
        node5.setNext(node6);
        Node node7 = new Node(3);
        node6.setNext(node7);
        Node node8 = new Node(4);
        node7.setNext(node8);
        node1.printList();

        Set<Integer> set = new HashSet<>();
        Node curr = node1.getNext();
        Node head = node1;
        Node prev = node1;
        set.add(prev.getValue());

        while (curr != null) {
            while (curr != null && set.contains(curr.getValue())) {
                curr = curr.getNext();
            }
            prev.setNext(curr);
            if (curr != null) {
                set.add(curr.getValue());
                prev = curr;
                curr = curr.getNext();
            }
        }
        return head;
    }

    private static Node removeDuplicatesInSortedList() {
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        node1.setNext(node2);
        Node node3 = new Node(2);
        node2.setNext(node3);
        Node node4 = new Node(2);
        node3.setNext(node4);
        Node node5 = new Node(3);
        node4.setNext(node5);
        Node node6 = new Node(3);
        node5.setNext(node6);
        Node node7 = new Node(4);
        node6.setNext(node7);
        Node node8 = new Node(4);
        node7.setNext(node8);

        Node head = node1;
        head.printList();
        Node cur = head;
        while(cur != null) {
            Node temp = cur;
            while (temp.getNext() != null && temp.getValue() == temp.getNext().getValue()) {
                temp = temp.getNext();
            }
            cur.setNext(temp.getNext());
            cur = temp.getNext();
        }
        return head;
    }
}
