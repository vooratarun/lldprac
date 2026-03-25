package dsa.slidingwindow.variable;


//🧩 Problem 1: Longest Subarray with Sum ≤ K
public class LongestSubArray {

    public static void main(String[] args) {

        int[] array = {1,2,3};

        longestSubarray(array,5);
    }

    public static void printSubarray(int[] array, int start, int end) {

        System.out.println();
        for( int i = start; i < end;i++) {
            System.out.print(array[i]+ " ");
        }
    }


    public static void longestSubarray(int[] arr, int k) {

        int n = arr.length;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                for (int z = i; z <= j; z++) {
                    System.out.print(arr[z] + " ");
                }
                System.out.println();
            }
        }
    }
}
