package dsa.recursion;

import java.util.*;

public class SortStackRecursion {

    public static void sort(Stack<Integer> stack) {
        // Base case
        if (stack.size() == 1) return;

        // Step 1: remove top
        int top = stack.pop();

        // Step 2: sort remaining
        sort(stack);

        // Step 3: insert correctly
        insert(stack, top);
    }

    public static void insert(Stack<Integer> stack, int temp) {
        // Base condition
        if (stack.isEmpty() || stack.peek() <= temp) {
            stack.push(temp);
            return;
        }

        // Remove top
        int top = stack.pop();

        // Recursive call
        insert(stack, temp);

        // Put back removed element
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        sort(stack);

        System.out.println(stack);
    }
}