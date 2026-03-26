package dsa.slidingwindowbruteforce.variable;

public class LongestSubArrayEvenOdd {

    public static void main(String[] args) {

    }

    public static int longestEvenOdd(int[] arr) {
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            int even = 0, odd = 0;

            for (int j = i; j < arr.length; j++) {
                if (arr[j] % 2 == 0) even++;
                else odd++;

                if (even == odd) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
}
