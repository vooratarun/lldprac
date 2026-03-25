package dsa.twopointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LogestSubString {

    public static void main(String[] args) {

        String str = "abcdef";
        System.out.println(allUnique(str,0,str.length() -1));
        int maxLength = 0;

        int[] sub = new int[2];

        for(int i =0; i< str.length();i++){
            for( int j = i; j< str.length();j++){
                boolean allUniq = allUnique(str,i,j);
                if(allUniq) {
                    // maxLength = Math.max(maxLength, j- i +1);
                   if(j - i +1 > maxLength){
                       maxLength = j-i +1;
                       sub[0] = i;
                       sub[1] = j;
                   }
                }
            }
        }
        System.out.println("Longest " + maxLength +" " + Arrays.toString(sub));
    }

    public static boolean allUnique(String str, int start, int end){
        Set<Character> set = new HashSet<>();

        for(int i = start; i <= end;i++){
            Character character = str.charAt(i);
            if(!set.contains(character)){
                set.add(character);
            }else{
                return false;
            }

        }
        return true;

    };

}
