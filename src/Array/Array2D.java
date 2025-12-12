package Array;

public class Array2D {

    // احذف مع التكرار وخل القيمة الي بالمنتصف أو البداية أة او النهاية أو غيره
    // ADT Abstract Data Type : Data and thier operations under specific name
    double[][] arr;
    public int length;

    public Array2D(int size) {
        arr = new double[size][size];
        length = 0;
    }

    public Array2D(int row, int col) {
        arr = new double[row][col];
        length = 0;
    }

    boolean isFull() {
        return length == arr.length * arr[0].length;
    }

    public void add(double item) {

        if (isFull()) {
            System.out.println("is full");
            return;
        }
        length++;
        int row = (length - 1) / arr[0].length;
        int col = (length - 1) % arr[0].length;
        arr[row][col] = item;
    }

    public void addAll(double[] a) {
        for (double i : a) {
            add(i);
        }

    }

    public void deleteFirst(double item) {

        int row = 0, col = 0;
        boolean isFound = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == item && !isFound) {
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

    public void deleteWithSkipAt(double item, int at) {

        int row = 0, col = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == item) {
                    count++;
                    if (count != at) {
                        length--;
                        continue;
                    }

                }
                if (col == arr[0].length) {
                    col = 0;
                    row++;
                }
                arr[row][col++] = arr[i][j];
            }
        }

    }

    public void deleteAll(double item) {

        int row = 0, col = 0, len = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == item)
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

    public void deleteAt(int index) {
        if (index < 0 || index > (length) - 1) {
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
                if (col == arr[0].length) {
                    col = 0;
                    row++;
                }
                arr[row][col++] = arr[i][j];
                counter++;

            }
        }
        length--;

    }

    public void deletewithShift(double item) {

        for (int i = 0; i < arr.length; i++) {
            while (find(arr[i], item))
                for (int j = 0; j < arr[i].length; j++) {

                    if (arr[i][j] == item) {
                        for (int j2 = j; j2 < arr[i].length - 1; j2++) {
                            arr[i][j2] = arr[i][j2 + 1];
                        }
                        System.out.println(arr[i][arr[i].length - 1]);
                        arr[i][arr[i].length - 1] = 0;
                    }

                }

        }

    }

    public boolean find(double[] arr, double item) {
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == item) {
                return true;
            }
        }
        return false;

    }

    public void deleteAndConvert(double item) {
        double[] arr1 = new double[length];
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
            arr1[start] = arr1[i];
            start++;
        }
        if (isFound) {
            arr1[length - 1] = 0;
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
                System.out.print((start >= length ? 0 : arr[i][j]) + ", ");
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

        for (int i = len - 1; i < length - 1; i++) {
            arr[getRow(i)][getCol(i)] = arr[getRow(i + 1)][getCol(i + 1)];
        }
        arr[getRow(length)][getCol(length)] = 0;
        length--;
    }

    public int getRow(int index) {
        return Math.abs(index) / arr.length;
    }

    public int getCol(int index) {
        return (index) % arr[0].length;

    }

    public int search(int item) {
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                len++;
                if (arr[i][j] == item) {
                    return len;
                }
            }
        }

        return len;
    }

    public double getAt(int col, int row) {
        return arr[col][row];
    }

    public void rest() {
        length = 0;
    }

}