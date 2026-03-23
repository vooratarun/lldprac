package dsa.array;

import java.util.ArrayList;
import java.util.List;

public class printSubarray {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        printSubarrays(arr);
    }

    private static void printSubarrays(int[] arr) {

        List<int[]> subarrayList =  new ArrayList<>();

      for(int i = 0; i < arr.length;i++){
          for(int j =i ; j < arr.length;j++){

              int[] subarray = new int[j - i + 1] ;
              int z= 0;
              for(int k = i; k <= j;k++){
                  System.out.print(arr[k] + " ");
                  subarray[z] = arr[k];
                  z++;
              }
              subarrayList.add(subarray);
              System.out.println();

          }
      }

      for(int[] subarray: subarrayList){
          System.out.println("Subarray: " + java.util.Arrays.toString(subarray));
      }
    }
}
