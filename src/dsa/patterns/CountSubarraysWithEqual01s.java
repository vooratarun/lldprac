package dsa.patterns;

import java.util.HashMap;

// Given a binary array nums[] (only 0s and 1s), return the count of subarrays with equal number of 0s and 1s.
public class CountSubarraysWithEqual01s {

    public static void main(String[] args) {
        int[] array= {0,0,0,1,1,1,1};
        System.out.println(countSubarraysBruteforce(array));

    }

    public static int countSubarraysBruteforce(int[] array){
        int count = 0;
        for( int i = 0; i < array.length;i++){
            int zeroes = 0;
            int ones = 0;
            for(int j = i; j < array.length;j++){

                if(array[j] ==0) zeroes++;
                else ones++;
                if (zeroes == ones) count++;

            }
        }
        return  count;
    }

    public static int countSubarrays(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {

            // convert 0 -> -1
            if (nums[i] == 0) sum += -1;
            else sum += 1;

            if (map.containsKey(sum)) {
                count += map.get(sum);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }


}
