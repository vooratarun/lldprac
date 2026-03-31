package dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {
        int[] array = {1,2,3};
        subsets(array,0,new ArrayList<>());

        String str = "abc";
        generate(str, 0, "");
    }

    public static void subsets(int[] arr, int i, List<Integer> curr) {
        if (i == arr.length) {
            System.out.println(curr);
            return;
        }

        // include
        curr.add(arr[i]);
        subsets(arr, i + 1, curr);

        // backtrack
        curr.remove(curr.size() - 1);

        // exclude
        subsets(arr, i + 1, curr);
    }

    public static void generate(String str, int index, String curr) {

        // Base case
        if (index == str.length()) {
            System.out.println(curr);
            return;
        }

        // Include current character
        generate(str, index + 1, curr + str.charAt(index));

        // Exclude current character
        generate(str, index + 1, curr);
    }
}
