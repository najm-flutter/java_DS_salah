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
        return 1 + getsize(v.next);
    }

    public void deleteAfter(double data) {

        Node item = find(data);
        if (item == null) {
            System.out.println("item Not Found");
            return;
        }
        if (item.next == null) {
            System.out.println("the after is Empty");
        }
        Node tmp = item.next;
        item.next = item.next.next;
        tmp.next = null;

    }

    public Node find(double data) {
        Node i = head;
        for (i = head; i != null; i = i.next) {
            if (i.data == data) {
                return i;
            }
        }
        return i;
    }

    public void deleteAt(int index) {
        if (head == null) {
            System.out.println("is Empty");
            return;
        }
        if (index < 0 || index > length - 1) {

            System.out.println("error in index");
            return;
        }

        if (index == 0) {
            head = head.next;
            return;

        }

        Node tmp = head;
        int startIndex = 0;
        while (tmp != null) {
            if (startIndex < index - 1) {
                tmp = tmp.next;
                startIndex++;
            } else {
                break;
            }

        }
        if (tmp == null) {
            System.out.println("item Not found");
            return;
        }
        Node tmp2 = tmp.next;
        tmp.next = tmp.next.next == null ? null : tmp.next.next;
        tmp2.next = null;

    }
}
