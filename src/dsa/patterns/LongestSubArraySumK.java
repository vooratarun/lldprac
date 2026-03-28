package dsa.patterns;

import java.util.HashMap;

// Given an array nums[] and integer k, return the length of the longest subarray whose sum = k.
public class LongestSubArraySumK {

    public static void main(String[] args) {

        int[] array = {1,2,3,4,5,6,7,8};
        System.out.println(longSubArraySumK2Loop(array,6));
    }


    public static int longestSubarray3Loop(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                int sum = 0;
                for (int l = i; l <= j; l++) {
                    sum += nums[l];
                }

                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
    public static int longSubArraySumK2Loop(int[] array, int k){

        int maxLen = 0;

        for( int i =0; i < array.length;i++){
            int sum = 0;
            for(int j =i; j< array.length;j++){
                sum += array[j];
                if(sum ==k){
                    maxLen = Math.max(maxLen, j - i +1);
                }
            }
        }

        return maxLen;
    }

    public static int longestSubarrayHashMap(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // case 1: from index 0
            if (sum == k) {
                maxLen = i + 1;
            }

            // case 2: check previous prefix
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }

            // store first occurrence only
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }


}
