package dsa.stack;

import java.util.*;

public class ElementsGreaterThanRight {
    public static void main(String[] args) {
        int[] arr = { 10, 4, 6, 3, 5 };
        find(arr);
        findStack(arr);
        findStackRightToLeft(arr);
    }

    private static void find(int[] arr) {

        for(int i = 0; i < arr.length;i++) {
            int ele = arr[i];
            boolean maxFound = false;
            for( int j = i+1; j < arr.length;j++){
                if(arr[j] > ele){
                    maxFound = true;
                    break;
                }
            }

            if(!maxFound){
                System.out.println(arr[i]);
            }

        }
    }

    public static void findStack(int[] arr){

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int var : arr){

            while (!stack.isEmpty() && stack.peek()< var){
                stack.pop();
            }
            stack.push(var);
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        Collections.reverse(result);
        System.out.print(result);

    }
    public static void findStackRightToLeft(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        // RIGHT → LEFT ✅
        for (int i = arr.length - 1; i >= 0; i--) {

            // Remove smaller elements
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
            }

            stack.push(arr[i]);
        }

        // Extract leaders
        int max = Integer.MIN_VALUE;

        while (!stack.isEmpty()) {
            int val = stack.pop();
            if (val > max) {
                result.add(val);
                max = val;
            }
        }

        Collections.reverse(result);
        System.out.println(result);
    }

}
