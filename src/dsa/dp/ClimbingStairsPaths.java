package dsa.dp;

public class ClimbingStairsPaths {

    public static void main(String[] args) {
        int n = 3;
        printPaths(0, n, "");
    }

    public static void printPaths(int i, int n, String path) {
        // reached destination
        if (i == n) {
            System.out.println(path);
            return;
        }

        // invalid case
        if (i > n) return;

        // take 1 step
        printPaths(i + 1, n, path + "1");

        // take 2 steps
        printPaths(i + 2, n, path + "2");
    }
}