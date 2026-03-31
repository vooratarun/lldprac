package dsa.hashmap;

import java.util.*;

// Given an array nums and window size k,
//return count of distinct elements in every window of size k
public class countDistinct {

    public static void main(String[] args) {

    }


    public static List<Integer> countDistinct(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= nums.length - k; i++) {
            Set<Integer> set = new HashSet<>();

            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }

            result.add(set.size());
        }

        return result;
    }

    public  static  List<Integer> countDistinctOptimized(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        // first window
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        result.add(map.size());

        // sliding window
        for (int i = k; i < nums.length; i++) {

            // remove left element
            int left = nums[i - k];
            map.put(left, map.get(left) - 1);
            if (map.get(left) == 0) {
                map.remove(left);
            }

            // add new element
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            result.add(map.size());
        }

        return result;
    }

}



