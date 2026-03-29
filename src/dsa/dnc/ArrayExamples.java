package dsa.dnc;

public class ArrayExamples {

    public static void main(String[] args) {

        int[] array = {1,2,-3,4,5,6,17,8};
        System.out.println(findMax(array,0,array.length -1));
        System.out.println(findMin(array,0,array.length -1));
        System.out.println(sum(array,0,array.length -1));

    }

    static int findMax(int[] array, int l,int r){
        if (l == r) return array[l];

        int mid = (l + r)/2;

        return Math.max(
                findMax(array,l,mid),
                findMax(array,mid +1, r)
        );
    }

    static int findMin(int[] array, int l, int r){

        if(l==r) return array[l];
        int mid = (l + r)/2;

        return Math.min(
                findMin(array,l,mid),
                findMin(array,mid+1, r)
        );

    }

   static int sum(int[] arr, int l, int r) {
        if (l == r) return arr[l];

        int mid = (l + r) / 2;

        return sum(arr, l, mid) + sum(arr, mid + 1, r);
    }


}
