package practice.ctci.linkedlists;

public class InterweaveEvenNumberedLists {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.setNext(node2);
        Node node3 = new Node(3);
        node2.setNext(node3);
        Node node4 = new Node(4);
        node3.setNext(node4);
        Node nodea = new Node('a');
        node4.setNext(nodea);
        Node nodeb = new Node('b');
        nodea.setNext(nodeb);
        Node nodec = new Node('c');
        nodeb.setNext(nodec);
        Node noded = new Node('d');
        nodec.setNext(noded);
        node1.printList();
        Node head = interweave(node1);
        head.printList();
    }

    private static Node interweave(Node head) {
        Node p = head;
        Node q = head;

        while(q != null) {
            p = p.getNext();
            q = q.getNext().getNext();
        }
        q = head;
        Node fin = q;
        Node cur = null;
        while (p != null) {
            Node q_temp = q.getNext();
            Node p_temp = p.getNext();
            if (cur != null)
                cur.setNext(q);
            q.setNext(p);
            cur = p;
            q = q_temp;
            p = p_temp;
        }
        return fin;
    }
}
