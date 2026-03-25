package dsa.twopointer;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    public static void main(String[] args) {

        String str = "abcde";
        int minLength = Integer.MAX_VALUE;
        String  t = "abe";
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
}
