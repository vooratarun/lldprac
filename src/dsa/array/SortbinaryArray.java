package dsa.array;

// https://www.techiedelight.com/sort-binary-array-linear-time/

public class SortbinaryArray {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 1, 0};
        sortBinaryArray(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    private static void sortBinaryArray(int[] arr) {

        int zeroes = 0;
        int ones = 0;
        for(int i =0;i < arr.length;i++){

            if(arr[i] == 0){
                zeroes++;
            }

            if(arr[i] == 1){
                ones++;
            }

        }
//
//        for(int i = 0; i < zeroes; i++){
//            arr[i] = 0;
//        }
//
//        for (int j = zeroes; j < zeroes + ones; j++) {
//            arr[j] = 1;
//        }
//
        int k = 0;
        while(zeroes > 0){
            arr[k] = 0;
            k++;
            zeroes--;
        }

        while(ones > 0){
            arr[k] = 1;
            k++;
            ones--;
         }
    }

    public static void SortBinaryArrayWhile(int[] arr) {
        int zeroes = 0;

        for(int a : arr) {
            if(a == 0){
                zeroes++;
            }
        }

        int k = 0;
        while(zeroes > 0){
            arr[k] = 0;
            k++;
            zeroes--;
        }

        while( k < arr.length){
            arr[k] = 1;
            k++;
         }

    }
}
