package dsa.dp;

import java.util.Arrays;

// https://chatgpt.com/c/69c8b8cd-c338-8323-bdc7-84c51a9b490f
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] array = {10,15,20};
        System.out.println(minCostClimbingStairs(array));

    }

    // recursive solution

    // array = [10, 15,20]
    /*

    solve(0)
│
├── solve(1)
│   │
│   ├── solve(2)
│   │   │
│   │   ├── solve(3) → 0 (top)
│   │   └── solve(4) → 0
│   │
│   └── solve(3) → 0
│
└── solve(2)
    │
    ├── solve(3) → 0
    └── solve(4) → 0
     */


    public static int solve(int i, int[] cost) {

        if(i >= cost.length) {
            System.out.print("function solve(" +i + ")");
            int total = 0;
            System.out.print(" total: " + total);
            System.out.println();
            return 0;
        };
        int oneStep = solve(i+1, cost);
        int twoStep = solve(i+2, cost);

        System.out.print("function solve(" +i + ")");
        System.out.print("function solve(" +(i +1)+ ")");
        System.out.print(" function solve(" +(i +2)+ ")");

        int total = cost[i] + Math.min(oneStep,twoStep);
        System.out.print(" total: " + total);
        System.out.println();
        return  total;
    }

    public static  int minCostClimbingStairs(int[] cost) {
        // Try starting from step 0 and step 1
        return Math.min(
                solve(0, cost),
                solve(1, cost)
        );
    }


//    public int solveMemo(int i, int[] cost, int[] dp) {
//        // Base case
//        if (i >= cost.length) return 0;
//
//        // If already computed → reuse
//        if (dp[i] != -1) return dp[i];
//
//        // Compute and store
//        int oneStep = solveMemo(i + 1, cost, dp);
//        int twoStep = solveMemo(i + 2, cost, dp);
//
//        return dp[i] = cost[i] + Math.min(oneStep, twoStep);
//    }
//
//    public int minCostClimbingStairsMemo(int[] cost) {
//        int n = cost.length;
//        int[] dp = new int[n];
//        Arrays.fill(dp, -1);
//
//        return Math.min(
//                solveMemo(0, cost, dp),
//                solveMemo(1, cost, dp)
//        );
//    }

    // another approach

    // minimum cast to reach top N
    // minimum_cost_to_reach_n = Min(cost[n-1]+ minCost(n-1), cost[n-2] + minCost(n-2));



}
