package dsa.array;

public class FrequencyCount {
    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 10, 10, 20, 5, 20};
        int n = arr.length;
        frequencyCount(arr, n);
    }

    private static void frequencyCount(int[] arr, int n) {

        boolean visited[] = new boolean[n];


        for( int i = 0; i < arr.length; i++){
            if(visited[i]){
                continue;
            }

            int count =0;
            for( int j = 0; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    visited[j] = true;
                    count++;
                }
            }

            System.out.println(arr[i] + "-> " + count);
        }
    }
}
