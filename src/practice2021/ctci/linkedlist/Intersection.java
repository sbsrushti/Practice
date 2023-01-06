package practice2021.ctci.linkedlist;

public class Intersection {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(3);
        node1.next = node2;
        Node node3 = new Node(5);
        node2.next = node3;
        Node node4 = new Node(7);
        node3.next = node4;
        Node node5 = new Node(9);
        node4.next = node5;
        Node node6 = new Node(2);
        node5.next = node6;
        Node node7 = new Node(4);
        node6.next = node7;

        Node nodea = new Node(1);
        Node nodeb = new Node(3);
        nodea.next = nodeb;
        Node nodec = new Node(5);
        nodeb.next = nodec;
        //nodec.next = node5;
        node1.printLinkedList();
        nodea.printLinkedList();
        Node intersectionNode = findIntersectionNode(node1, nodea);
        System.out.println(intersectionNode);
        if (intersectionNode != null)
            System.out.println(intersectionNode.val);
    }

    private static Node findIntersectionNode(Node p_head, Node q_head) {

        Node p = p_head;
        Node q = q_head;
        if (p == null || q == null) return null;

        int p_len = 0;
        while (p != null) {
            p_len++;
            p = p.next;
        }

        int q_len = 0;
        while(q != null) {
            q_len++;
            q = q.next;
        }
        p = p_head;
        System.out.print(p.val);

        q = q_head;
        System.out.print(q.val);
        int diff;
        if (p_len > q_len) {
            diff = p_len - q_len;
            while (diff != 0) {
                p = p.next;
                diff--;
            }
        } else if (q_len > p_len) {
            diff = q_len - p_len;
            while (diff != 0) {
                q = q.next;
                diff--;
            }
        }
        System.out.print(p.val);
        System.out.print(q.val);
        while (p != null && q != null) {
            if (p == q) {
                return p;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }
}
