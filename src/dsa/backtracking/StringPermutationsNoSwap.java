package dsa.backtracking;

import java.util.*;

//https://chatgpt.com/c/69c9331e-0204-8322-8055-e44cdca2f7e2
public class StringPermutationsNoSwap {

    static String str  = "abc";

    static  boolean[] used = new boolean[str.length()];
    public static void main(String[] args) {
       // String str = "abc";

        bt( "");
    }

    public static void bt(  String curr) {

        // Base case
        if (curr.length() == str.length()) {
            System.out.println(curr);
            return;
        }

        // Try all characters
        for (int i = 0; i < str.length(); i++) {

            if (used[i]) continue;

            // Choose
            used[i] = true;

            // Explore
            bt( curr + str.charAt(i));

            // Backtrack (undo)
            used[i] = false;

        }
    }
}