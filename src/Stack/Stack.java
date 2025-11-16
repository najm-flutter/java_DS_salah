package Stack;

enum PRINT_TYPE {
    PRINT,
    PRINTRE,
    PRINTRERESIVE;
}

public class Stack {
    int top;
    double arr[];

    Stack() {
        arr = new double[10];
        top = -1;
    }

    Stack(int size) {
        top = -1;
        arr = new double[size];
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == arr.length - 1;
    }

    public void push(double item) {
        if (isFull()) {
            System.out.println("satckOverFlow");
            return;
        }
        arr[++top] = item;
    }

    public double pop() {
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
}
