import java.util.Arrays;

public class MySort {
    public void bubleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swp = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swp = true;
                }

            }
            if (!swp) {
                break;
            }

        }
        System.out.println(Arrays.toString(arr));
    }

    public void selectSort(int[] arr) {
        // [5,4,1,2,3]
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public void insertaionSort(int[] arr) {
        // int[] arr = { 1, 4, 3, 54, 6, 34, 67, 21, 43 };

        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int repIndex = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (tmp < arr[j]) {
                    arr[j + 1] = arr[j];
                    repIndex = j;
                }

            }
            if (repIndex > -1) {

                arr[repIndex] = tmp;
                System.out.println(repIndex);
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
