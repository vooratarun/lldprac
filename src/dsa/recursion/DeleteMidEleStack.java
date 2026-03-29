package dsa.recursion;

import java.util.Stack;

public class DeleteMidEleStack {


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        int k = (stack.size() / 2) + 1;

        deleteMid(stack, k);

        System.out.println(stack);

    }

    public static void deleteMid(Stack<Integer> stack, int k){

        if(k == 1){
            stack.pop();
            return;
        }

        int top = stack.pop();

        deleteMid(stack, k - 1);

        stack.push(top);

    }
}
