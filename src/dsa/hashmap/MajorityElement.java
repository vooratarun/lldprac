package dsa.hashmap;

import java.util.HashMap;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] array){

       HashMap<Integer,Integer> map = new HashMap<>();

        for (int ele : array) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
            if (map.get(ele) > array.length / 2) {
                return ele;
            }


        }
       return -1;
    }

}
