package dsa.array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {


    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2,5,2};
        System.out.println(majorityElement(arr));
        System.out.println(majaorityElementHashMap(arr));
    }

    private static int majorityElement(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > arr.length / 2) {
                return arr[i];
            }
        }

        return -1;
    }


    private static int majaorityElementHashMap(int[] arr) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i =0; i < arr.length;i++){

            int val = 1;
            if(map.containsKey(arr[i])){
                val = map.get(arr[i]) + 1;
            };
            map.put(arr[i],val);

            for(Map.Entry<Integer,Integer> entry: map.entrySet()){
                if(entry.getValue() > arr.length/2){
                    return  entry.getKey();
                }
            }
        }
        return -1;
    }
}
