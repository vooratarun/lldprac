package dsa.array;

public class ReverseArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        reverseArrayWhileLoop(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }

    private static void reverseArray(int[] arr) {

        int[] reverse = new int[arr.length];

        int z= 0;
        for (int i = arr.length-1; i>=0; i--){
            reverse[z] = arr[i];
            z++;
        }

        for(int i = 0; i < arr.length;i++){
            arr[i] = reverse[i];
        }
    }

    private static void reverseArrayWhileLoop(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

    }
}
