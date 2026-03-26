package dsa.slidingwindowbruteforce.variable;

import java.util.*;

public class AllSubarraysOptimized {

    public static void printAllSubarrays(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            List<Integer> temp = new ArrayList<>();

            for (int j = i; j < n; j++) {
                temp.add(arr[j]);   // grow subarray

                // print current subarray
                System.out.println(temp);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        printAllSubarrays(arr);
    }
}