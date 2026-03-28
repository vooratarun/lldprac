package dsa.hashmap;

import java.util.HashSet;

public class ContainDuplicates {
    public static void main(String[] args) {

        int[] array = {1,4};
        System.out.println(ContainsDuplicates(array));


    }

    public static boolean ContainsDuplicates(int[] array){
        HashSet<Integer> set = new HashSet<>();

        for(int ele : array){
            if(set.contains(ele))
                return true;
            set.add(ele);
        }
        return  false;
    }
}
