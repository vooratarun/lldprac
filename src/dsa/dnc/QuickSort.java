package dsa.dnc;

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            int pi = partitioning(arr, low, high);

            quickSort(arr, low, pi);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {

        int pivot = arr[high]; // last element
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // place pivot at correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 3};

        quickSort(arr, 0, arr.length - 1);

        for (int num : arr)
            System.out.print(num + " ");
    }

    public static int partitioning(int[] arr, int l, int h) {

        int pivot = arr[l];
        int i = l - 1;
        int j = h + 1;

        while (true) {

            // move from left
            do {
                i++;
            } while (arr[i] < pivot);

            // move from right
            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) return j;

            // swap
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }}