package Array;

public class Array1D {
    // احذف مع التكرار وخل القيمة الي بالمنتصف أو البداية أة او النهاية أو غيره
    // ADT Abstract Data Type : Data and thier operations under specific name
    double[] arr;
    int length;

    public Array1D(int size) {
        arr = new double[size];
        length = 0;
    }

    boolean isFull() {
        return length == arr.length;
    }

    public void add(double item) {
        if (isFull()) {
            System.err.println("IS full");
            return;
        }
        arr[length++] = item;
    }

    public void addAll(double[] a) {
        for (double d : a) {
            add(d);
        }

    }

    public void delete(double item) {
        int index = search(item);
        if (index == -1) {
            return;
        }
        for (int i = index; i < length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--length] = 0;

    }

    public void deleteLast(double item) {
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

    public void deleteAll(double item) {
        int start = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == item) {
                continue;
            }
            arr[start++] = arr[i];

        }
        length = start;

    }

    // 1,4,2,4,5,6
    public void deleteAllSkipFirst(double item) {
        boolean isFirst = false;
        int start = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == item) {
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

    public void deleteAllSkipLast(double item) {
        boolean isLast = false;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == item) {
                if (!isLast) {
                    isLast = true;
                    continue;
                }
                deleteAt(i);
            }
        }
    }

    public void deleteJump(double item) {
        boolean delete = false;
        int start = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == item) {
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

    public int search(double item) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item) {
                return i;
            }
        }
        return -1;

    }

    public int searchLast(double item) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == item) {
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
        for (int i = length; i < arr.length; i++) {
            System.out.print(0 + ", ");
        }
    }

    public void deleteFHalf(double item) {

        int start = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == item) {

                if (i <= 4) {
                    arr[start++] = item;
                    continue;
                } else {
                    System.out.println("done");
                    continue;
                }
            }
            arr[start++] = arr[i];

        }
        length = start;
        System.out.println(start);
    }

    
}
