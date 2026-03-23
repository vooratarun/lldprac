package dsa.array;

// https://www.techiedelight.com/partition-array-into-two-sub-arrays-with-same-sum/
public class PartitionSubarrary {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 5};
        System.out.println(canPartition(arr));

    }

    private static int canPartition(int[] arr) {


        for(int i = 0; i < arr.length;i++){
            int leftSum = 0;
            int rightSum = 0;

            for(int j = 0; j < i;j++){
                leftSum += arr[j];
            }

            for(int k =i; k < arr.length;k++){
                rightSum += arr[k];
            }

            if(leftSum == rightSum){
                return i;
            }
        }

        return -1;
    }
}
