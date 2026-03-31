package dsa.recursion;

import java.util.Stack;

public class ReverseStockRecursion {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
//        stack.push(3);
//        stack.push(4);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }

    public static void reverse(Stack<Integer> stack) {

        if(stack.isEmpty()) return;

        int top = stack.pop();

        reverse(stack);

        insertAtBottom(stack, top);

    }

    private static void insertAtBottom(Stack<Integer> stack, int temp) {

        if(stack.isEmpty()){
            stack.push(temp);
            return;
        }
        int top = stack.pop();
        insertAtBottom(stack,temp);
        stack.push(top);
    }
}
