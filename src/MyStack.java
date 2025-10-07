public class MyStack {
    int top = -1;
    int[] arr;

    MyStack(int size) {
        arr = new int[size];
    }

    public void push(int item) {

        arr[++top] = item;

    }

    public int pop() {
        if (top == -1) {
            return -1;
        }
        int tmp = arr[top] ;
        arr[top--] = 0;
        return tmp;
    }

    public int peek() {
        return arr[top];
    }
}
