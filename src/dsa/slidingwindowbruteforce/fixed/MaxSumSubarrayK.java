package dsa.slidingwindowbruteforce.fixed;

public class MaxSumSubarrayK {


    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        MaxSumSubarrayKOPtimal(arr,3);
        bruteForce(arr,3);
        System.out.println(maxSum(arr,3));


    }

    public static int maxSum(int[] nums, int k) {
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        // first window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        maxSum = windowSum;

        // slide window
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i];       // add next
            windowSum -= nums[i - k];   // remove left

            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void MaxSumSubarrayKOPtimal(int[] array, int k) {
       int n = array.length;
       int left =0;
       int right = 0;
       int sum = 0;
       int maxSum = Integer.MIN_VALUE;

       while (right < n){
           sum += array[right];

           if(right - left + 1 ==k){
               maxSum = Math.max(sum,maxSum);
               sum -= array[left];
               left++;
           }

           right++;
       }
        System.out.println(maxSum);
    }

    public static void bruteForce(int[] array, int k){

        int i =0;
        int n = array.length;
        int maxSum = Integer.MIN_VALUE;


        while (i < n-k){

            int sum = 0;
            int j = i;
            while (j < i +k){
                sum += array[j];
                j++;
            }

            maxSum = Math.max(sum,maxSum);
            i++;
        }

        System.out.println(maxSum);
    }
}
