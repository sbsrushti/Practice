package practice2021.ctci.linkedlist;

public class SumNumbersInOrder {

    public static void main(String[] args) {

        Node node1 = new Node(7);
        Node node2 = new Node(1);
        node1.next = node2;
        Node node3 = new Node(6);
        node2.next = node3;
        node1.printLinkedList();
        Node nodea = new Node(5);
//        Node nodeb = new Node(9);
//        nodea.next = nodeb;
//        Node nodec = new Node(2);
//        nodeb.next = nodec;
        nodea.printLinkedList();
        Node sum = add(node1, nodea);
        sum.printLinkedList();
    }

    private static Node add(Node p, Node q) {
        int rem = 0;
        Node sum = null;
        Node sum_head = null;
        if (p == null) return q;
        if (q == null) return p;

        while (p != null || q != null) {
            int val = (p != null ? p.val : 0) + (q != null? q.val : 0) + rem;
            int new_val = val % 10;
            rem = val / 10;

            if (sum == null) {
                sum = new Node(new_val);
                sum_head = sum;
            } else {
                sum.next = new Node(new_val);
                sum = sum.next;
            }
            p = p != null ? p.next : null;
            q = q != null ? q.next : null;
        }

        if (rem != 0) {
            sum.next = new Node(rem);
        }
        return sum_head;
    }
}
