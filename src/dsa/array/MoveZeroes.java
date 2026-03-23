package dsa.array;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        printArray(arr);
    }

    private static void moveZeroes(int[] arr) {
        int nonZeroIndex = 0 ;
        for(int i = 0; i < arr.length;i++){
            if(arr[i] != 0){
                arr[nonZeroIndex] = arr[i];
                nonZeroIndex++;
            }
        }

        for(int i = nonZeroIndex; i < arr.length;i++){
            arr[i] = 0;
        }
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
