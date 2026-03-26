package dsa.binarysearch;

public class CountOCurences {

    public static void main(String[] args) {

        //  1,2,3,4,5,6,7,8

        int[] array = {1,2,2,2,2,2,3,4,5,6,7};

        System.out.println(firstOccurrence(array,2));
        System.out.println(lastOccrence(array,2));

        System.out.println(lastOccrence(array,2)- firstOccurrence(array,2)+ 1);
        System.out.println(countOccurences(array,2));


    }

    public static int firstOccurrence(int[] arr, int target) {

        int low =0;
        int high = arr.length -1;
        int ans  = -1;

        while (low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                ans = mid;
                high = mid -1;
            }else if (arr[mid] > target){
                    high = mid -1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static int lastOccrence(int[] arr, int target){
        int low = 0;
        int high = arr.length -1;
        int ans = -1;

        while (low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] == target){
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] > target){
                high = mid -1;
            }else{
                low = mid + 1;
            }

        }
        return ans;
    }

    // 1,2,3,4,5,6,7,8,9

    public static int countOccurences(int[] arr, int target){

        int count = 0;
        for (int ele : arr) {
            if (ele == target) {
                count++;
            }
        }
        return count;
    }
}
