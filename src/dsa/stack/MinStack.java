package dsa.stack;

import java.util.*;

class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    // Push
    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // Pop
    public void pop() {
        if (stack.isEmpty()) return;

        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }

        stack.pop();
    }

    // Top
    public int top() {
        return stack.peek();
    }

    // Get Minimum
    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {

    }
}