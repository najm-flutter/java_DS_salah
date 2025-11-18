package Queue;

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

enum QUEUE_TYPES {
    QUEUE,
    CQUEUE,
    QUEUE_LINKED,
    DEFAULT
}

public class QueueMain {
    public static void main(String[] args) {

    }

    public static void run(Scanner in) {
        HashMap<Integer, QUEUE_OPERATIONS> options = new HashMap<>();
        HashMap<Integer, QUEUE_TYPES> queueTypes = new HashMap<>();
        options.put(1, QUEUE_OPERATIONS.ENQUEUE);
        options.put(2, QUEUE_OPERATIONS.DEQUEUE);
        options.put(3, QUEUE_OPERATIONS.DISPLAY);
        queueTypes.put(1, QUEUE_TYPES.QUEUE);
        queueTypes.put(2, QUEUE_TYPES.CQUEUE);
        queueTypes.put(3, QUEUE_TYPES.QUEUE_LINKED);

        int choice;
        printMenuOptions();
        while ((choice = in.nextInt()) != 0) {

            switch (queueTypes.getOrDefault(choice, QUEUE_TYPES.DEFAULT)) {
                case QUEUE:
                    queue(in, options);
                    break;
                case CQUEUE:
                    cQueue(in, options);
                    break;
                case QUEUE_LINKED:
                    QueueLinked(in, options);
                    break;
                default:
                    Messages.printInvalidOptionMessage();
                    break;
            }
        }
    }

    private static void queue(Scanner in, HashMap<Integer, QUEUE_OPERATIONS> options) {
        System.out.println("Enter Size Of Stack :");
        int size;
        if ((size = in.nextInt()) <= 0) {
            Messages.printSizeOut();
            return;
        }

        Queue queueOne = new Queue(size);
        printQueueMenu();
        int choice;
        while ((choice = in.nextInt()) != 0) {

            switch (options.getOrDefault(choice, QUEUE_OPERATIONS.DEFAULT)) {
                case ENQUEUE:
                    System.out.print("Enter item: ");
                    queueOne.enQueue(in.nextInt());
                    break;
                case DEQUEUE:
                    System.out.print(queueOne.deQueue());
                    break;
                case DISPLAY:
                    queueOne.display();
                    break;
                case DELETE_ITEM:
                    System.out.print("Enter item To delete: ");
                    queueOne.deleteItem(in.nextInt());
                    break;
                default:
                    Messages.printInvalidOptionMessage();
                    break;
            }
            printQueueMenu();

        }

    }

    private static void cQueue(Scanner in, HashMap<Integer, QUEUE_OPERATIONS> options) {
        System.out.println("Enter Size Of Queue :");
        int size;
        if ((size = in.nextInt()) <= 0) {
            Messages.printSizeOut();
            return;
        }

        CQueue cQueueOne = new CQueue(size);
        printCQueueMenu();
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
                case DELETE_ITEM:
                    System.out.print("Enter item To delete: ");
                    cQueueOne.deleteItem(in.nextInt());
                    break;
                default:
                    Messages.printInvalidOptionMessage();
                    break;
            }
            printCQueueMenu();

        }

    }

    private static void QueueLinked(Scanner in, HashMap<Integer, QUEUE_OPERATIONS> options) {

        QueueLinked cQueueOne = new QueueLinked();
        printCQueueMenu();
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
            printCQueueMenu();

        }

    }

    private static void printCQueueMenu() {
        System.out.println("""
                Choice Type of Queue
                     1. ENQUEUE
                     2. DEQUEUE
                     3. DISPLAY
                     4. DELETE_ITEM
                     0. EXit\n
                    """);

    }

    public static void printQueueMenu() {
        System.out.println("""
                Choice Type of Queue
                     1. ENQUEUE
                     2. DEQUEUE
                     3. DISPLAY
                     4. DELETE_ITEM
                     0. EXit

                    """);

    }

    private static void printMenuOptions() {
        System.out.println("""
                Choice Type of Queue
                     1. Queue
                     2. CQueue
                     3. QueueLinked
                     0. Exit

                    """);

    }
}
