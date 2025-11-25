package DLList;

import java.util.Objects;

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

    public void addLast(DNode m) {
        if (isEmpty()) {
            Head = Tail = m;
            return;
        }
        Tail.setNext(m);
        m.setprev(Tail);
        Tail = m;
    }

    public DNode find(String name) {
        DNode t = Head;
        while (t != null) {
            if (t.getDataStudent().getName().equals(name)) {
                break;
            }
            t = t.getNext();
        }
        return t;
    }

    public void addAfter(DNode mn, String id) {
        if (isEmpty()) {
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
        System.out.println("the element is not found");
    }

    public void display() {
        DNode tmp = Head;
        while (tmp != null) {
            System.out.print(tmp.getDataStudent().getName() + "->");
            tmp = tmp.getNext();
        }
        System.out.print("Null");
    }

    public void addBefor(DNode node, String name) {
        if (isEmpty()) {
            return;
        }
        DNode node2 = find(name);
        if (node2 == null) {
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

    }

    public void deleteAt(int pos) {

    }

    // delete node and two after
    public void deleteNode(int pos) {

    }

    public void deleteAfter(int id) {

    }

    public void deleteBefore(int id) {

    }

}

class DNode {
    private Student dataStudent;
    private DNode next, prev;

    public DNode() {
        next = prev = null;
    }

    public DNode(Student dataStudent) {
        this();
        this.dataStudent = dataStudent;
    }

    public Student getDataStudent() {
        return dataStudent;
    }

    public void setDataStudent(Student dataStudent) {
        this.dataStudent = dataStudent;
    }

    public DNode getNext() {
        return next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public DNode getprev() {
        return prev;
    }

    public void setprev(DNode prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "DNode{" +
                "dataStudent=" + dataStudent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        DNode dNode = (DNode) o;
        return Objects.equals(dataStudent, dNode.dataStudent);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dataStudent);
    }// java how to convert object data into qrcode

}