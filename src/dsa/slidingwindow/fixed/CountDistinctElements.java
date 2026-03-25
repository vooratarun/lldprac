package dsa.slidingwindow.fixed;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CountDistinctElements {

    public static void main(String[] args) {

        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 3;
        countDistinctElements(arr,k);

    }

    public static void countDistinctElements(int[] arr, int k){
        List<Integer> result = new ArrayList<>();

//        for(int i = 0; i <= arr.length -k;i++){
//
//            HashSet<Integer> set = new HashSet<>();
//            for(int j = i; j < i + k;j++){
//                set.add(arr[j]);
//            }
//            result.add(set.size());
//        }


        int n = arr.length;
        int i = 0;

        while (i < n-k){

            HashSet<Integer> set =  new HashSet<>();
            int j = i;
            while (j < i +k){
                set.add(arr[j]);
                j++;
            }
            i++;
            result.add(set.size());
        }

        System.out.println(result);

    }
}
