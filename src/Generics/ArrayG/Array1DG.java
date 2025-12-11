package Generics.ArrayG;


public class Array1DG<T> {
     // احذف مع التكرار وخل القيمة الي بالمنتصف أو البداية أة او النهاية أو غيره
    // ADT Abstract Data Type : Data and thier operations under specific name
    Object[] arr;
    int length;

    Array1DG(int size) {
        arr =  new Object[size];
        length = 0;
    }

    Array1DG() {
        arr =  new Object[10];
        length = 0;
    }
    

    boolean isFull() {
        return length == arr.length;
    }

    public void add(T item) {
        if (isFull()) {
            System.err.println("IS full");
            return;
        }
        arr[length++] = item;
    }

    public void addAll(T[] a) {
        for (T d : a) {
            add(d);
        }

    }

    public void delete(T item) {
        int index = search(item);
        if (index == -1) {
            return;
        }
        for (int i = index; i < length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--length] = 0;

    }

    public void deleteLast(T item) {
        int index = searchLast(item);
        if (index == -1) {
            return;
        }
        for (int i = index; i < length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--length] = 0;
    }

    public void deleteAt(int index) {

        if (index >= length) {
            return;
        }

        for (int i = index; i < length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--length] = 0;
    }

    public void deleteAll(T item) {
        int start = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i].equals(item)) {
                continue;
            }
            arr[start++] = arr[i];

        }
        length = start;

    }

    // 1,4,2,4,5,6
    public void deleteAllSkipFirst(T item) {
        boolean isFirst = false;
        int start = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i].equals(item)) {
                if (!isFirst) {
                    arr[start++] = item;
                    isFirst = !isFirst;
                }
                continue;
            }
            arr[start++] = arr[i];

        }
        length = start;

    }

    public void deleteAllSkipLast(T item) {
        boolean isLast = false;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].equals(item)) {
                if (!isLast) {
                    isLast = true;
                    continue;
                }
                deleteAt(i);
            }
        }
    }

    public void deleteJump(T item) {
        boolean delete = false;
        int start = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i].equals(item)) {
                if (delete) {
                    delete = !delete;
                    continue;
                } else {
                    arr[start++] = arr[i];
                    delete = !delete;
                }
                continue;
            }
            arr[start++] = arr[i];

        }
        length = start;

    }

    public int search(T item) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;

    }

    public int searchLast(T item) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;

    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("is Empty");
            return;
        }
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + ", ");
        }
    } 
}

