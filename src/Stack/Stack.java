package Stack;

enum PRINT_TYPE {
    PRINT,
    PRINTRE,
    PRINTRERESIVE;
}

public class Stack {
    private int top;
    int arr[];

    Stack() {
        arr = new int[10];
        top = -1;
    }

    Stack(int size) {
        top = -1;
        arr = new int[size];
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == arr.length - 1;
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("satckOverFlow");
            return;
        }
        arr[++top] = item;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("empty");
            return -1;

        }

        return arr[top--];

    }

    public void printType(PRINT_TYPE type) {
        switch (type) {
            case PRINT:
                print();
                break;
            case PRINTRE:
                printRE(top);
                break;
            case PRINTRERESIVE:
                printREREC(top);
                break;
            default:
                break;
        }
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return arr[top];
    }

    private void print() {
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[top] + ",");
        }
    }

    private void printRE(int top2) {
        if (top == -1) {
            return;
        }
        System.out.println(arr[top2] + ",");
        printRE(top2 - 1);
    }

    private void printREREC(int top2) {
        if (top == -1) {
            return;
        }
        printRE(top2 - 1);
        System.out.print(arr[top2] + ",");

    }

    public void deleteItem(int item) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item) {
                Stack stack = new Stack(arr.length);
                while (!isEmpty()) {
                    if (peek() == arr[i]) {
                        pop();
                        continue;
                    }
                    stack.push(pop());
                }
                while (!stack.isEmpty()) {
                    push(stack.pop());
                }
            }
        }
    }

    public int getSize() {
        if (isEmpty()) {
            return 0;
        }
        return top + 1;
    }
}
