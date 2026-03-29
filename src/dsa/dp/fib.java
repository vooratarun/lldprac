package dsa.dp;

public class fib {

    public static void main(String[] args) {

        System.out.println(fibonacci(10));
        //0 ,1,1,2,3,5,8,13,21,43,

        System.out.println(fibforward(10));

    }

    public static int fibonacci(int n){

        if(n == 0) return 0;
        if(n ==1) return 1;
        return fibonacci(n-1 )+ fibonacci(n-2);

    }
    public static int fibMemo(int n, int[] dp){
        if( n<=1) return n;

        if(dp[n] != -1) return dp[n];
        dp[n] = fibMemo(n-1,dp) + fibMemo(n-2,dp);

        return dp[n];

    }


    public static int fibforward(int n) {
        return fibnocciForwardDP(0, n);
    }
    public static int fibnocciForwardDP(int i, int n) {

        if(i == n) return 1;
        if( i > n) return 0;
        return  fibnocciForwardDP(i +1,n) + fibnocciForwardDP(i+2,n);
    }

}
