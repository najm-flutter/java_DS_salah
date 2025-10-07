import java.util.Arrays;

public class MyArrayList {
    int size;
    int capacity = 10;
    int[] arr;

    MyArrayList() {
        this.size = 0;
        this.arr = new int[capacity];
    }

    MyArrayList(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void grow() {
        capacity = capacity + 10;
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        arr = new int[capacity];
        for (int i = 0; i < arr2.length; i++) {
            arr[i] = arr2[i];
        }
    }

    public void add(int item) {
        if (isFull()) {
            grow();
        }
        arr[size++] = item;

    }

    public void removeAt(int index) {
        if (!(index <= size - 1)) {
            System.out.println("error");
            return;

        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--size] = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
