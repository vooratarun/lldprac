package dsa.slidingwindowbruteforce.fixed;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeNumber {

    public static void main(String[] args) {

        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};

        firstNegNumber(arr, 3);

    }


    public static void firstNegNumber(int[] arr, int k) {

        List<Integer> result = new ArrayList<>();
//
//        for(int i = 0; i <= arr.length -k; i++){
//
//            boolean found = false;
//            for(int j = i; j < i + k;j++){
//
//                if(arr[j]< 0){
//                    result.add(arr[j]);
//                    found = true;
//                    break;
//                }
//            }
//            if(!found) {
//                result.add(0);
//            }
//
//        }
//        for(int ele : result){
//            System.out.println(ele);
//        }


        int i = 0;
        while (i <= arr.length - k) {

            boolean found = false;
            int j = i;
            while (j < i + k) {
                if (arr[j] < 0) {
                    result.add(arr[j]);
                    found = true;
                    break;
                }
                j++;
            }
            if (!found) {
                result.add(0);
            }
            i++;

        }
        System.out.println(result);

    }
}
