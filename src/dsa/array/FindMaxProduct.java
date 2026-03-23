package dsa.array;

import java.util.Arrays;

import static java.lang.Long.MIN_VALUE;

// https://www.techiedelight.com/find-maximum-product-two-integers-array/
public class FindMaxProduct {

    public static void main(String[] args) {
        int[] arr = {-10, -3, 5, 6, -2};
        System.out.println(Arrays.toString(findMaxProduct(arr)));
    }

    private static int[] findMaxProduct(int[] arr) {

        int max = Integer.MIN_VALUE;
        int[] output = new int[2];

        for(int i = 0; i < arr.length;i++){
            for(int j= 0; j < arr.length;j++){
                if(i != j){
                    int product = arr[i] * arr[j];
                    if(product > max){
                        max = product;
                        output[0] = arr[i];
                        output[1] = arr[j];
                    }
                }
            }
        }

        return output;
    }
}
