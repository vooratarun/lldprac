package dsa.dp;


// https://chatgpt.com/c/69c8f79f-2874-8323-906c-ec39fb290e92
public class LongestIncreasingSubseq {

    public static void main(String[] args) {

    }

    public static int lis(int[] array, int index,int prevIndex){
        if(index == array.length) return  0;

        int notTake = lis(array,index+1,prevIndex);

        int take = 0;

        if(prevIndex == -1 || array[index] > array[prevIndex]){
            take = 1+ lis(array,index+1, index);
        }

        return Math.max(take, notTake);
    }

}
