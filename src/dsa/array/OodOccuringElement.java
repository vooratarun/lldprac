package dsa.array;

public class OodOccuringElement {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 2, 1, 3, 4};
        int oddOccuringElement = findOddOccuringElement(arr);
            System.out.println(oddOccuringElement);
    }

    private static int findOddOccuringElement(int[] arr) {

        for(int i =0; i < arr.length;i++){
            int count = 0;
            for(int j = 0; j < arr.length;j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }

            if(count % 2 != 0){
                return arr[i];
            }
        }

        return -1;
    }
}
