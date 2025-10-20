public class StackArray {
    private int top;
    int[] arr;

    StackArray(int size) {
        arr = new int[size];
        top = -1;
    }

    public void push(int item) {
        if (isFull()) {

            return;
        }
        arr[++top] = item;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return arr[top];
    }

    public void pop() {
        if (isEmpty()) {
            return;
        }
        --top;
    }

    public boolean isFull() {
        return arr.length - 1 == top;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public String print() {
        String s = "";
        for (int i = 0; i <= top; i++) {
            s += arr[i] + ",";
        }
        return "[" + s.substring(0, s.length() - 1) + "]";
    }

}
