package Generics.QueueDSG;

import PublicClass.Messages;
import PublicClass.Methods;

import java.util.HashMap;
import java.util.Scanner;

enum QUEUE_OPERATIONS {
    ENQUEUE,
    DEQUEUE,
    DISPLAY,
    DELETE_ITEM,
    DEFAULT
}

public class MainQueueG {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        run(in);
    }

    public static void run(Scanner in) {
        HashMap<Integer, QUEUE_OPERATIONS> options = new HashMap<>();
        options.put(1, QUEUE_OPERATIONS.ENQUEUE);
        options.put(2, QUEUE_OPERATIONS.DEQUEUE);
        options.put(3, QUEUE_OPERATIONS.DISPLAY);
        options.put(4, QUEUE_OPERATIONS.DELETE_ITEM);

        System.out.println("Enter Size Of Queue :");
        int size;
        if ((size = in.nextInt()) <= 0) {
            Messages.printSizeOut();
            return;
        }

        QueueG<Object> queueOne = new QueueG<>(size);
        printQueueMenu();
        int choice;
        while ((choice = in.nextInt()) != 0) {

            switch (options.getOrDefault(choice, QUEUE_OPERATIONS.DEFAULT)) {
                case ENQUEUE:
                    System.out.print("Enter item: ");
                    queueOne.enQueue(Methods.choiseTypeT(in));
                    break;
                case DEQUEUE:
                    System.out.print(queueOne.deQueue());
                    break;
                case DISPLAY:
                    queueOne.display();
                    break;
                case DELETE_ITEM:
                    System.out.print("Enter item To delete: ");
                    queueOne.deleteItem(Methods.choiseTypeT(in));
                    break;
                default:
                    Messages.printInvalidOptionMessage();
                    break;
            }
            printQueueMenu();

        }

    }

    private static void printQueueMenu() {
        System.out.println("\nChoice Operation\n 1. ENQUEUE\n 2. DEQUEUE\n 3. DISPLAY\n 4. DELETE_ITEM\n 0. EXit\n");
    }
}
