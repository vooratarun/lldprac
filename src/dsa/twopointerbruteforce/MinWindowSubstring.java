package dsa.twopointerbruteforce;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    public static void main(String[] args) {

        String str = "abcde";
        int minLength = Integer.MAX_VALUE;
        String  t = "ab";
        String result= "";

        for(int i =0 ; i< str.length();i++){
            for( int j = i; j< str.length();j++){
                // System.out.println(str.substring(i,j));

                String substring = str.substring(i,j);

                if(containsAll(substring,t)){
                    if(substring.length() < minLength){
                        minLength = substring.length();
                        result = substring;
                    }
                }
            }
        }
        System.out.println(result);

    }

    public static boolean containsAll(String s, String  t) {
        Map<Character,Integer> map = new HashMap<>();

        for (Character ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+ 1);
        }

        for(Character ch : s.toCharArray()){
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
            }
        }

        for(int val : map.values()){
            if(val > 0) return false;
        }

        return true;
    }

    private static boolean isValid(String sub, String t) {
        int[] freq = new int[128];

        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        for (char c : sub.toCharArray()) {
            if (freq[c] > 0) {
                freq[c]--;
            }
        }

        for (int f : freq) {
            if (f > 0) return false;
        }

        return true;
    }


}
