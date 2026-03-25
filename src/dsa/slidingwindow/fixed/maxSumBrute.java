package dsa.slidingwindow.fixed;

public class maxSumBrute {

    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(maxSum(arr,k));
    }

    public static int maxSum(int[] array,int k){
//        int maxSum = Integer.MIN_VALUE;
//        for(int i =0;i<=array.length-k;i++){
//            int sum = 0;
//            for(int j = i; j < i + k;j++){
//                sum += array[j];
//            }
//
//            if(sum  > maxSum){
//                maxSum = sum;
//            }
//        }
//        return maxSum;

        int maxSum = Integer.MIN_VALUE;
        int i = 0;
        while (i < array.length -k){

            int sum = 0;
            int j = i;
            while (j< i + k){
                sum += array[j];
                j++;
            }
            i++;
            maxSum = Math.max(sum,maxSum);
        }
        return  maxSum;
    }


}
