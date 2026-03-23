package dsa.array;

import java.util.Arrays;
import java.util.HashMap;

// https://www.techiedelight.com/find-pairs-with-given-difference-array/
public class FindPair {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 5;
        findPair(arr, target);
        findPairSorting(arr, target);
        findPairHashing(arr, target);
    }

    private static void findPair(int[] arr, int target) {

        for(int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("Pair found: " + arr[i] + " and " + arr[j]);
                    return;
                }
            }
        }
    }

    private static void findPairSorting(int[] arr, int target){

        Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int sum = arr[low]+ arr[high];
            if(sum == target) {
                System.out.println("Pair found: " + arr[low] + " and " + arr[high]);
                return;
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
    }

    private static void findPairHashing(int[] arr, int target){
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i =0; i < arr.length;i++){
           int complement = target - arr[i];
           if(map.containsKey(complement)){
               System.out.println("Pair found: " + arr[i] + " and " + complement);
               return;
           }
           map.put(arr[i], i);
       }
    }
}
