package SALAM;

public class LinkedList {
    Node head;
    Node tail;
    int length;

    LinkedList() {
        head = tail = null;
    }

    public void addFirst(int data) {
        Node tmp = new Node(data);

        if (head == null) {
            head = tail = tmp;
            length++;
            return;
        }

        tmp.next = head;
        head = tmp;
        length++;
    }

    public void addLast(int data) {
        Node tmp = new Node(data);

        if (head == null) {
            head = tail = tmp;
            return;
        }

        tail.next = tmp;
        tail = tmp;
        length++;
    }

    public void deleteFirst() {

        if (head == null) {
            return;
        }

        head = head.next;

        length--;
    }

    public void deleteLast() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = tail = null;
            length--;
            return;
        }

        Node tmp = head.next;
        Node prev = head;

        while (tmp.next != null) {
            tmp = tmp.next;
            prev = prev.next;
        }

        prev.next = null;
        tail = prev;
        prev = null;
        tmp = null;
        length--;
    }

    public void deleteLast2() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = tail = null;
            length--;

            return;
        }

        Node last = head;
        while (last.next.next != null) {
            last = last.next;
        }

        last.next = null;

        length--;

    }

    public void deleteAt(int index) {
        if (length == 0 || index < 0 || index > length - 1) {
            return;
        }

        if (index == 0) {
            head = head.next;
            return;
        }

        Node tmp = head;
        int count = 0;
        while (count < index - 1) {
            tmp = tmp.next;
            count++;
        }
        tmp.next = tmp.next.next;

    }

    public void display() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + "-->");
            tmp = tmp.next;
        }
    }

}

class Node {

    int data;
    Node next;

    Node(
            int data

    ) {
        this.data = data;
        next = null;
    }

}

class NodeJ {
    int data;
    NodeJ next;
    NodeJ prev;

    NodeJ(int data) {
        this.data = data;
        next = prev = null;
    }

}

class DubleLinked {
    NodeJ head;
    NodeJ tail;

    DubleLinked() {
        head = tail = null;
    }

    public void addFirst(int data) {
        NodeJ tmp = new NodeJ(data);
        if (head == null) {
            head = tail = tmp;
        }
        tmp.next = head;
        head.prev = tmp;
        head = tmp;

    }

    public void addLast(int data) {
        NodeJ tmp = new NodeJ(data);
        if (head == null) {
            head = tail = tmp;
        }
        tail.next = tmp;
        tmp.prev = tail;
        tail = tmp;

    }
}