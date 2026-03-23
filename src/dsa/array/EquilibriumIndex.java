package dsa.array;

// https://www.techiedelight.com/find-equilibrium-index-array/
public class EquilibriumIndex {

    public static void main(String[] args) {
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(findEquilibriumIndex(arr));
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
}
