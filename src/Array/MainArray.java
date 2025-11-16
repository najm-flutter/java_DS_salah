package Array;

import java.util.Scanner;

import PublicClass.Messages;

public class MainArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        run(in);
    }

    public static void run(Scanner in) {
        int choice;
        printMenuOptions();
        while ((choice = in.nextInt()) != 0) {

            switch (choice) {
                case 1:
                    oneDArr(in);
                    break;
                case 2:
                    towDArr(in);
                    break;
                default:
                    Messages.printInvalidOptionMessage();
                    break;
            }
            printMenuOptions();
        }

    }

    public static void oneDArr(Scanner in) {
        System.out.println("Enter size of One-D Array: ");

        int size;
        if ((size = in.nextInt()) <= 0) {
            System.out.println("error size must be greate than  0 ");
            return;
        }

        Array1D onDArr = new Array1D(size);
        printOneDArrOptions();
        int choice;
        while ((choice = in.nextInt()) != 0) {
            switch (choice) {
                case 1:
                    for (int i = onDArr.length - 1; i < size; i++) {
                        System.out.print("Enter Item " + (i + 1) + ": ");
                        onDArr.add(in.nextInt());
                    }
                    break;
                case 2:
                    System.out.println("Enter Item To Delete:");
                    onDArr.delete(in.nextInt());
                    break;
                case 3:
                    System.out.println("Enter Item To Delete:");
                    onDArr.deleteAll(in.nextInt());
                    break;
                case 4:
                    onDArr.print();
                    System.out.println();

                    break;

                default:
                    Messages.printInvalidOptionMessage();
                    break;
            }
            printOneDArrOptions();
        }
    }

    public static void towDArr(Scanner in) {
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

        Array2D towDArr = new Array2D(row, col);
        printOneDArrOptions();
        int choice;
        while ((choice = in.nextInt()) != 0) {
            switch (choice) {
                case 1:
                    for (int i = towDArr.length - 1; i < row * col; i++) {
                        System.out.print("Enter Item Number" + (i + 1) + ": ");
                        towDArr.add(in.nextInt());
                    }
                    break;
                case 2:
                    System.out.println("Enter Item To Delete:");
                    towDArr.deleteFirst(in.nextInt());
                    break;
                case 3:
                    System.out.println("Enter Item To Delete:");
                    towDArr.deleteAll(in.nextInt());
                    break;
                case 4:
                    towDArr.print();
                    System.out.println();
                    break;

                default:
                    Messages.printInvalidOptionMessage();
                    break;
            }
            printOneDArrOptions();
        }
    }

    public static void towDArrRec(Scanner in) {

    }

    public static void printMenuOptions() {
        System.out.println("""
                \n1. One-D Array
                2. Two-D Array
                0. Exit
                Enter choice: """);

    }

    public static void printOneDArrOptions() {
        System.out.println("""
                1. Add Items
                2. Delete Item
                3. Delete Item With Itration
                4. Dispaly
                0. Exit
                              """);
    }
}