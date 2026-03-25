package dsa.hashmap;

import java.util.HashSet;
import java.util.Set;

public class TwoArraysIntersection {

    public static void main(String[] args) {

        int[] arr1 = {1,2,4,3};
        int[] arr2= {1,2};
        interSection(arr1,arr2);

    }

    public static void interSection(int[] arr1, int[] arr2) {

        Set<Integer> set =  new HashSet<>();
        Set<Integer> result = new HashSet<>();


        for (int ele:arr1) {
            set.add(ele);
        }

        for(int ele: arr2) {
            if(set.contains(ele)) {
                result.add(ele);
            }
        }
        System.out.println(result);


    }
}
