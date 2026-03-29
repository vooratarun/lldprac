package dsa.dp;

// https://chatgpt.com/c/69c8a9ed-c9d0-8324-82dd-ccd4afe6fd7f

public class ClimbingStairs {
    public static void main(String[] args) {

        int n = 1;
        System.out.println(climbStairsForward(n));

    }

    public static int climbStairsForward(int n) {
        return helper(0, n);
    }

    private static int helper(int i, int n) {
        if (i == n) return 1;
        if (i > n) return 0;

        int value = helper(i + 1, n) + helper(i + 2, n);
        System.out.println("Helper(" + i+") = "+ value);
        return value;
    }

    public int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // no of ways to reach step 5 = no.of ways to reach step 4 + no.of ways to reach step 3

    //f(5) = f(4) + f(3);

    //f(4) = f(3) + f(2);

    // f(3) = f(2) + f(1);

    // f(2) = 2 ;
    // f(1) = 1;
    /*


                                f(4)
                         /       \
                     f(3)         f(2)
                   /     \       /     \
               f(2)     f(1)  f(1)   f(0)
              /   \
          f(1)   f(0)



     */


    //========= another way

    /*

                                 0
                         /       \
                       1           2
                     /   \       /   \
                   2     3     3     4
                 /   \     \      \
               3     4     4      (end)
             /   \
           4     5


     */


}
