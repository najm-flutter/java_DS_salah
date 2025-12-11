package Generics.LList;

import PublicClass.NodeG;

public class LinkedListG<T> {

    public NodeG<T> head;
    int length;

    public LinkedListG() {
        head = null;
        length = 0;
    }

    public void addFirst(T data) {
        NodeG<T> new_node = new NodeG<>(data);
        length++;
        new_node.next = head;
        head = new_node;

    }

    public void addLast(T data) {
        length++;
        NodeG<T> new_node = new NodeG<>(data);
        if (head == null) {
            head = new_node;
            return;
        }

        NodeG<T> tmp = head;

        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new_node;

    }

    public T deleteFirst() {
        if (head == null) {
            return null;
        }
        T tmp = head.data;
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
        NodeG<T> tmp = head;

        while (tmp.next.next != null) {
            tmp = tmp.next;
        }
        tmp.next = null;
    }

    public void display() {
        NodeG<T> tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + "->");
            tmp = tmp.next;
        }
        System.out.print("null");
    }

    public int getsize(NodeG<T> v) {
        if (v == null) {
            return 0;
        }
        return 1 + getsize(v.next);
    }

    public void deleteAfter(T data) {

        NodeG<T> item = find(data);
        if (item == null) {
            System.out.println("item Not Found");
            return;
        }
        if (item.next == null) {
            System.out.println("the after is Empty");
        }
        NodeG<T> tmp = item.next;
        item.next = item.next.next;
        tmp.next = null;

    }

    public NodeG<T> find(T data) {
        NodeG<T> i ;
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

        NodeG<T> tmp = head;
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
        NodeG<T> tmp2 = tmp.next;
        tmp.next = tmp.next.next == null ? null : tmp.next.next;
        tmp2.next = null;

    }
}
