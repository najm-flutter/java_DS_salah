package Generics.ArrayG;

public class Array2DG<T> {

    // احذف مع التكرار وخل القيمة الي بالمنتصف أو البداية أة او النهاية أو غيره
    // ADT Abstract Data Type : Data and thier operations under specific name
    T[][] arr;
    int length;

    Array2DG(int size) {
        arr = (T[][]) new Object[size][size];
        length = 0;
    }

    Array2DG(int row, int col) {
        arr = (T[][]) new Object[row][col];
        length = 0;
    }

    boolean isFull() {
        return length == arr.length * arr[0].length;
    }

    public void add(T item) {

        if (isFull()) {
            return;
        }
        length++;
        int row = (length - 1) / arr[0].length;
        int col = (length - 1) % arr[0].length;
        arr[row][col] = item;
    }

    public void addAll(T[] a) {
        for (T i : a) {
            add(i);
        }

    }

    public void deleteFirst(Object item) {

        int row = 0, col = 0;
        boolean isFound = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j].equals(item) && !isFound) {
                    isFound = !isFound;
                    continue;
                }
                if (col == arr[0].length) {
                    col = 0;
                    row++;
                }
                arr[row][col++] = arr[i][j];
            }
        }
        if (isFound) {
            length--;
        }

    }

    public void deleteAt(int index) {
        if (index < 0 || index > (arr.length * arr[0].length) - 1) {
            System.out.println("error in index");
            return;
        }
        int counter = 0;
        int col = 0, row = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (counter == index) {
                    counter++;
                    continue;
                }
                if (col == arr[0].length ) {
                    col = 0;
                    row++;
                }
                arr[row][col++] = arr[i][j];
                counter++;

            }
        }
        length--;

    }

    public void deleteAll(Object item) {

        int row = 0, col = 0, len = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j].equals(item))
                    continue;
                if (col == arr[0].length) {
                    col = 0;
                    row++;
                }
                arr[row][col++] = arr[i][j];
                len++;

            }
        }
        length = len;

    }

    public void deletewithShift(Object item) {

        for (int i = 0; i < arr.length; i++) {
            while (find(arr[i], item))
                for (int j = 0; j < arr[i].length; j++) {

                    if (arr[i][j].equals(item)) {
                        for (int j2 = j; j2 < arr[i].length - 1; j2++) {
                            arr[i][j2] = arr[i][j2 + 1];
                        }
                        System.out.println(arr[i][arr[i].length - 1]);
                        ;
                        arr[i][arr[i].length - 1] = null;
                    }

                }

        }

    }

    public boolean find(Object[] arr, Object item) {
        for (int j = 0; j < arr.length; j++) {
            if (arr[j].equals(item)) {
                return true;
            }
        }
        return false;

    }

    public void deleteAndConvert(Object item) {
        T[] arr1 = (T[]) new Object[length];
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr1[++index] = arr[i][j];
            }
        }
        int start = 0;
        boolean isFound = false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == item && !isFound) {
                isFound = !isFound;
                continue;
            }
            arr1[start++] = arr1[i];

        }
        if (isFound) {
            arr1[length - 1] = null;
            length--;
        }

        index = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = arr1[++index];
            }
        }

    }

    public void print() {

        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print((start >= length ? "null" : arr[i][j]) + ", ");
                start++;

            }
            System.out.println();
        }
    }

    public void nawaf(int item) {
        if (arr.length == 0) {
            System.out.println("array is empty");
            return;
        }
        int len = search(item);
        System.out.println(len);
        if (len == 0) {
            System.out.println("element not found");
            return;
        }

        for (int i = len; i < length; i++) {
            arr[getRow(i)][getCol(i)] = arr[getRow(i + 1)][getCol(i + 1)];
        }
        arr[getRow(length)][getCol(length)] = null;
        length--;
    }

    public int getRow(int size) {
        return Math.abs(size - 1) / arr.length;
    }

    public int getCol(int size) {
        return (size - 1) % arr[0].length;

    }

    public int search(int item) {
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                len++;
                if (arr[i][j].equals(item)) {
                    return len;
                }
            }
        }

        return len;
    }

}