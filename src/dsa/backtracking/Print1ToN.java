package dsa.backtracking;

public class Print1ToN {
    public static void main(String[] args) {

        print(10);
        printReverse(10);
    }

    public static void printReverse(int n) {
        if (n == 0) return;
        System.out.println(n);
        printReverse(n - 1);
    }

    public static void print(int n) {
        if (n == 0) return;
        print(n - 1);
        System.out.println(n);
    }
}
