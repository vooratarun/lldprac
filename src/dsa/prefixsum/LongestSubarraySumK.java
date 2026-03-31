package dsa.prefixsum;

import java.util.*;

public class LongestSubarraySumK {
    public static int longestSubarray(int[] arr, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Case 1: prefixSum itself equals K
            if (prefixSum == K) {
                maxLen = i + 1;
            }

            // Case 2: Check if (prefixSum - K) exists
            if (map.containsKey(prefixSum - K)) {
                int len = i - map.get(prefixSum - K);
                maxLen = Math.max(maxLen, len);
            }

            // Store first occurrence only
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }

    //sliding window
    public static int longestSubarrayPositive(int[] arr, int K) {
        int left = 0, sum = 0, maxLen = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum > K) {
                sum -= arr[left];
                left++;
            }

            if (sum == K) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1, 1};
        int K = 3;

        System.out.println(longestSubarray(arr, K)); // Output: 3
    }
}