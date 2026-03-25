package dsa.twopointer;

import java.util.Arrays;

public class RemoveDuplicatesSortedArray {

    public static void main(String[] args) {

        int[] array = {1,1,1,2,2,3,3,4,4,5,5,6};

        int[] temp = new int[array.length];
        int index = 0;

        temp[index++] = array[0];
        for(int i =1 ;i < array.length;i++){

            if(array[i] != array[i-1]){
                temp[index] = array[i];
                index++;
            }
        }

        System.out.println(Arrays.toString(temp));
    }


}
