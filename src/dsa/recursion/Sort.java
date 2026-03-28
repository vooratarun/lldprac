package dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {

    }

    public static void sort(ArrayList<Integer> array){

        if(array.size() == 1) return;

        int last = array.remove(array.size() -1);

        sort(array);

        insert(array,last);

    }

//insert([1,3,4],2) steps are as follows

//            [1,3,4] → remove 4
//            [1,3]   → remove 3
//            [1]     → insert 2
//            [1,2]   → add back 3
//            [1,2,3] → add back 4

    public static void insert(ArrayList<Integer> arr, int temp) {

      if(arr.size() == 0 || arr.get(arr.size() -1) == temp){
          arr.add(temp);
          return;
      }
      int last =  arr.remove(arr.size() -1);
      insert(arr, temp);
      arr.add(last);

    }
}
