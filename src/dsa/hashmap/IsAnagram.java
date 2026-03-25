package dsa.hashmap;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public static void main(String[] args) {

        String s = "aba";
        String t ="aab";
        System.out.println(isAnagram(s,t));

    }

    public static boolean isAnagram(String s, String t){

        Map<Character,Integer> map = new HashMap<>();

        for(int i =0;  i < s.length();i++){
            Character ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        for(int j= 0; j< t.length();j++){
            Character ch = t.charAt(j);
            if(!map.containsKey(ch) || map.get(ch) == 0) return false;
            map.put(ch, map.get(ch) -1);
        }

        return true;
    }
}
