package dsa.array;

// https://www.techiedelight.com/find-equilibrium-index-array/
public class EquilibriumIndex {

    public static void main(String[] args) {
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(findEquilibriumIndex(arr));
        System.out.println(findEquilibrium(arr));
    }

    private static int findEquilibriumIndex(int[] arr) {


        for(int i = 0; i < arr.length;i++){
            int leftSum  = 0;
            int rightSum = 0;
            for(int j = 0; j<i;j++){
                leftSum += arr[j];
            }

            for(int k = i+1; k < arr.length;k++){
                rightSum += arr[k];
            }

            if(leftSum == rightSum)
                return i;
        }

        return -1;
    }

    public static int findEquilibrium(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }

}
