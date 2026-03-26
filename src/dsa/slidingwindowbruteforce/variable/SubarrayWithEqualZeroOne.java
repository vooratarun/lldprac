package dsa.slidingwindowbruteforce.variable;

public class SubarrayWithEqualZeroOne {
    public static void main(String[] args) {

        int[] array = {1,0,1};
        System.out.println(equal01_brute(array));
    }

    public static int equal01_brute(int[] arr) {
        int n = arr.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int zeros = 0, ones = 0;

            for (int j = i; j < n; j++) {
                if (arr[j] == 0) zeros++;
                else ones++;

                if (zeros == ones) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
}
