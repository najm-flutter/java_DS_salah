package LinkedList;

import PublicClass.Node;

public class LinkedListDS {
    public Node head;
    int length;

    public LinkedListDS() {
        head = null;
        length = 0;
    }

    public void addFirst(int data) {
        Node new_node = new Node(data);
        length++;
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

    public int deleteFirst() {
        if (head == null) {
            return -1;
        }
        int tmp = head.data;
        head = head.next;
        return tmp;
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

    public int getsize(Node v) {
        if (v == null) {
            return 0;
        }
        return getsize(v.next) + 1;
    }

    public Node find(double item) {

        Node tmp = head;
        if (tmp == null) {
            return tmp;
        }
        do {
            if (tmp.data == item) {
                return tmp;
            }
            tmp = tmp.next;
        } while (tmp != null);
        return tmp;
    }
}
