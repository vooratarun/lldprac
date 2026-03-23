package dsa.array;

public class SelectionSort {


    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr);
        System.out.println("Sorted array: ");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
    }

    private static void selectionSort(int[] arr) {
        int n = arr.length;

        for(int i = 0; i< arr.length;i++){
            int minIndex = i;
            for(int j = i+1; j < arr.length;j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i]= temp;
        }
    }
}
