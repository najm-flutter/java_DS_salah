package Stack;

import java.util.Scanner;
import java.util.HashMap;

enum STACK_OPERATION {
    STATIC_STACK,
    DYNAMIC_STACK,
    PUSH,
    POP,
    DISPLAY

}

public class MainStack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, STACK_OPERATION> stackType = new HashMap<>(), options = new HashMap<>();
        stackType.put(1, STACK_OPERATION.STATIC_STACK);
        stackType.put(2, STACK_OPERATION.DYNAMIC_STACK);

        options.put(1, STACK_OPERATION.PUSH);
        options.put(2, STACK_OPERATION.POP);
        options.put(3, STACK_OPERATION.DISPLAY);
        System.out.println("""
                 choise Type of Stack
                 1-Static Stack
                 2-Dynamic Stack
                 0-Exit
                """);
        int choise;
        while ((choise = in.nextInt()) != 0) {

            switch (stackType.get(choise)) {
                case STATIC_STACK:
                    static_stack(in, options);
                    break;
                case DYNAMIC_STACK:
                    dyanmic_stack(in, options);
                    break;
                default:
                    break;
            }
            System.out.println("""
                     choise Type of Stack
                     1-Static Stack
                     2-Dynamic Stack
                     0-Exit
                    """);

        }
        in.close();
    }

    static void static_stack(Scanner in, HashMap<Integer, STACK_OPERATION> options) {
        System.out.println("ENter size of Stack");
        int size = in.nextInt();
        Stack stack = new Stack(size);
        System.out.println("""
                \nchoise Type of Stack
                     1-PUSH
                     2-PUB
                     3-Display
                     0-EXit\n
                    """);
        int choise;
        while ((choise = in.nextInt()) != 0) {
            STACK_OPERATION operation;
            try {
                operation = options.get(choise);
            } catch (Exception e) {
                System.err.println("error");
                continue;
            }
            switch (operation) {
                case PUSH:
                    System.out.print("inter element:");
                    stack.push(in.nextInt());
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
            System.out.println("""
                    \nchoise Type of Stack
                     1-PUSH
                     2-PUB
                     3-Display
                     0-EXit\n
                        """);

        }

    }

    static void dyanmic_stack(Scanner in, HashMap<Integer, STACK_OPERATION> options) {
        StackLinked stack = new StackLinked();
        System.out.println("""
                \nchoise Type of Stack
                     1-PUSH
                     2-PUB
                     3-Display
                     0-EXit\n
                    """);
        int choise;
        while ((choise = in.nextInt()) != 0) {
            STACK_OPERATION operation;
            try {
                operation = options.get(choise);
            } catch (Exception e) {
                System.err.println("error");
                continue;
            }
            switch (operation) {
                case PUSH:
                    System.out.print("inter element:");
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
            System.out.println("""
                    \nchoise Type of Stack
                     1-PUSH
                     2-PUB
                     3-Display
                     0-EXit\n
                        """);

        }

    }
}
