
public class Array1D {
    // احذف مع التكرار وخل القيمة الي بالمنتصف أو البداية أة او النهاية أو غيره
    // ADT Abstract Data Type : Data and thier operations under specific name
    double[] arr;
    int length;

    Array1D(int size) {
        arr = new double[size];
        length = 0;
    }

    boolean isFull() {
        return length == arr.length;
    }

    public void add(int item) {
        if (isFull()) {
            return;
        }
        arr[length++] = item;
    }

    public void delete(double item) {
        int index = search(item);
        System.out.println(index);
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

    public void print() {
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}
