package dsa.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

        int[] array = {1,1,2,3,4,5,6};
        int target = 5;
        System.out.println(Arrays.toString(twoSum(array,target)));
    }

    public static int[] twoSum(int[] array, int target){

        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0; i < array.length;i++){
            int complement = target -array[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i };
            }
            map.put(array[i],i);
        }
        return new int[]{-1, -1};
    }
}
