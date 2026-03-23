package dsa.array;

public class PrintSubSets {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        printSubSets(arr);
    }

    private static void printSubSets(int[] arr) {
        int n = arr.length;
        int totalSubsets = (int) Math.pow(2, n);

        for (int i = 0; i < totalSubsets; i++) {
            System.out.print("{ ");
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println("}");
        }
    }

    public static void printSubSetsRecursive(int[] arr) {
        printSubSetsRecursiveHelper(arr, 0, new int[arr.length], 0);
    }

    private static void printSubSetsRecursiveHelper(int[] arr, int i, int[] ints, int i1) {
        if (i == arr.length) {
            System.out.print("{ ");
            for (int j = 0; j < i1; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println("}");
            return;
        }

        // Include the current element
        ints[i1] = arr[i];
        printSubSetsRecursiveHelper(arr, i + 1, ints, i1 + 1);

        // Exclude the current element
        printSubSetsRecursiveHelper(arr, i + 1, ints, i1);
    }
}
