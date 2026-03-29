package dsa.dp;

// https://chatgpt.com/c/69c8e90f-9154-8321-b456-a66e3bd1536f
public class HouseRobber {
    public static void main(String[] args) {
        int[] array = {10,15,20};
        System.out.println(robOne(array));
        System.out.println(robTwo(array));

    }

    public static int robOne(int[] array) {
        return helper(array, 0,array.length -1 );
    }

    public static int robTwo(int[] array) {
         int n = array.length;
         int case1 = helper(array, 0,n-2 );
         int case2 = helper(array,1, n-1);
        return Math.max(case1, case2);
    }


    public static int helper(int[] array,int i, int end){

        if(i > end ) return 0;

        int rob = array[i] + helper(array,i+2,end);
        int skip = helper(array,i+ 1,end);

        return Math.max(rob,skip);
    }
}
