package dsa.array;

// https://www.techiedelight.com/find-index-maximum-occurring-element-equal-probability/
public class MaxOccurringFirstIndex {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 3, 3};
        System.out.println(findMaxOccurringFirstIndex(arr));

    }

    private static int findMaxOccurringFirstIndex(int[] arr) {

        int maxFreq = 0;
        int index  = -1;
        int n = arr.length;
        for(int i = 0; i < n;i++){

            int freq = 0 ;
            for(int j = i+1; j < n;j++){
                if(arr[i] == arr[j]){
                    freq++;
                }
            }

            if(freq >maxFreq){
                maxFreq = freq;
                index = i;
            }
        }
        return index;
    }
}
