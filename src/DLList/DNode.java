package DLList;

import java.util.Objects;

public class DNode {
 
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
        return "[" + dataStudent.getName() + "]";
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
    }

}
