package Generics.DLListG;

import java.util.Objects;

public class DLinkedListG<T> {

    private DNode<T> Head, Tail;

    public DLinkedListG() {
        Head = Tail = null;
    }

    public boolean isEmpty() {
        return (Head == null && Tail == null);
    }

    public void addFirst(DNode<T> n) {
        if (isEmpty()) {
            Head = Tail = n;
            return;
        }
        Head.setprev(n);
        n.setNext(Head);
        Head = n;
    }

    public void deleteFirst() {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        DNode<T> tmp = Head;
        Head = Head.getNext();
        Head.setprev(null);
        tmp.setNext(null);
    }

    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        DNode<T> tmp = Tail;
        Tail = Tail.getprev();
        Tail.setNext(null);
        tmp.setprev(null);

    }

    public void addLast(DNode<T> m) {
        if (isEmpty()) {
            Head = Tail = m;
            return;
        }
        Tail.setNext(m);
        m.setprev(Tail);
        Tail = m;
    }

    public DNode<T> find(T name) {
        DNode<T> t = Head;
        while (t != null) {
            if (t.getData().equals(name)) {
                break;
            }
            t = t.getNext();
        }
        return t;
    }

    public void addAfter(DNode<T> mn, T id) {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        DNode<T> res = find(id);
        if (res != null) {

            if (res.getNext() != null) {
                mn.setprev(res);
                mn.setNext(res.getNext());
                mn.getNext().setprev(mn);
                res.setNext(mn);

            } else {
                addLast(mn);
            }
            return;
        }
        System.out.println("The element is not found");
    }

    public void display() {
        DNode<T> tmp = Head;
        while (tmp != null) {
            System.out.print(tmp.getData() + "->");
            tmp = tmp.getNext();
        }
        System.out.print("Null");
    }

    public void addBefor(DNode<T> node, T name) {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        DNode<T> node2 = find(name);
        if (node2 == null) {
            System.out.println("The element is not found");
            return;
        }

        if (node2.getprev() != null) {
            node.setNext(node2);
            node2.getprev().setNext(node);
            node.setprev(node2.getprev());
            node2.setprev(node);
        } else {
            addFirst(node);
        }

    }

    public void addAt(DNode<T> n, int pos) {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        if (pos < 0) {
            return;

        }
        if (pos == 0) {
            addFirst(n);
            return;
        }
        DNode<T> tmp = Head;
        int counter = 0;
        while (tmp != null) {
            if (counter <= pos - 1) {
                tmp = tmp.getNext();
                counter++;
            } else
                break;
        }
        if (tmp == null) {
            addLast(n);
            return;
        }

        n.setNext(tmp);
        tmp.getprev().setNext(n);
        n.setprev(tmp.getprev());
        tmp.setprev(n);
    }

    public void deleteAt(int pos) {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        if (pos < 0) {
            return;

        }
        if (pos == 0) {
            deleteFirst();
            return;
        }
        DNode<T> tmp = Head;
        int counter = 0;
        while (tmp != null) {
            if (counter <= pos - 1) {
                tmp = tmp.getNext();
                counter++;
            } else
                break;
        }
        if (tmp == null) {
            System.out.println("The position is out of the list bounds");
            return;
        }

        tmp.getprev().setNext(tmp.getNext());
        if (tmp.getNext() != null) {
            tmp.getNext().setprev(tmp.getprev());
        }
        tmp.setNext(null);
        tmp.setprev(null);
    }

    public void deleteAfter(T name) {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        DNode<T> node2 = find(name);
        if (node2 == null) {
            System.out.println("The element is not found");
            return;
        }

        if (node2.getNext() == null) {
            return;
        }
        DNode<T> tmp = node2.getNext();
        if (tmp.getNext() == null) {
            deleteLast();
            return;
        }
        tmp.getprev().setNext(tmp.getNext());
        tmp.getNext().setprev(tmp.getprev());
        tmp.setNext(null);
        tmp.setprev(null);
    }

    public void deleteBefore(T name) {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        DNode<T> node2 = find(name);
        if (node2 == null) {
            System.out.println("The element is not found");
            return;
        }

        if (node2.getprev() == null) {
            return;
        }
        DNode<T> tmp = node2.getprev();
        if (tmp.getprev() == null) {
            deleteFirst();
            return;
        }
        tmp.getprev().setNext(tmp.getNext());
        tmp.getNext().setprev(tmp.getprev());
        tmp.setNext(null);
        tmp.setprev(null);

    }

    // delete node and two after
    public void deleteNode(int pos) {

    }

}

class DNode<T> {
    private T data;
    private DNode<T> next, prev;

    public DNode() {
        next = prev = null;
    }

    public DNode(T data) {
        this();
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setdata(T data) {
        this.data = data;
    }

    public DNode<T> getNext() {
        return next;
    }

    public void setNext(DNode<T> next) {
        this.next = next;
    }

    public DNode<T> getprev() {
        return prev;
    }

    public void setprev(DNode<T> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "DNode{" +
                "data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        DNode<T> dNode = (DNode<T>) o;
        return Objects.equals(data, dNode.data);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }// java how to convert object data into qrcode

}
