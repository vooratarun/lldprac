package dsa.dp;

import java.util.*;

class Pair {
    int sum;
    List<Integer> path;

    Pair(int sum, List<Integer> path) {
        this.sum = sum;
        this.path = path;
    }
}

public class HouseRobberRecursion {

    public static Pair robHelper(int[] nums, int i) {
        if (i >= nums.length) {
            return new Pair(0, new ArrayList<>());
        }

        // PICK
        Pair pick = robHelper(nums, i + 2);
        int pickSum = nums[i] + pick.sum;
        List<Integer> pickPath = new ArrayList<>();
        pickPath.add(i);
        pickPath.addAll(pick.path);

        // SKIP
        Pair skip = robHelper(nums, i + 1);

        // Choose better
        if (pickSum > skip.sum) {
            return new Pair(pickSum, pickPath);
        } else {
            return skip;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};

        Pair result = robHelper(nums, 0);

        System.out.println("Max Money: " + result.sum);
        System.out.println("Houses robbed: " + result.path);
    }
}