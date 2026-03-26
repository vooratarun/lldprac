package dsa.recursion;

public class Arrays {

    public static void main(String[] args) {

        int[] array = {21,11,23,4};
//        printArray(array,0);
//        System.out.println();
//        reversePrintArray(array,array.length -1);
//        System.out.println();
//        System.out.println(sumArray(array,0,0));
//        System.out.println(sum(array,0));
//        System.out.println(findMax(array,0));
//        System.out.println(findMin(array,0));

//        System.out.println(checkArraySorted(array,0));
//        System.out.println(linearSearch(array,0,4));

//        System.out.println(firstOccurence(array,0,2));
//        System.out.println(lastOccurence(array, array.length-1,1));
//        System.out.println(checkPalindrome(array,0,array.length-1));
        //System.out.println(binarySearch(array,3,0, array.length));
        recursiveSelectionSort(array,0);
        System.out.println(java.util.Arrays.toString(array));

        System.out.println(findMinIndex(array,0));

    }

    public static void printArray(int[] array,int i){
        if(array.length == i)return;
        System.out.print(array[i]+" ");
        printArray(array,i+1);

    }

    public static void reversePrintArray(int[] array,int i){
        if(i < 0) return;
        System.out.print(array[i] + " ");
        reversePrintArray(array,i-1);
    }

    public static int sumArray(int[ ] array,int i, int sum){
        if(array.length == i ) return sum;

        return  array[i] + sumArray(array,i+1,sum);
    }

    public static int sum(int[]array, int i){
        if(i== array.length) return 0;
        return array[i] + sum(array,i+1);
    }

    public static int findMax(int[] array,int i){

        if(i == array.length-1) return array[i];
        int ele = findMax(array,i+1);
        return  Math.max(ele,array[i]);
    }

    public static int findMin(int[] array, int i){
        if(i == array.length -1)return array[i];

        int ele = findMin(array,i+1);
        return  Math.min(ele, array[i]);
    }

    //array = [1,2,3,4]

    public static boolean checkArraySorted(int[] array, int i){
        if(array.length -1 == i) return true;

        if(array[i] > array[i+1]) return false;

        return checkArraySorted(array,i+1);
    }

    public static int linearSearch(int[]array, int i , int target){

        if(i== array.length) return -1;
        if(array[i] == target) return i;

        return  linearSearch(array,i+1, target);
    }

    public static int firstOccurence(int[] array, int i, int ele){

        if(array.length == i) return -1;

        if(array[i]== ele) return  i;

        return firstOccurence(array,i+1,ele);

    }
    public static int lastOccurence(int[] array, int i, int ele){

        if(i < 0 ) return -1;

        if(array[i]== ele) return  i;

        return lastOccurence(array,i-1,ele);

    }

    public static int lastIndex(int[] arr, int index, int target) {
        if (index == arr.length) return -1;

        int res = lastIndex(arr, index + 1, target);

        if (res != -1) return res;

        if (arr[index] == target) return index;

        return -1;
    }

    public static void reverse(int[] arr, int left, int right) {
        if (left >= right) return;

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        reverse(arr, left + 1, right - 1);
    }

    public static int count(int[] arr, int index, int target) {
        if (index == arr.length) return 0;

        int count = (arr[index] == target) ? 1 : 0;

        return count + count(arr, index + 1, target);
    }
    public static void printReverse(int[] arr, int index) {
        if (index == arr.length) return;

        printReverse(arr, index + 1);
        System.out.print(arr[index] + " ");
    }


    public static boolean checkPalindrome(int[] array, int left, int right){

        if(left >= right) return  true;
        if(array[left] != array[right])return  false;
        return checkPalindrome(array,left +1, right -1);

    }

    // 1,2,3,4,  mid=5, 6,7,8,9
    public static int binarySearch(int[] array,int target,int low, int high){

        if(low > high) return  -1;

        int mid = (low + high)/2;

        if(array[mid] == target) return mid;
        else if(array[mid] < target)
            return  binarySearch(array,target,mid+1, high);
        else
            return  binarySearch(array,target,low,mid -1);
    }

    public static void recursiveSelectionSort(int[] array, int i){

        if(array.length == i) return;
//        int minIndex = i;
//        for(int j = i + 1; j < array.length;j++){
//            if(array[j] < array[minIndex]){
//                minIndex = j;
//            }
//        }
        int minIndex = findMinIndex(array,i);

        int temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = temp;

        recursiveSelectionSort(array,i+1);

    }

    public static int findMinIndex(int[] array,int i){

        if(array.length -1 ==i) return i;

        int minIndex = findMinIndex(array,i+1);
        if(array[i] < array[minIndex])
            return i;
        else
            return minIndex;
    }

}
