package dsa.array;

public class SegregateNumbers {

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -4, 5, -6};
        segregateNumbers(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    private static void segregateNumbers(int[] arr) {

        int[] temp = new int[arr.length];

        int index = 0;

        for (int i  =0 ; i < arr.length;i++){
            if(arr[i] < 0){
                temp[index] = arr[i];
                index++;
            }
        }

        for (int i  =0 ; i < arr.length;i++){
            if(arr[i] >= 0){
                temp[index] = arr[i];
                index++;
            }
        }

        for(int i = 0; i < arr.length;i++){
            arr[i] = temp[i];
        }
    }
}
