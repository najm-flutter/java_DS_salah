package others;

import Array.Array1D;
import DLList.DLinkedList;
import DLList.DNode;
import DLList.Student;
import Generics.ArrayG.Array1DG;
import LinkedList.LinkedListDS;

public class Test {
    public static void main(String[] args) {

        // Array1D array1d = new Array1D(10);
        // array1d.addAll(new double[] { 10, 15, 10, 30, 30, 10, 10, 18, 10, 10 });
        // array1d.deleteFHalf(10);
        // array1d.print();

        // LinkedListDS linkedListDS = new LinkedListDS();
        // linkedListDS.addLast("1950");
        // linkedListDS.addLast("2023");
        // linkedListDS.addLast("2015");
        // linkedListDS.addLast("qais");
        // linkedListDS.addLast("Bokhara");
        // linkedListDS.addLast("2003");
        // linkedListDS.addLast("saad");
        // linkedListDS.addLast("othman");
        // linkedListDS.addLast("Yemen");
        // linkedListDS.addLast("Beshr");

        // linkedListDS.deleteBtweenPos("null", 0, 8);

        // linkedListDS.display();

        DLinkedList dLinkedList = new DLinkedList();
        dLinkedList.addLast(new DNode(new Student("Imran")));
        dLinkedList.addLast(new DNode(new Student("Idrees")));
        dLinkedList.addLast(new DNode(new Student("Omar")));
        dLinkedList.addLast(new DNode(new Student("Mogahed")));
        dLinkedList.addLast(new DNode(new Student("mosa")));
        dLinkedList.addLast(new DNode(new Student("Khalid")));
        dLinkedList.addLast(new DNode(new Student("saad")));
        dLinkedList.addLast(new DNode(new Student("Othamn")));
        dLinkedList.addLast(new DNode(new Student("Yazeed")));
        dLinkedList.addLast(new DNode(new Student("Murad")));

        Array1DG<Object> aa = dLinkedList.DLinkedListToArray();
        aa.print();
    }

}
