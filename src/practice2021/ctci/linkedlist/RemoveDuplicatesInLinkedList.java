package practice2021.ctci.linkedlist;

import java.util.*;

public class RemoveDuplicatesInLinkedList {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(3);
        node1.next = node2;
        Node node3 = new Node(5);
        node2.next = node3;
        Node node4 = new Node(3);
        node3.next = node4;
        Node node5 = new Node(1);
        node4.next = node5;

        Node head1 = removeDupsUsingMap(node1);
        head1.printLinkedList();
//        Node head2 = removeDupsUsingSort(node1);
//        head2.printLinkedList();
    }

    private static Node removeDupsUsingMap(Node head) {

        if (head == null) return null;

        //Map<Integer, Boolean> checkIfNodePresent = new HashMap<Integer, Boolean>();
        Set<Integer> checkIfNodePresent = new HashSet<>();

        Node temp = head;
        checkIfNodePresent.add(temp.val);
        //checkIfNodePresent.put(temp.val, true);
        Node prev = temp;
        temp = temp.next;

        while(temp != null) {
            if (checkIfNodePresent.contains(temp.val)) {
                prev.next = temp.next;
            } else {
                checkIfNodePresent.add(temp.val);
                prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }

    private static Node removeDupsUsingSort(Node head) {
        if (head == null) return null;

        Node p = head;
        while (p.next != null) {
            Node prev = p;
            Node q = p.next;
            while(q != null) {
                if (p.val == q.val) {
                    prev.next = q.next;
                }
                prev = q;
                q = q.next;
            }
            p = p.next;
        }

        return head;

    }
}

