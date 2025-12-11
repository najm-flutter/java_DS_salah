package Generics.LList;

import java.util.HashMap;
import java.util.Scanner;

import PublicClass.Messages;
import PublicClass.Methods;

enum OPERATIONS {
    ADD_FIRST,
    ADD_LAST,
    DELETE_FIRST,
    DELETE_LAST,
    DELETE_AT,
    DELETE_AFTER,
    DISPLAY,
    DEFUALT,

}

public class MainLinkedListG {

    public static void main(String[] args) {
        run(new Scanner(System.in));
    }

    public static void run(Scanner in) {
        HashMap<Integer, OPERATIONS> options = new HashMap<>();
        options.put(1, OPERATIONS.ADD_FIRST);
        options.put(2, OPERATIONS.ADD_LAST);
        options.put(3, OPERATIONS.DELETE_FIRST);
        options.put(4, OPERATIONS.DELETE_LAST);
        options.put(5, OPERATIONS.DELETE_AFTER);
        options.put(6, OPERATIONS.DELETE_AT);
        options.put(7, OPERATIONS.DISPLAY);

        LinkedListG<Object> leLinkedListDS = new LinkedListG<>();
        int choice;
        printMenuOptions();
        while ((choice = in.nextInt()) != 0) {
            switch (options.getOrDefault(choice, OPERATIONS.DEFUALT)) {
                case ADD_FIRST:
                    System.out.print("Enter element to add at first: ");
                    leLinkedListDS.addFirst(Methods.choiseTypeT(in));
                    break;
                case ADD_LAST:
                    System.out.print("Enter element to add at last: ");
                    leLinkedListDS.addLast(Methods.choiseTypeT(in));
                    break;
                case DELETE_FIRST:
                    System.out.println("Deleted: " + leLinkedListDS.deleteFirst());
                    break;
                case DELETE_LAST:
                    leLinkedListDS.deleteLast();
                    System.out.println("Last element deleted.");
                    break;
                case DELETE_AFTER:
                    System.out.print("Enter the element value to delete the node after it: ");
                    leLinkedListDS.deleteAfter(Methods.choiseTypeT(in));
                    break;
                case DELETE_AT:
                    System.out.print("Enter index to delete: ");
                    leLinkedListDS.deleteAt(in.nextInt());
                    break;
                case DISPLAY:
                    leLinkedListDS.display();
                    System.out.println();
                    break;
                default:
                    Messages.printInvalidOptionMessage();
                    break;
            }
            printMenuOptions();

        }

    }

    public static void printMenuOptions() {
        System.out.println("""
                \nChoose an operation:
                     1. Add First
                     2. Add Last
                     3. Delete First
                     4. Delete Last
                     5. Delete After
                     6. Delete At
                     7. Display
                     0. Exit
                    """);
    }
}
