package dsa.stack;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] array = {3,1,2,4,0,1,3,2};
        trap(array);
        trapOptimal(array);

    }

    public static void trap(int[] array){

        int water = 0;
        for(int i =0; i < array.length;i++){

            int maxLeft = 0;
            int maxRight = 0;

            for(int j= 0; j <=i;j++){
                maxLeft = Math.max(maxLeft, array[j]);
            }

            for(int k = i; k < array.length;k++){
                maxRight = Math.max(maxRight,array[k]);
            }

            water += Math.min(maxRight,maxLeft) - array[i];

        }
        System.out.println(water);
    }

    public static void trapOptimal(int[] array){

        int[] leftMax= new int[array.length];
        int[] rightMax = new int[array.length];

        leftMax[0] = array[0];
        for(int i =1; i < array.length;i++){
            leftMax[i] = Math.max(leftMax[i-1], array[i]);
        }

        rightMax[array.length -1] = array[array.length -1];
        for(int i = array.length -2;i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1],array[i]);
        }

        int water = 0;
        for(int i =0; i < array.length;i++){
            water += Math.min(leftMax[i],rightMax[i]) - array[i];
        }
        System.out.println(water);
    }

}
