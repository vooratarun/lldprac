package dsa.stack;

import java.util.Arrays;
import java.util.Stack;


// NGL => Next Greater Element to Left (NGL)
public class NextGreaterElementToLeft {
    public static void main(String[] args) {

        int[] array = {4,5,2,10,8};
        System.out.println(Arrays.toString(NextGreaterElementToLeft(array)));
        System.out.println(Arrays.toString(NextGreaterElementToLeftBrute(array)));


    }

    public static int[] NextGreaterElementToLeft(int[] array){

        Stack<Integer> s= new Stack<>();
        int[] result = new int[array.length];

        for(int i =0; i< array.length;i++){

            int ele = array[i];
            while (!s.isEmpty() && s.peek() <= ele) {
                s.pop();
            }
            if(s.isEmpty()){
                result[i] = -1;

            }else {
                result[i] = s.peek();
            }
            s.push(ele);
        }

        return  result;

    }
    public static int[] NextGreaterElementToLeftBrute(int[] array){
        int[] result  = new int[array.length];


        for(int i = 0;i< array.length;i++){
            result[i] = -1;

            int ele = array[i];

            for(int j =i-1; j>=0;j--){

                if(array[j] > ele){
                    result[i] = array[j];
                    break;
                }
            }
        }

        return result;
    }

}
