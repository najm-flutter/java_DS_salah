
public class Array1D {
    // احذف مع التكرار وخل القيمة الي بالمنتصف أو البداية أة او النهاية أو غيره
    // ADT Abstract Data Type : Data and thier operations under specific name
    double[] arr;
    int length;

    Array1D(int size) {
        // sout.err : for Errors And تسيق any other Print
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
        if (index == -1) {
            return;
        }
        // 0, 1, 3, 4, 5

        for (int i = index; i < arr.length - length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--length] = 0;

    }

    public int search(double item) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item) {
                return i;
            }
        }
        return -1;

    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}
