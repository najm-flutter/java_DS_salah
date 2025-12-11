package Generics.ArrayG;

import java.util.Scanner;
import PublicClass.Messages;
import PublicClass.Methods;

import java.util.HashMap;

enum ARRAY_OPERATIONS {
    ADD,
    DELETE,
    DELETE_ALL,
    DISPLAY,
    DEFAULT
}

public class MainArray2DG {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        run(in);
        in.close();
    }

    public static void run(Scanner in) {
        System.out.println("Enter size Rows of Tow-D Array: ");

        int row;
        if ((row = in.nextInt()) <= 0) {
            System.out.println("error size Rows must be greate than  0 ");
            return;
        }
        System.out.println("Enter size Columns of Tow-D Array: ");

        int col;
        if ((col = in.nextInt()) <= 0) {
            System.out.println("error size columns must be greate than  0 ");
            return;
        }

        Array2DG<Object> towDArr = new Array2DG<>(row, col);
        HashMap<Integer, ARRAY_OPERATIONS> twoDOptions = new HashMap<>();
        twoDOptions.put(1, ARRAY_OPERATIONS.ADD);
        twoDOptions.put(2, ARRAY_OPERATIONS.DELETE);
        twoDOptions.put(3, ARRAY_OPERATIONS.DELETE_ALL);
        twoDOptions.put(4, ARRAY_OPERATIONS.DISPLAY);

        printArrayOperationsMenu();
        int choice;
        while ((choice = in.nextInt()) != 0) {
            switch (twoDOptions.getOrDefault(choice, ARRAY_OPERATIONS.DEFAULT)) {
                case ADD:
                    for (int i = towDArr.length; i < row * col; i++) {
                        System.out.print("Enter Item Number" + (i + 1) + ": ");
                        towDArr.add(Methods.choiseTypeT(in));
                    }
                    break;
                case DELETE:
                    System.out.println("Enter Item To Delete:");
                    towDArr.deleteFirst(Methods.choiseTypeT(in));
                    break;
                case DELETE_ALL:
                    System.out.println("Enter Item To Delete:");
                    towDArr.deleteAll(Methods.choiseTypeT(in));
                    break;
                case DISPLAY:
                    towDArr.print();
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
                1. Add Items
                2. Delete Item
                3. Delete All Occurrences of Item
                4. Display
                0. Exit
                              """);
    }
}