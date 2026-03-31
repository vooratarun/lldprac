package dsa.array;

import java.util.*;

public class EqualZeroOneSubarrays {
    public static int countSubarrays(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            // Convert 0 → -1
            if (num == 0) {
                sum += -1;
            } else {
                sum += 1;
            }

            if (map.containsKey(sum)) {
                count += map.get(sum);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1};
        System.out.println(countSubarrays(nums)); // Output: 4
    }
}