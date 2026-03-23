package dsa.array;

public class RightRotateArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int d = 2;
        rightRotate(arr, d);
        printArray(arr);
    }

    private static void rightRotate(int[] arr, int d) {

        for(int i = 0; i < d;i++){
            rightRotateByOne(arr);
        }
    }

    private static void rightRotateByOne(int[] arr) {
        int last = arr[arr.length-1];
        for(int i = arr.length - 2; i>=0;i--){
            arr[i +1] = arr[i];
        }
        arr[0] = last;
    }

    private static void printArray(int[] arr) {

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
