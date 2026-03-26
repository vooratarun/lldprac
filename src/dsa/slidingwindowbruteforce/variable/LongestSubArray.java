package dsa.slidingwindowbruteforce.variable;


import java.util.Arrays;

//🧩 Problem 1: Longest Subarray with Sum ≤ K
public class LongestSubArray {

    public static void main(String[] args) {

        int[] array = {1,2,3,4,5,6,7,8};

        longestSubarray(array,3);
    }

    public static void printSubarray(int[] array, int start, int end) {

        System.out.println();
        for( int i = start; i < end;i++) {
            System.out.print(array[i]+ " ");
        }
    }


    public static void longestSubarray(int[] arr, int k) {

        int n = arr.length;
        int maxLength = Integer.MIN_VALUE;
        int[] output = new int[2];
        for (int i = 0; i < n; i++) {

            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];

                if(sum <= k){
                    maxLength = Math.max(maxLength,j-i +1);
                    output[0] = i;
                    output[1] = j;
                }

            }
        }
        System.out.println(maxLength);
        System.out.println(Arrays.toString(output));
    }

    public static int longestSubarrayBr(int[] arr, int k) {
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;

            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
}
