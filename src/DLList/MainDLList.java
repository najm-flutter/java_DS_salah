package DLList;

public class MainDLList {
    public static void main(String[] args) {
        DLinkedList dLinkedList = new DLinkedList();
        dLinkedList.addLast(new DNode(new Student("Ali")));
        dLinkedList.addLast(new DNode(new Student("Ahmed")));
        dLinkedList.addLast(new DNode(new Student("Souod")));
        dLinkedList.addLast(new DNode(new Student("GADATY")));
        dLinkedList.addAfter(new DNode(new Student("d")),"GADATY" );
        dLinkedList.display();
    }
}
