package dsa.array;

// https://www.techiedelight.com/find-pairs-with-given-difference-array/
public class FindDiffK {

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2};
        int k = 2;
        findDiffK(arr, k);
    }

    private static void findDiffK(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println("Comparing: " + arr[i] + " and " + arr[j]);
                if (Math.abs(arr[i] - arr[j]) == k) {
                    System.out.println("Pair found: " + arr[i] + " and " + arr[j]);
                    return;
                }
            }
        }
    }


}
