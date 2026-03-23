package dsa.array;

import java.util.ArrayList;
import java.util.List;

//https://www.techiedelight.com/find-duplicates-within-given-range-array/
public class DuplicateWithinK {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5};
        int k = 3;
        printWindows(arr, k);
        List<int[]> list = getWindows(arr, k);
        for(int[] window: list){
            System.out.println("Window: " + java.util.Arrays.toString(window));
        }
        System.out.println(checkDuplicates(list));
        System.out.println(checkDuplicatesNew(list));
    }

    private static void printWindows(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i <= n - k - 1; i++) {

            System.out.print("Window: ");

//            for (int j = i; j <= i + k; j++) {
//                System.out.print(arr[j] + " ");
//            }

            for(int  j = 0; j <= k; j++){
                System.out.print(arr[i + j] + " ");
            }

            System.out.println();
        }
    }

    public static List<int[]> getWindows(int[] arr, int k){

        int n  = arr.length;
        List<int[]> windows = new ArrayList<>();

        for(int i = 0; i <= n - k -1;i++){

            int[] window = new int[k+1];
            for (int j = 0; j <= k; j++) {
                window[j] = arr[i + j];
            }

            windows.add(window);

        }
        return  windows;
    }

    public static boolean checkDuplicates(List<int[]> windows) {

        for(int[] window : windows){
            java.util.Arrays.sort(window);
            for(int i = 1; i < window.length; i++){
                if(window[i] == window[i-1]){
                    return true;
                }
            }
        }

        return  false;
    }


    public static List<int[]>getWindowsNew(int[] arr, int k){
       int n = arr.length;
         List<int[]> windows = new ArrayList<>();
         for(int i = 0; i < n-k-1;i++){
             int[] window = new int[k+1];
             for(int j =0; j <=k;j++){
                 window[j] = arr[i + j];
             }
         }
         return windows;
    }

    public static boolean  checkDuplicatesNew(List<int[]> windows){

        for(int[] window : windows){

            for(int i = 0; i < window.length;i++){
                for(int j = i + 1; j < window.length;j++){
                    if(window[i] == window[j]){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

