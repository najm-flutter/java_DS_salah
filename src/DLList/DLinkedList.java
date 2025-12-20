package DLList;

import java.util.Objects;

import Generics.ArrayG.Array1DG;

public class DLinkedList {
    private DNode Head, Tail;

    public DLinkedList() {
        Head = Tail = null;
    }

    public boolean isEmpty() {
        return (Head == null && Tail == null);
    }

    public void addFirst(DNode n) {
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
        DNode tmp = Head;
        Head = Head.getNext();
        Head.setprev(null);
        tmp.setNext(null);
    }

    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        DNode tmp = Tail;
        Tail = Tail.getprev();
        Tail.setNext(null);
        tmp.setprev(null);

    }

    public void addLast(DNode m) {
        if (isEmpty()) {
            Head = Tail = m;
            return;
        }
        Tail.setNext(m);
        m.setprev(Tail);
        Tail = m;
    }

    public DNode find(Long name) {
        DNode t = Head;
        while (t != null) {
            if (t.getDataStudent().getID() == (name)) {
                break;
            }
            t = t.getNext();
        }
        return t;
    }

    public void addAfter(DNode mn, Long id) {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        DNode res = find(id);
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
        DNode tmp = Head;
        while (tmp != null) {
            System.out.print(tmp.getDataStudent().getName() + ": " + tmp.getDataStudent().getID() + " ->");
            tmp = tmp.getNext();
        }
        System.out.print("Null");
    }

    public void addBefor(DNode node, Long name) {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        DNode node2 = find(name);
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

    public void addAt(DNode n, int pos) {
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
        DNode tmp = Head;
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
        DNode tmp = Head;
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

    public void deleteAfter(Long name) {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        DNode node2 = find(name);
        if (node2 == null) {
            System.out.println("The element is not found");
            return;
        }

        if (node2.getNext() == null) {
            return;
        }
        DNode tmp = node2.getNext();
        if (tmp.getNext() == null) {
            deleteLast();
            return;
        }
        tmp.getprev().setNext(tmp.getNext());
        tmp.getNext().setprev(tmp.getprev());
        tmp.setNext(null);
        tmp.setprev(null);
    }

    public void deleteBefore(Long name) {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        DNode node2 = find(name);
        if (node2 == null) {
            System.out.println("The element is not found");
            return;
        }

        if (node2.getprev() == null) {
            return;
        }
        DNode tmp = node2.getprev();
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

    public Array1DG<Object>  DLinkedListToArray() {
        Array1DG<Object> array1dg = new Array1DG<>();
        DNode tmp = Head;
        while (tmp != null) {
            array1dg.add(tmp);
            tmp = tmp.getNext();
        }
        return array1dg ;
    }

}
