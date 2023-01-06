package practice2021.ctci.linkedlist;

public class Node {
    int val;
    Node next = null;

    Node(int val) {
        this.val = val;
    }

    void addNextNode(Node next) {
        this.next = next;
    }

    void printLinkedList() {
        Node temp = this;
        while(temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("\n");
    }
}
