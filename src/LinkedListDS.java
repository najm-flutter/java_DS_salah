public class LinkedListDS {
    Node head;
    int length;

    LinkedListDS() {
        head = null;
        length = 0;
    }

    public void addFirst(int data) {
        Node new_node = new Node(data);
        length++;
        if (head == null) {
            head = new_node;
            return;
        }
        new_node.next = head;
        head = new_node;

    }

    public void addLast(int data) {
        length++;
        Node new_Node = new Node(data);
        if (head == null) {
            head = new_Node;
            return;
        }

        Node tmp = head;

        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new_Node;

    }

    public void deleteFirst() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    public void deleteLast() {
        if (head == null) {
            return;
        }
        if (length == 1) {
            head = null;
            return;
        }
        Node tmp = head;

        while (tmp.next.next != null) {
            tmp = tmp.next;
        }
        tmp.next = null;
    }

    public void display() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + "->");
            tmp = tmp.next;
        }
        System.out.print("null");
    }
}
