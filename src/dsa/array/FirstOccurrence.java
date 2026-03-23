package dsa.array;

public class FirstOccurrence {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 5, 6};
        int target = 5;
        int index = firstOccurrence(arr, target);
        int lastIndex = lastOccurrence(arr, target);
        System.out.println("First occurrence of element " + target + " is at index: " + index);
        System.out.println("Last occurrence of element " + target + " is at index: " + lastIndex);

    }

    private static int firstOccurrence(int[] arr, int target) {

        for(int i =0;i < arr.length;i++){
            if(arr[i]== target){
                return i; // Return the index of the first occurrence
            }
        }

        return -1;

    }

    private static int lastOccurrence(int[] arr, int target){

        int index = -1;
        for(int i = 0; i< arr.length;i++){
            if(arr[i] == target){
                index = i; // Update the index to the current occurrence
            }
        }

        return index;
    }

}
