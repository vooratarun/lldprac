package dsa.slidingwindow.fixed;

public class WhileLoop {

    public static void main(String[] args) {
        int[] array =  {1,2,3,4,5,6};

        int i =0;
        while (i < array.length){
            System.out.print(array[i] + " ") ;
            i++;
        }
        System.out.println();

        int j = array.length -1;
        while (j>=0){
            System.out.print(array[j] + " ");
            j--;
        }
    }
}
