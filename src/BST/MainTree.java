package BST;

import java.util.HashMap;
import java.util.Scanner;

import PublicClass.Messages;

enum TREE_OPERATIONS {
    INSERT,
    DELETE,
    DISPLAY,
    DEFAULT
}

public class MainTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        run(in);
        in.close();
    }

    public static void run(Scanner in) {
        HashMap<Integer, TREE_OPERATIONS> options = new HashMap<>();
        options.put(1, TREE_OPERATIONS.INSERT);
        options.put(2, TREE_OPERATIONS.DELETE);
        options.put(3, TREE_OPERATIONS.DISPLAY);

        BSTtree bstTree = new BSTtree();
        printTreeMenu();
        int choice;
        while ((choice = in.nextInt()) != 0) {

            switch (options.getOrDefault(choice, TREE_OPERATIONS.DEFAULT)) {
                case INSERT:
                    System.out.print("Enter item to insert: ");
                    bstTree.insert(in.nextInt());
                    break;
                case DELETE:
                    System.out.print("Enter item to delete: ");
                    bstTree.deleteNode(in.nextInt());
                    break;
                case DISPLAY:
                    bstTree.display();
                    break;
                default:
                    Messages.printInvalidOptionMessage();
                    break;
            }
            printTreeMenu();
        }
    }

    private static void printTreeMenu() {
        System.out.println("\nChoice Operation\n 1. INSERT\n 2. DELETE\n 3. DISPLAY\n 0. Exit\n");
    }
}
