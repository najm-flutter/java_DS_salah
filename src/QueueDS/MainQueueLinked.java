package QueueDS;

import PublicClass.Messages;

import java.util.HashMap;
import java.util.Scanner;

enum QUEUE_OPERATIONS {
    ENQUEUE,
    DEQUEUE,
    DISPLAY,
    DELETE_ITEM,
    DEFAULT
}

public class MainQueueLinked {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        run(in);
    }

    public static void run(Scanner in) {
        HashMap<Integer, QUEUE_OPERATIONS> options = new HashMap<>();
        options.put(1, QUEUE_OPERATIONS.ENQUEUE);
        options.put(2, QUEUE_OPERATIONS.DEQUEUE);
        options.put(3, QUEUE_OPERATIONS.DISPLAY);

        QueueLinked cQueueOne = new QueueLinked();
        printQueueLinkedMenu();
        int choice;
        while ((choice = in.nextInt()) != 0) {

            switch (options.getOrDefault(choice, QUEUE_OPERATIONS.DEFAULT)) {
                case ENQUEUE:
                    System.out.print("Enter item: ");
                    cQueueOne.enQueue(in.nextInt());
                    break;
                case DEQUEUE:
                    System.out.print(cQueueOne.deQueue());
                    break;
                case DISPLAY:
                    cQueueOne.display();
                    break;
                default:
                    Messages.printInvalidOptionMessage();
                    break;
            }
            printQueueLinkedMenu();

        }

    }

    private static void printQueueLinkedMenu() {
        System.out.println("\nChoice Operation\n 1. ENQUEUE\n 2. DEQUEUE\n 3. DISPLAY\n 0. Exit\n");
    }
}