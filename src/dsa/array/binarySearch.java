package dsa.array;

public class binarySearch {

    public static void main(String[] args) {

            int[] arr = {1, 2, 3, 4, 5};
            int target = 3;
            int index = binarySearch(arr, target);
            System.out.println("Element found at index: " + index);
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

       while (left <= right){
           int mid = left +(right - left) / 2;
           if(arr[mid] == target){
               return mid; // Element found at index mid
           } else if (arr[mid] < target) {
               left = mid + 1; // Search in the right half
           } else {
               right = mid - 1; // Search in the left half
           }
       }
        return -1; // Element not found
    }
}
