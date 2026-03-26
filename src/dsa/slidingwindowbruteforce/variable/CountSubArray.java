package dsa.slidingwindowbruteforce.variable;

public class CountSubArray {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,5};
        System.out.println(countSubarrays(array,10));
    }

    public static int countSubarrays(int[] arr, int k) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += arr[j];

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
