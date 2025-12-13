import java.util.HashMap;
import java.util.Scanner;
import PublicClass.Messages;

enum INSERT_TYPES {
    ARRAY1D,
    ARRAY2D,
    LINKED_LIST,
    STACK,
    QUEUE,
    CQUEUE,
    TREE,
    QUEUELINKED,
    DEFUALT
}

public class MainApp {
    public static void main(String[] args) {
        HashMap<Integer, INSERT_TYPES> options = new HashMap<>();
        options.put(1, INSERT_TYPES.ARRAY1D);
        options.put(2, INSERT_TYPES.ARRAY2D);
        options.put(3, INSERT_TYPES.STACK);
        options.put(4, INSERT_TYPES.QUEUE);
        options.put(5, INSERT_TYPES.CQUEUE);
        options.put(6, INSERT_TYPES.QUEUELINKED);
        options.put(7, INSERT_TYPES.LINKED_LIST);
        options.put(8, INSERT_TYPES.TREE);

        Scanner in = new Scanner(System.in);
        int choice;
        printMenuOptions();
        while ((choice = in.nextInt()) != 0) {
            switch (options.getOrDefault(choice, INSERT_TYPES.DEFUALT)) {
                case ARRAY1D:
                    Array.MainArray1D.run(in);
                    break;
                case ARRAY2D:
                    Array.MainArray2D.run(in);
                    break;
                case STACK:
                    Stack.MainStack.run(in);
                    break;
                case QUEUE:
                    QueueDS.MainQueue.run(in);
                    break;
                case CQUEUE:
                    QueueDS.MainCQueue.run(in);
                    break;
                case QUEUELINKED:
                    QueueDS.MainQueueLinked.run(in);
                    break;
                case LINKED_LIST:
                    LinkedList.MainLinkedList.run(in);
                    break;
                case TREE:
                    BST.MainTree.run(in);
                    break;
                default:
                    Messages.printInvalidOptionMessage();
                    break;
            }
            printMenuOptions();
        }
        in.close();
    }

    public static void printMenuOptions() {
        System.out.println("\n==============================");
        System.out.println("📌 Available Options:");
        System.out.println("------------------------------");
        System.out.println("1  Array1D Operations");
        System.out.println("2  Array2D Operations");
        System.out.println("3  Stack Operations");
        System.out.println("4  Queue Operations");
        System.out.println("5  CQueue Operations");
        System.out.println("6  QueueLinkedList Operations");
        System.out.println("7  LinkedList Operations");
        System.out.println("8  Tree Operations");
        System.out.println("0  Exit Program");
        System.out.println("==============================");
        System.out.print("👉 Please enter your choice: ");
    }
}
