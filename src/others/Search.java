package others;
public class Search {
    public void linearSearch(int[] arr, int data) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == data) {
                System.out.println(data);
                return;
            }

        }
        System.out.println("not found");
    }

    public void binarySearch(int[] arr, int data) {
        // [1,2,3,4,5,6,7]
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = arr[mid];
            if (val > data)
                high = mid - 1;
            else if (val < data)
                low = mid + 1;
            else {
                System.out.println("foun it index: " + mid);
                return;
            }

        }
    }
}
