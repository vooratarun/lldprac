package dsa.hashmap;

import java.util.HashMap;
import java.util.Map;

public class FirstUniquChar {

    public static void main(String[] args) {

        String s = "aabcde";
        System.out.println(s.charAt(firstUniqChar(s)));
    }

    public static  int firstUniqChar(String s) {

        Map<Character,Integer> map =  new HashMap<>();

        for(int i =0; i< s.length();i++){
            Character ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        for( int i =0; i< s.length();i++){
            if(map.get(s.charAt(i)) == 1) return i;
        }

        return -1;
    }
}
