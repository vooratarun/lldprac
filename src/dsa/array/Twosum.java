package dsa.array;

public class Twosum {


    public static void main(String[] args) {
        int[] arr = {2, 17, 11, 15};
        int target = 19;
        int[] result = twoSum(arr, target);
        if(result != null) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two sum solution found.");
        }
    }

    private static int[] twoSum(int[] arr, int target) {

        int[] output= null;
        for(int i = 0; i < arr.length;i++){
            for(int j =0; j < arr.length;j++) {
                if(i != j && arr[i] + arr[j] == target){
                    output = new int[2];
                    output[0] = i;
                    output[1] = j;
                    return output;
                }
            }
        }

        return output;
    }

    private static  int[] twoSumSorted(){

        int[] output = null;


        return null;
    }

}

