import java.util.HashMap;
import java.util.Scanner;
import PublicClass.Messages;

enum INSERT_TYPES {
    ARRAY,
    LINKED_LIST,
    STACK,
    QUEUE,
    DEFUALT
}

public class MainApp {
    public static void main(String[] args) {
        HashMap<Integer, INSERT_TYPES> options = new HashMap<>();
        options.put(1, INSERT_TYPES.ARRAY);
        options.put(2, INSERT_TYPES.STACK);
        options.put(3, INSERT_TYPES.QUEUE);
        options.put(4, INSERT_TYPES.LINKED_LIST);

        Scanner in = new Scanner(System.in);
        int choice;
        printMenuOptions();
        while ((choice = in.nextInt()) != 0) {
            switch (options.getOrDefault(choice, INSERT_TYPES.DEFUALT)) {
                case ARRAY:
                    Array.MainArray.run(in);
                    break;
                case STACK:
                    Stack.MainStack.run(in);
                    break;
                case QUEUE:
                    QueueDS.MainQueue.run(in);
                    break;
                case LINKED_LIST:
                    LinkedList.MainLinkedList.run(in);
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
        System.out.println("1  Array Operations");
        System.out.println("2  Stack Operations");
        System.out.println("3  Queue Operations");
        System.out.println("4  LinkedList Operations");

        System.out.println("0  Exit Program");
        System.out.println("==============================");
        System.out.print("👉 Please enter your choice: ");
    }
}
