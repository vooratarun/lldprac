package dsa.patterns;

import java.util.HashMap;

// Given an array nums[] and an integer k, return the count of subarrays whose sum = k.
// https://www.youtube.com/watch?v=xvNwoz-ufXA


public class SubArraySumEqualK {
    public static void main(String[] args) {

       int[] nums = {1, 2, 3};
       int k = 3;
        System.out.println(subarraySumThreeLoops(nums,k));
    }

    public static int subarraySumThreeLoops(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;

                for (int l = i; l <= j; l++) {
                    sum += nums[l];
                }

                if (sum == k) count++;
            }
        }
        return count;
    }

    public static int subarraySumTwoLoops(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += nums[j];

                if (sum == k) count++;
            }
        }
        return count;
    }

    public static int subarraySumHashMap(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // important

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    // works for only positives
    public static int subarraySumSlidingWindow(int[] nums, int k) {
        int left = 0, sum = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > k && left <= right) {
                sum -= nums[left];
                left++;
            }

            if (sum == k) {
                count++;
            }
        }

        return count;
    }
}
