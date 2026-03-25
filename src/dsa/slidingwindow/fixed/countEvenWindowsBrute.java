package dsa.slidingwindow.fixed;

import java.util.ArrayList;
import java.util.List;

public class countEvenWindowsBrute {

    public static void main(String[] args) {

    }

    public static int CountEvenWindows(int[] arr, int k){

        int allEvenCount = 0;
        for( int i = 0; i <= arr.length -k ; i++){
            boolean allEven = true;
            for(int j = i; j < i + k;j++){

                if(arr[j] % 2 !=0){
                    allEven =false;
                    break;
                }
            }
            if(allEven) allEvenCount++;
        }
        return  allEvenCount;
    }
}
