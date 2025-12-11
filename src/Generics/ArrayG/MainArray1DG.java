package Generics.ArrayG;

import java.util.Scanner;

import PublicClass.Messages;
import PublicClass.Methods;

import java.util.HashMap;

enum ARRAY_OPERATIONS {
    ADD,
    ADD_ALL,
    DELETE,
    DELETE_LAST,
    DELETE_AT,
    DELETE_ALL,
    DELETE_ALL_SKIP_FIRST,
    DELETE_ALL_SKIP_LAST,
    DELETE_JUMP,
    DISPLAY,
    DEFAULT,
}

public class MainArray1DG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        run(in);
        in.close();
    }

    public static void run(Scanner in) {
        System.out.println("Enter size of One-D Array: ");

        int size;
        if ((size = in.nextInt()) <= 0) {
            System.out.println("error size must be greate than  0 ");
            return;
        }

        Array1DG<Object> onDArr = new Array1DG<>(size);

        HashMap<Integer, ARRAY_OPERATIONS> oneDOptions = new HashMap<>();
        oneDOptions.put(1, ARRAY_OPERATIONS.ADD);
        oneDOptions.put(2, ARRAY_OPERATIONS.DELETE);
        oneDOptions.put(3, ARRAY_OPERATIONS.DELETE_LAST);
        oneDOptions.put(4, ARRAY_OPERATIONS.DELETE_AT);
        oneDOptions.put(5, ARRAY_OPERATIONS.DELETE_ALL);
        oneDOptions.put(6, ARRAY_OPERATIONS.DELETE_ALL_SKIP_FIRST);
        oneDOptions.put(7, ARRAY_OPERATIONS.DELETE_ALL_SKIP_LAST);
        oneDOptions.put(8, ARRAY_OPERATIONS.DELETE_JUMP);
        oneDOptions.put(9, ARRAY_OPERATIONS.DISPLAY);

        printArrayOperationsMenu();
        int choice;
        while ((choice = in.nextInt()) != 0) {
            switch (oneDOptions.getOrDefault(choice, ARRAY_OPERATIONS.DEFAULT)) {
                case ADD:
                    for (int i = onDArr.length; i < size; i++) {
                        System.out.print("Enter Item " + (onDArr.length + 1) + ": ");
                        onDArr.add(Methods.choiseTypeT(in));
                    }
                    break;
                case DELETE:
                    System.out.println("Enter Item To Delete:");
                    onDArr.delete(Methods.choiseTypeT(in));
                    break;
                case DELETE_LAST:
                    System.out.println("Enter Item to delete last occurrence of:");
                    onDArr.deleteLast(Methods.choiseTypeT(in));
                    break;
                case DELETE_AT:
                    System.out.println("Enter index to delete at:");
                    onDArr.deleteAt(in.nextInt());
                    break;
                case DELETE_ALL:
                    System.out.println("Enter Item To Delete:");
                    onDArr.deleteAll(Methods.choiseTypeT(in));
                    break;
                case DELETE_ALL_SKIP_FIRST:
                    System.out.println("Enter item to delete all occurrences of, skipping the first:");
                    onDArr.deleteAllSkipFirst(Methods.choiseTypeT(in));
                    break;
                case DELETE_ALL_SKIP_LAST:
                    System.out.println("Enter item to delete all occurrences of, skipping the last:");
                    onDArr.deleteAllSkipLast(Methods.choiseTypeT(in));
                    break;
                case DELETE_JUMP:
                    System.out.println("Enter item to delete with jump:");
                    onDArr.deleteJump(Methods.choiseTypeT(in));
                    break;
                case DISPLAY:
                    onDArr.print();
                    System.out.println();
                    break;

                default:
                    Messages.printInvalidOptionMessage();
                    break;
            }
            printArrayOperationsMenu();
        }
    }

    public static void printArrayOperationsMenu() {
        System.out.println("""
                1. Add Item
                2. Delete First Occurrence of Item
                3. Delete Last Occurrence of Item
                4. Delete At Index
                5. Delete All Occurrences of Item
                6. Delete All, Skip First
                7. Delete All, Skip Last
                8. Delete with Jump
                9. Display
                0. Exit
                """);
    }
}