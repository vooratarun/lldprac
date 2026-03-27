package dsa.slidingwindowbruteforce.variable;

public class maxSubArraySumZero {
    public static void main(String[] args) {

        int[] array = {1,2,3,-3,4};
        System.out.println(maxSubarraySumZero_brute(array));

    }

    public static int maxSubarraySumZero_brute(int[] arr) {
        int n = arr.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                int sum = 0;

                for (int x = i; x <= j; x++) {
                    sum += arr[x];
                }

                if (sum == 0) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    public static int maxSubarraySumZero_better(int[] arr) {
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;

            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum == 0) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
}
