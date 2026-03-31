package dsa.backtracking;

import java.util.*;

public class PowerSetStringList {

    static  String str = "abc";
    static List<String> result = new ArrayList<>();
    static int noOfCalls = 0;


    public static void main(String[] args) {

        bt(0, "");

       System.out.println(result);
        System.out.println(noOfCalls);
    }

    public static void bt( int index, String curr) {

        System.out.print("bt(" + index + ","  + curr +""+")");
        System.out.println();
        noOfCalls++;


        if (index == str.length()) {
           result.add(curr);
            System.out.println("VALUE: "+curr);
            System.out.println();
            return;
        }

        // include
        bt( index + 1, curr + str.charAt(index));

        // exclude
        bt(index + 1, curr);
    }
}