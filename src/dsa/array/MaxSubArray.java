package dsa.array;

// https://www.techiedelight.com/maximum-subarray-problem-kadanes-algorithm/
public class MaxSubArray {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(findMaxSubarraySum(arr));
    }

    private static int findMaxSubarraySum(int[] arr) {

        int maxSum = Integer.MIN_VALUE;
        for( int i = 0; i < arr.length;i++){
            for(int j= i; j < arr.length;j++){
               // System.out.println("Subarray: " + arr[i] + " to " + arr[j]);
                int sum = 0;
                for(int k = i; k <= j;k++){
                    sum += arr[k];
                }

                if(sum > maxSum){
                    maxSum = sum;
                }
                // System.out.println("Current Sum: " + sum + ", Max Sum: " + maxSum);
            }
        }

        return  maxSum;
    }
}
