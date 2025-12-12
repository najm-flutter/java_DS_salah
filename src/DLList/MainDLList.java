package DLList;

import java.util.HashMap;
import java.util.Scanner;

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

        DLinkedList dLinkedList = new DLinkedList();
        int choice;
        printMenuOptions();
        while ((choice = in.nextInt()) != 0) {
            in.nextLine();

            String name;
            Long id;
            int pos;

            switch (options.getOrDefault(choice, DLL_OPERATIONS.DEFAULT)) {
                case ADD_FIRST:
                    System.out.print("Enter student name to add at first: ");
                    name = in.nextLine();
                    dLinkedList.addFirst(new DNode(new Student(name)));
                    break;
                case ADD_LAST:
                    System.out.print("Enter student name to add at last: ");
                    name = in.nextLine();
                    dLinkedList.addLast(new DNode(new Student(name)));
                    break;
                case ADD_AFTER:
                    System.out.print("Enter student name to add: ");
                    name = in.nextLine();
                    System.out.print("Enter the id of the student to add after: ");
                    id = in.nextLong();
                    dLinkedList.addAfter(new DNode(new Student(name)), id);
                    break;
                case ADD_BEFORE:
                    System.out.print("Enter student name to add: ");
                    name = in.nextLine();
                    System.out.print("Enter the id of the student to add before: ");
                    id = in.nextLong();
                    dLinkedList.addBefor(new DNode(new Student(name)), id);
                    break;
                case ADD_AT:
                    System.out.print("Enter student name to add: ");
                    name = in.nextLine();
                    System.out.print("Enter position: ");
                    pos = in.nextInt();
                    dLinkedList.addAt(new DNode(new Student(name)), pos);
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
                    System.out.print("Enter the id of the student to delete the node after it: ");
                    id = in.nextLong();
                    dLinkedList.deleteAfter(id);
                    break;
                case DELETE_BEFORE:
                    System.out.print("Enter the id of the student to delete the node before it: ");
                    id = in.nextLong();
                    dLinkedList.deleteBefore(id);
                    break;
                case DISPLAY:
                    dLinkedList.display();
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
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
