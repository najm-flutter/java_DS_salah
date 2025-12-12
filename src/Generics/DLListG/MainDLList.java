package Generics.DLListG;

import java.util.HashMap;
import java.util.Scanner;

import PublicClass.Messages;
import PublicClass.Methods;

enum DLL_OPERATIONS {
    ADD_FIRST,
    ADD_LAST,
    ADD_AFTER,
    ADD_BEFORE,
    ADD_AT,
    DELETE_FIRST,
    DELETE_LAST,
    DELETE_AT,
    DELETE_AFTER,
    DELETE_BEFORE,
    DISPLAY,
    DEFAULT
}

public class MainDLList {
    public static void main(String[] args) {
        run(new Scanner(System.in));
    }

    public static void run(Scanner in) {
        HashMap<Integer, DLL_OPERATIONS> options = new HashMap<>();
        options.put(1, DLL_OPERATIONS.ADD_FIRST);
        options.put(2, DLL_OPERATIONS.ADD_LAST);
        options.put(3, DLL_OPERATIONS.ADD_AFTER);
        options.put(4, DLL_OPERATIONS.ADD_BEFORE);
        options.put(5, DLL_OPERATIONS.ADD_AT);
        options.put(6, DLL_OPERATIONS.DELETE_FIRST);
        options.put(7, DLL_OPERATIONS.DELETE_LAST);
        options.put(8, DLL_OPERATIONS.DELETE_AT);
        options.put(9, DLL_OPERATIONS.DELETE_AFTER);
        options.put(10, DLL_OPERATIONS.DELETE_BEFORE);
        options.put(11, DLL_OPERATIONS.DISPLAY);

        DLinkedListG<Object> dLinkedList = new DLinkedListG<>();
        int choice;
        printMenuOptions();
        while ((choice = in.nextInt()) != 0) {
            Methods.choiseTypeT(in);

            DNode<Object> node;
            Object targetName;
            int pos;

            switch (options.getOrDefault(choice, DLL_OPERATIONS.DEFAULT)) {
                case ADD_FIRST:
                    System.out.print("Enter Node Value to add: ");
                    dLinkedList.addFirst(new DNode<Object>(Methods.choiseTypeT(in)));
                    break;
                case ADD_LAST:
                    System.out.print("Enter Node Value to add at last: ");
                    dLinkedList.addLast(new DNode<Object>(Methods.choiseTypeT(in)));
                    break;
                case ADD_AFTER:
                    System.out.print("Enter Node Value to add: ");
                    node = new DNode<Object>(Methods.choiseTypeT(in));
                    System.out.print("Enter the name of the student to add after: ");
                    targetName = Methods.choiseTypeT(in);
                    dLinkedList.addAfter(node, targetName);
                    break;
                case ADD_BEFORE:
                    System.out.print("Enter Node Value to add: ");
                    node = new DNode<Object>(Methods.choiseTypeT(in));
                    System.out.print("Enter the name of the student to add before: ");
                    targetName = Methods.choiseTypeT(in);
                    dLinkedList.addBefor(node, targetName);
                    break;
                case ADD_AT:
                    System.out.print("Enter Node Value to add: ");
                    node = new DNode<Object>(Methods.choiseTypeT(in));
                    System.out.print("Enter position: ");
                    pos = in.nextInt();
                    dLinkedList.addAt(node, pos);
                    break;
                case DELETE_FIRST:
                    dLinkedList.deleteFirst();
                    break;
                case DELETE_LAST:
                    dLinkedList.deleteLast();
                    break;
                case DELETE_AT:
                    System.out.print("Enter position to delete: ");
                    pos = in.nextInt();
                    dLinkedList.deleteAt(pos);
                    break;
                case DELETE_AFTER:
                    System.out.print("Enter the Node to delete the node after it: ");
                    targetName = Methods.choiseTypeT(in);
                    dLinkedList.deleteAfter(targetName);
                    break;
                case DELETE_BEFORE:
                    System.out.print("Enter the Node to delete the node before it: ");
                    targetName = Methods.choiseTypeT(in);
                    dLinkedList.deleteBefore(targetName);
                    break;
                case DISPLAY:
                    dLinkedList.display();
                    System.out.println();
                    break;
                default:
                   Messages.printInvalidOptionMessage() ;
                    break;
            }
            printMenuOptions();
        }
    }

    public static void printMenuOptions() {
        System.out.println("""
                \nChoose an operation:
                     1. Add First          6. Delete First
                     2. Add Last           7. Delete Last
                     3. Add After          8. Delete At
                     4. Add Before         9. Delete After
                     5. Add At             10. Delete Before
                     11. Display
                     0. Exit
                    """);
    }
}
