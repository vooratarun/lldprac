package dsa.binarysearch;

public class FloorOfArray {

    public static void main(String[] args) {

       int[] array = {2, 4, 6, 8};
        int target = 5;

        System.out.println(FloorOfArray(array,target)); //maximum element less than target

        System.out.println(CielOfArray(array,target));

    }

    public static int FloorOfArray(int[] array , int target){

        int floor = -1;
        for(int i = 0; i < array.length;i++){
            if(array[i] <= target){
                if(floor == -1 || array[i] > floor){
                    floor = array[i];
                }
            }
        }
        return floor;
    }


    public static int CielOfArray(int[] array , int target){

        int ciel = -1;
        for(int i = 0; i < array.length;i++){
            if(array[i] >= target){
                if(ciel == -1 || array[i] < ciel){
                    ciel = array[i];
                }
            }
        }
        return ciel;
    }

    public static int floorBs(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= target) {
                ans = arr[mid];
                low = mid + 1; // try bigger
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int ceilBs(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                ans = arr[mid];
                high = mid - 1; // try smaller
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
