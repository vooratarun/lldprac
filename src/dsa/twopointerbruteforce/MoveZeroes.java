package dsa.twopointerbruteforce;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] array = {1,0,0,2,4,5,6};
        int index = 0;
        for(int i = 0; i< array.length;i++){
            if(array[i] !=0){
                array[index] = array[i];
                index++;
            }
        }

        for(int j = index; j< array.length;j++){
            array[j] = 0;
        }

        System.out.println(Arrays.toString(array));
    }
}
