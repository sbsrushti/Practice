package practice.ctci.linkedlists;

public class AddTwoLists {

    public static void main(String[] args) {

        Node num1 = new Node(7);
        Node node2 = new Node(1);
        num1.setNext(node2);
        Node node3 = new Node(6);
        node2.setNext(node3);

        Node num2 = new Node(5);
        Node node4 = new Node(9);
        num2.setNext(node4);
        Node node5 = new Node(2);
        node4.setNext(node5);

        num1.printList();
        num2.printList();

        if (num1 == null) {
            num2.printList();
            return;
        } else if (num2 == null){
            num1.printList();
            return;
        }

        int rem = 0;
        Node res = null;
        Node cur = null;
        int sum = 0;

        while(num1 != null && num2 != null) {
            sum = rem + num1.getValue() + num2.getValue();
            Node newNode = new Node(sum%10);
            rem = sum / 10;
            if (cur == null) {
                cur = newNode;
                res = cur;
            } else {
                cur.setNext(newNode);
                cur = cur.getNext();
            }
            num1 = num1.getNext();
            num2 = num2.getNext();
        }

        while(num1 != null) {
            sum = rem + num1.getValue();
            Node newNode = new Node(sum%10);
            rem = sum / 10;
            cur.setNext(newNode);
            cur = cur.getNext();
            num1 = num1.getNext();
        }

        while(num2 != null) {
            sum = rem + num2.getValue();
            Node newNode = new Node(sum%10);
            rem = sum / 10;
            cur.setNext(newNode);
            cur = cur.getNext();
            num2 = num2.getNext();
        }
        res.printList();
    }
}
