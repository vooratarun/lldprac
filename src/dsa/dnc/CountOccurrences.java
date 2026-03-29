package dsa.dnc;

public class CountOccurrences {

    public static int count(int[] arr, int l, int r, int target) {

        // Base case
        if (l == r) {
            return arr[l] == target ? 1 : 0;
        }

        int mid = (l + r) / 2;

        // Divide + Conquer
        int leftCount = count(arr, l, mid, target);
        int rightCount = count(arr, mid + 1, r, target);

        return leftCount + rightCount;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 4, 2};
        int target = 2;

        System.out.println(count(arr, 0, arr.length - 1, target));
    }
}