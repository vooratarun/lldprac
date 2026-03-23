package dsa.array;

public class ReplaceWithRank {

    public static void main(String[] args) {
        int[] arr = {40, 10, 20, 30};
        int n = arr.length;
        replaceWithRank(arr, n);
    }

    private static void replaceWithRank(int[] arr, int n) {
        int[] rankarray = new int[n];
        for(int i = 0; i< arr.length; i++){
            int rank = 1;
            for(int j = 0; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    rank++;
                }
            }
            rankarray[i] = rank;
        }

        printArray(rankarray);

    }

    public  static  void  printArray(int[] array) {
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
