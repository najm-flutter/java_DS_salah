import java.util.HashMap;
import java.util.Scanner;
import PublicClass.Messages;

enum INSERT_TYPE {
    ARRAY,
    LINKED_LIST,
    STACK,
    DEFUALT
}

public class MainApp {
    public static void main(String[] args) {
        HashMap<Integer, INSERT_TYPE> options = new HashMap<>();
        options.put(1, INSERT_TYPE.ARRAY);
        options.put(2, INSERT_TYPE.LINKED_LIST);
        options.put(3, INSERT_TYPE.STACK);

        Scanner in = new Scanner(System.in);
        int choice;
        printMenuOptions();
        while ((choice = in.nextInt()) != 0) {
            switch (options.getOrDefault(choice, INSERT_TYPE.DEFUALT)) {
                case ARRAY:
                    Array.MainArray.run(in);
                    break;
                case STACK:
                    Stack.MainStack.main(args);
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
        System.out.println("1  Array Operations");
        System.out.println("2  Stack Operations");
        System.out.println("0  Exit Program");
        System.out.println("==============================");
        System.out.print("👉 Please enter your choice: ");
    }
}
