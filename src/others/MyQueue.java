package others;
public class MyQueue {

    int top = -1;
    int size = 0;
    int[] arr;

    MyQueue(int size) {
        arr = new int[size];
    }

    public int offer(int item) {
        arr[++top] = item;

        return item;

    }

    public int peek() {
        if (top == -1) {
            return -1;
        }
        return arr[0];
    }

    public int poll() {
        if (top == -1) {
            return -1;
        }


        int obj = arr[0];
        for (int i = 0; i < top; i++) {
            if (i == top - 1) {
                arr[i] = arr[i + 1];
                arr[i + 1] = 0;
                break;
            }
            arr[i] = arr[i + 1];
        }
        --top;
        return obj;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i : arr) {
            s += i + ",";
        }
        return "[" + s + "]";
    }
}