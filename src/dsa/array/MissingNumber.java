package dsa.array;

public class MissingNumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6};
        int missingNumber = findMissingNumber(arr);
        System.out.println("Missing number: " + missingNumber);
    }

    private static int findMissingNumber(int[] arr) {
        int n = arr.length; // Since one number is missing
       for(int i = 1; i < n;i++){
           boolean found = false;
           for(int j =0; j < n;j++){

               if(arr[j] == i){
                   found = true;
                   break;
               }

           }
          if(!found){
            return i;
          }
       }
       return -1;

    }
}
