package dsa.twopointerbruteforce;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
        System.out.println(threeSumHashmap(nums));
        System.out.println(threeSumOptimized(nums));
    }

    public  static  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);
                        if (!res.contains(triplet)) {
                            res.add(triplet);
                        }
                    }
                }
            }
        }

        return res;
    }

   static List<List<Integer>> threeSumOptimized(int[] arr) {

        if (arr == null || arr.length < 3) return new ArrayList<>();

        // Sort the elements
        Arrays.sort(arr);
        Set<List<Integer>> result = new HashSet<>();

        // Now fix the first element and find the other two elements
        for (int i = 0; i < arr.length - 2; i++)
        {
            // Find other two elements using Two Sum approach
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {

                    // Add the set, and move to find other triplets
                    result.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                } else if (sum < 0)
                    left++;
                else
                    right--;
            }
        }
        return new ArrayList<>(result);
    }


    public static List<List<Integer>> threeSumHashmap(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            Set<Integer> seen = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {
                int complement = -nums[i] - nums[j];

                if (seen.contains(complement)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                    Collections.sort(triplet);
                    result.add(triplet);
                }

                seen.add(nums[j]);
            }
        }

        return new ArrayList<>(result);
    }
}
