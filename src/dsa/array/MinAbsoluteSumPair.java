package dsa.array;

// https://www.techiedelight.com/find-pair-array-minimum-absolute-sum/
public class MinAbsoluteSumPair {

    public static void main(String[] args) {
        int[] arr = {1, 60, -10, 70, -80, 85};
        findMinAbsSumPair(arr);
    }

    private static void findMinAbsSumPair(int[] arr) {

        int minSum = Integer.MAX_VALUE;

        for(int i =0;i< arr.length;i++){
            for(int j = i+1;j < arr.length;j++){
                int sum = Math.abs(arr[i] + arr[j]);
                if(sum < minSum){
                    minSum = sum;
                }
            }
        }

        System.out.println("Pair with minimum absolute sum:  Absolute Sum: " + minSum);

    }
}
