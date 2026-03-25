package dsa.slidingwindow.fixed;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MaxElementWindow {

    public static void main(String[] args) {

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        maxEleWindow(arr,k);
    }

    public static void maxEleWindow(int[] array, int k){

//        List<Integer> result = new ArrayList<>();
//        for( int i= 0; i <= array.length -k;i++){
//            int max = array[i];
//            for(int j = i; j < i +k;j++){
//                if(array[j]> max){
//                    max = array[j];
//                }
//            }
//            result.add(max);
//        }
//
//        for(int ele : result){
//            System.out.println(ele);
//        }

        List<Integer> result = new ArrayList<>();

        int i = 0;
        while (i <= array.length - k){

            int max = array[i];
            int j = i;
            while (j < i +k){
                if(array[j]> max){
                    max = array[j];
                }
                j++;
            }

            result.add(max);

            i++;
        }

        System.out.println(result);

    }

}
