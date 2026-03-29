package dsa.dp;

import java.util.*;

public class MinCostPath {

    public static int solve(int i, int[] cost, int[] dp, int[] next) {
        if (i >= cost.length) return 0;

        if (dp[i] != -1) return dp[i];

        int one = solve(i + 1, cost, dp, next);
        int two = solve(i + 2, cost, dp, next);

        if (one <= two) {
            next[i] = i + 1;
            dp[i] = cost[i] + one;
        } else {
            next[i] = i + 2;
            dp[i] = cost[i] + two;
        }

        return dp[i];
    }

    public static void printPath(int start, int[] next, int n) {
        System.out.print("Path: ");
        int i = start;

        while (i < n) {
            System.out.print(i + " ");
            i = next[i];
        }

        System.out.println("TOP");
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20,25};
        int n = cost.length;

        int[] dp = new int[n];
        int[] next = new int[n];
        Arrays.fill(dp, -1);

        int cost0 = solve(0, cost, dp, next);
        int cost1 = solve(1, cost, dp, next);

        if (cost0 <= cost1) {
            System.out.println("Min Cost: " + cost0);
            printPath(0, next, n);
        } else {
            System.out.println("Min Cost: " + cost1);
            printPath(1, next, n);
        }
    }
}