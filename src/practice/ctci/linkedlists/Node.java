package practice.ctci.linkedlists;

public class Node {
    private int value;
    private Node next = null;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public Node getNext() {
        return this.next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void printList() {
        Node curr = this;
        while(curr.getNext() != null) {
            System.out.print(curr.getValue() + "->");
            curr = curr.getNext();
        }
        System.out.println(curr.getValue());
    }
}
