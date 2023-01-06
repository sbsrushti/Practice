package practice2021.ctci.linkedlist;

public class PalindromeList {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(1);
        node1.next = node2;
//        Node node3 = new Node(5);
//        node2.next = node3;
//        Node node4 = new Node(4);
//        node3.next = node4;
//        Node node5 = new Node(3);
//        node4.next = node5;
//        Node node6 = new Node(1);
//        node5.next = node6;
//        Node node7 = new Node(4);
//        node6.next = node7;

        node1.printLinkedList();
        System.out.print(checkIfPalindrome(node1));
    }

    private static boolean checkIfPalindrome(Node head) {
        if (head == null) return false;
        if (head.next == null) return true;

        Node slow = head;
        Node fast = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null)
                break;
            else
                fast = fast.next;
        }

        Node secondPart = slow;
        secondPart = reverse(secondPart);
        Node firstPart = head;

        while (secondPart != null) {
            if (firstPart.val != secondPart.val)
                return false;
            firstPart = firstPart.next;
            secondPart = secondPart.next;
        }
        return true;
    }

    private static Node reverse(Node p) {
        if (p == null || p.next == null) return p;

        Node rev = p;
        p = p.next;
        rev.next = null;

        while(p != null) {
            Node temp = p.next;
            p.next = rev;
            rev = p;
            p = temp;
        }
        return rev;
    }
}
