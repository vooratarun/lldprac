package dsa.binarysearch;

public class BinarySearch {

    public static void main(String[] args) {

        // 1,2,3,4,5,6
        int[] array =  {1,2,3,4,5,6};

        System.out.println(binarySearch(array,19));
    }

    public static int binarySearch(int[] array, int target){

        int left = 0;
        int right = array.length -1;
        while (left <= right){
            int mid =  (left + right)/2;
            if(array[mid] == target){
                return  mid;
            }else if (array[mid] > target){
                right = mid -1;
            }else {
                left = mid + 1;
            }

        }
        return -1;
    }

}
