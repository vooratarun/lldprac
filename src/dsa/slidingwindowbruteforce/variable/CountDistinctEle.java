package dsa.slidingwindowbruteforce.variable;

import java.util.HashSet;
import java.util.Set;


//👉 “Count subarrays with exactly K distinct elements”
public class CountDistinctEle {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(countDistinct(arr,2));
    }

    public static int countDistinct(int[] arr, int k) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            Set<Integer> set = new HashSet<>();

            for (int j = i; j < arr.length; j++) {
                set.add(arr[j]);

                if (set.size() == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
