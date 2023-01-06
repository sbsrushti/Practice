package practice2021.ctci.linkedlist;

public class KthFromLast {

    public static void main(String[] args) {

        Node node1 = new Node(7);
        Node node2 = new Node(3);
        node1.next = node2;
        Node node3 = new Node(5);
        node2.next = node3;
        Node node4 = new Node(3);
        node3.next = node4;
        Node node5 = new Node(1);
        node4.next = node5;

        Node kthNode = getKthNode(node1, 5);
        if (kthNode == null) System.out.print("No such node");
        else System.out.print(kthNode.val);
    }

    private static Node getKthNode(Node head, int k) {

        if (head == null) return null;
        Node p = head;
        Node q = head;
        int count = 0;
        while (count != k) {
            if (q == null) return null;
            q = q.next;
            count++;
        }
        while(q != null) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
