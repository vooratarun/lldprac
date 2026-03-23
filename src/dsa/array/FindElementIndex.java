package dsa.array;


// https://www.techiedelight.com/determine-index-element-array/
public class FindElementIndex {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int index = findElementIndex(arr);
        if (index != -1) {
            System.out.println("Element  found at index: " + index);
        } else {
            System.out.println("Element  not found in the array.");
        }
    }

    private static int findElementIndex(int[] arr) {

        int n = arr.length;

        for(int i = 1; i < n-1;i++){

            boolean leftSmaller = true;
            boolean rightGreater = true;

            for(int j = 0; j <i;j++){
                if(arr[j] > arr[i]){
                    leftSmaller = false;
                    break;
                }
            }

            for(int j = 1+1; j < n;j++){
                if(arr[j] <arr[i]){
                    rightGreater = false;
                    break;
                }
            }

            if(leftSmaller && rightGreater)
                return i;

        }

        return  -1;
    }
}
