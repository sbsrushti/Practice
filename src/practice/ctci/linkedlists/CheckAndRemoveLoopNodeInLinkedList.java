package practice.ctci.linkedlists;

public class CheckAndRemoveLoopNodeInLinkedList {

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
        node7.setNext(node2);

        if (head.getNext() == null) {
            head.printList();
            return;
        }
        Node slow = head;
        Node fast = head;

        while (slow != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                break;
            }
        }

        if (slow != fast) {
            System.out.println("There is no loop.");
            head.printList();
            return;
        }
        int count = 1;
        fast = fast.getNext();
        while (slow != fast) {
            fast = fast.getNext();
            count++;
        }

        Node p = head;
        Node q = head;
        Node prev = null;
        while (count > 0) {
            prev = q;
            q = q.getNext();
            count--;
        }

        while (p != q) {
            p = p.getNext();
            prev = prev.getNext();
            q = q.getNext();
        }

        if (prev == null) {
            head.setNext(null);
        } else {
            prev.setNext(null);
        }
        head.printList();
    }
}
