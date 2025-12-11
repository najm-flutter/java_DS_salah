package Generics.StackG;

enum PRINT_TYPE {
    PRINT,
    PRINTRE,
    PRINTRERESIVE;
}

public class StackG<T> {

    private int top;
    T arr[];

    StackG() {
        arr = (T[]) new Object[10];
        top = -1;
    }

    StackG(int size) {
        top = -1;
        arr = (T[]) new Object[size];
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == arr.length - 1;
    }

    public void push(T item) {
        if (isFull()) {
            System.out.println("satckOverFlow");
            return;
        }
        arr[++top] = item;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("empty");
            return null;

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

    public T peek() {
        if (isEmpty()) {
            return null;
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

    public void deleteItem(T item) {
        if (isEmpty()) {
            System.out.println("is Empty");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(item)) {
                StackG<T> stack = new StackG<>(arr.length);
                while (!isEmpty()) {
                    if (peek().equals(arr[i])) {
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
