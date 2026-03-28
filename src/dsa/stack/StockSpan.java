package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {

        int[] array= {100, 80, 60, 70, 60, 75, 85};
        System.out.println(Arrays.toString(stockSpan(array)));
        System.out.println(Arrays.toString(stockSpanOptimized(array)));

    }

    public static int[] stockSpan(int[] array){

        int[] result = new int[array.length];

        for(int i = 0; i < array.length;i++){
            int count = 1;
            for(int j = i -1; j>=0;j--){

                if(array[j] <= array[i]){
                    count++;
                }else {
                    break;
                }
            }

            result[i] = count;
        }

        return result;
    }

    public static int[] stockSpanOptimized(int[] array){
        int[] result = new int[array.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 1; i < array.length;i++){

            while (!stack.isEmpty() && array[stack.peek()] <= array[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                result[i] = i + 1;
            }else {
                result[i] = i - stack.peek();
            }

            stack.push(i);
        }

        return result;
    }

}
