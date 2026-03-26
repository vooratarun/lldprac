package dsa.slidingwindowbruteforce.variable;

import java.util.HashSet;
import java.util.Set;

public class CountDistinctEle {

    public static void main(String[] args) {

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
