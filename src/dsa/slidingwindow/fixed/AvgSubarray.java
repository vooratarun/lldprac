package dsa.slidingwindow.fixed;

import java.util.ArrayList;
import java.util.List;

public class AvgSubarray {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 3;
//        AvgSubArray(arr,k);
        average(arr,k);
    }

    public static void AvgSubArray(int[] array, int k){

        List<Float> result =  new ArrayList<>();
        for(int i =0; i <= array.length - k;i++){

            int sum = 0;
            for( int j = i; j < i +k;j++){
                sum += array[j];
            }

            result.add((float) (sum/k));
        }

        for(float ele : result){
            System.out.println(ele);
        }

    }

    public static void average(int[] arr, int k) {
        int n = arr.length;
        List<Double> result = new ArrayList<>();

        for (int i = 0; i <= n - k; i++) {
            int sum = 0;

            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }

           double r = (sum / (double) k);
            result.add(r);
        }
        System.out.println(result);
    }
}
