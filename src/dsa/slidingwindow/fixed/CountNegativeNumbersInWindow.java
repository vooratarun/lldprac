package dsa.slidingwindow.fixed;

import java.util.ArrayList;
import java.util.List;

public class CountNegativeNumbersInWindow {

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};

        CountNeg(arr,3);

    }


    public static void CountNeg(int[] arr, int k){

        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        int i = 0;
        while (i <= n- k){

            int negCount = 0;
            int j = i;
            while (j < i +k){

                if(arr[j]< 0){
                    negCount++;
                }
                j++;
            }

            result.add(negCount);

            i++;
        }
        System.out.println(result);
    }


}
