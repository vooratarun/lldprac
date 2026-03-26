package dsa.slidingwindowbruteforce.variable;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3,4,5,6,7,8};
//        PrintAllSubArrayList(arr);
        PrintAllSubArrayLengthK(arr,2);
    }

    public static void PrintAllSubArrayList(int[] arr) {

        List<int[]> list =  new ArrayList<>();
        for(int i = 0; i < arr.length;i++){
            for( int j = i; j < arr.length;j++){

                int[] subarray =  new int[j -i + 1];
                int z= 0;
                for(int k= i; k<=j;k++){
                 //   System.out.print(arr[k] + " ");
                    subarray[z] = arr[k];
                    z++;
                }
                list.add(subarray);
                System.out.println();
            }
        }

        for(int[] subarray : list){
            for(int i=0; i < subarray.length;i++){
                System.out.print(subarray[i] +" ");
            }
            System.out.println();
        }
    }

    public static void PrintAllSubArrayLengthK(int[] arr, int k) {

        for( int i = 0; i <= arr.length -k;i++){
            for( int j = i; j < i + k;j++){
                System.out.print(arr[j] + " ");
            }
            System.out.println();

        }
    }
}
