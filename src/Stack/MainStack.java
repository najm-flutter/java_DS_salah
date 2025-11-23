package Stack;

import java.util.Scanner;

import PublicClass.Messages;

import java.util.HashMap;

enum STACK_OPERATION {
    STATIC_STACK,
    DYNAMIC_STACK,
    PUSH,
    POP,
    DISPLAY,
    DEFAULT

}

public class MainStack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        run(in);
        in.close();
    }

    public static void run(Scanner in) {

        HashMap<Integer, STACK_OPERATION> stackType = new HashMap<>(), options = new HashMap<>();
        stackType.put(1, STACK_OPERATION.STATIC_STACK);
        stackType.put(2, STACK_OPERATION.DYNAMIC_STACK);

        options.put(1, STACK_OPERATION.PUSH);
        options.put(2, STACK_OPERATION.POP);
        options.put(3, STACK_OPERATION.DISPLAY);

        int choice;
        printMenuOptions();
        while ((choice = in.nextInt()) != 0) {

            switch (stackType.getOrDefault(choice, STACK_OPERATION.DEFAULT)) {
                case STATIC_STACK:
                    staticStack(in, options);
                    break;
                case DYNAMIC_STACK:
                    dynamicStack(in, options);
                    break;
                default:
                    Messages.printInvalidOptionMessage();
                    break;
            }
            printMenuOptions();

        }
        in.close();
    }

    static void staticStack(Scanner in, HashMap<Integer, STACK_OPERATION> options) {
        System.out.println("Enter Size Of Stack :");
        int size;
        if ((size = in.nextInt()) <= 0) {
            Messages.printSizeOut();
            return;
        }

        Stack stack = new Stack(size);
        printStackOptions();
        int choice;
        while ((choice = in.nextInt()) != 0) {

            switch (options.getOrDefault(choice, STACK_OPERATION.DEFAULT)) {
                case PUSH:
                    System.out.print("Enter element:");
                    while (!stack.isFull()) {
                        System.out.print("Enter Element " + (stack.getSize() + 1) + ": ");
                        stack.push(in.nextInt());
                    }
                    break;
                case POP:
                    System.out.print(stack.pop());
                    break;
                case DISPLAY:
                    stack.printType(PRINT_TYPE.PRINTRERESIVE);
                    break;
                default:
                    break;
            }
            printStackOptions();

        }

    }

    static void dynamicStack(Scanner in, HashMap<Integer, STACK_OPERATION> options) {
        StackLinked stack = new StackLinked();
        printStackOptions();
        int choice;
        while ((choice = in.nextInt()) != 0) {

            switch (options.getOrDefault(choice, STACK_OPERATION.DEFAULT)) {
                case PUSH:
                    System.out.print("Enter Element:");
                    stack.push(in.nextInt());
                    break;
                case POP:
                    System.out.print(stack.pop());
                    break;

                case DISPLAY:
                    stack.display();
                    break;
                default:
                    break;
            }
            printStackOptions();

        }

    }

    public static void printMenuOptions() {
        System.out.println("""
                 choice Type of Stack :
                 1. Static Stack
                 2. Dynamic Stack
                 0. Exit
                """);
    }

    public static void printStackOptions() {
        System.out.println("""
                \nchoice Type of Stack
                     1. Push
                     2. Pop
                     3. Display
                     0. EXit\n
                    """);
    }
}
