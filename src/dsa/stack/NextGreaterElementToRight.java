package dsa.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// Next Greater Element to Right (NGR)
public class NextGreaterElementToRight {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};

        System.out.println(Arrays.toString(nextGreaterElementRight(array)));
        System.out.println(Arrays.toString(nextGreaterElementRightStack(array)));

    }

    public static int[] nextGreaterElementRight(int [] array){

       // List<Integer> list =  new ArrayList<>();
        int[] result = new int[array.length];

        for(int i = 0; i < array.length;i++){

            result[i] = -1;
            for(int j = i + 1; j <array.length;j++){

                if(array[j] > array[i]){
                 //   list.add(array[i]);
                    result[i] = array[j];
                    break;
                }
            }
        }
        return result;
    }

    public static int[] nextGreaterElementRightStack(int[] array){

        int[] result = new int[array.length];
        int n = array.length;

        Stack<Integer> stack = new Stack<>();

        for(int i= n-1; i >= 0; i--){

            while (!stack.isEmpty() && stack.peek() <= array[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                result[i] = -1;
            }else {
                result[i] = stack.peek();
            }
            stack.push(array[i]);

        }
        return result;
    }
}
