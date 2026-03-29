package dsa.dnc;


import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] array = {4,1,3,1,34,4,2,22,3};
        mergeSort(array,0, array.length -1);
        System.out.println(Arrays.toString(array));
    }

    static void mergeSort(int [] array, int l, int r){
        if(l  >= r) return;

        int mid =  (l + r)/2;

        mergeSort(array,l,mid);
        mergeSort(array,mid+1,r);

        merge(array,l,mid,r);

    }

    static private void merge(int[] array, int l, int mid, int r) {

        int n1 = mid -l +1;
        int n2 = r-mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i= 0; i < n1;i++){
            left[i] = array[l + i];
        }

        for(int j = 0; j <n2;j++){
            right[j] = array[mid + 1 +j];
        }

        int i =0,j=0,k = l;

        while (i < n1 && j < n2){
            if(left[i] <= right[j]){
                array[k] = left[i];
                k++;
                i++;
            }else {
                array[k]= right[j];
                k++;
                j++;
            }
        }

        while (i < n1){
            array[k] = left[i];
            k++;
            i++;

        }

        while (j < n2){
            array[k] = right[j];
            k++;
            j++;
        }

    }

}
