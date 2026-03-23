package dsa.array;

import java.util.ArrayList;
import java.util.List;

// https://www.techiedelight.com/count-triplets-which-form-inversion-array/
public class findInversionCount {

    public static void main(String[] args) {
        int[] arr = {1, 20, 6, 4, 5};
        int count = countInversions(arr);
        System.out.println("Number of inversions: " + count);
    }

    private static int countInversions(int[] arr) {

        int inversionCount = 0;

        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < arr.length;i++){
            for(int j = i+1; j< arr.length;j++){
                for(int k = j+1; k < arr.length;k++){

                    if(arr[i] > arr[j] && arr[j] > arr[k]){
                        inversionCount++;
                        int[] triplet = {arr[i], arr[j], arr[k]};
                        list.add(triplet);
                    }
                }
            }
        }
        System.out.println("Triplets that form inversions: " + list.size());
        System.out.println("Triplets: " + list.stream().map(java.util.Arrays::toString).reduce((a, b) -> a + ", " + b).orElse(""));

        return inversionCount;
    }
}
