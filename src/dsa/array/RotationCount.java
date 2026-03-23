package dsa.array;

public class RotationCount {

    public static void main(String[] args) {
        int[] arr = {15, 18, 2, 3, 6, 12};
        int rotationCount = findRotationCount(arr);
        System.out.println("Array is rotated " + rotationCount + " times.");
    }

    private static int findRotationCount(int[] arr) {

        int min = arr[0];
        int minIndex = 0;

        for(int i = 1; i < arr.length;i++){

            if(arr[i] < min){
                min = arr[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}
