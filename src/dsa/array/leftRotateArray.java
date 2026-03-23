package dsa.array;

// https://www.techiedelight.com/left-rotate-array-c/
public class leftRotateArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int d = 2;
        leftRotate(arr, d);
        printArray(arr);
    }


    private static void leftRotateByOne(int[] arr){

        int first = arr[0];
        for(int i = 0; i < arr.length -1; i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length -1] = first;
    }


    private static void leftRotate(int[] arr, int d) {

        for(int i = 0; i < d;i++){
            leftRotateByOne(arr);
        }

    }

    private static void printArray(int[] arr) {

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
