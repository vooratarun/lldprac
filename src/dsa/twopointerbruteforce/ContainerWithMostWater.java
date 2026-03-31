package dsa.twopointerbruteforce;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxAreaBruteForce(height));
        System.out.println(maxAreaOptimized(height));
    }

    public static int maxAreaBruteForce(int[] heights){
        int maxWater = 0;

        for(int i = 0; i < heights.length;i++){
            for( int j = i +1; j < heights.length;j++){
                int width = j -i;
                int minHeight = Math.min(heights[i],heights[j]);
                int water = width * minHeight;

                maxWater = Math.max(maxWater,water);
            }
        }
        return maxWater;
    }

    public static int maxAreaOptimized(int[] heights){
       int maxWater= 0;
       int left =0;
       int right =  heights.length -1;

       while (left < right){

           int width = right - left;
           int minHeight = Math.min(heights[left],heights[right]);
           int water = width * minHeight;
           maxWater = Math.max(maxWater, water);

           if(heights[left] <heights[right]){
               left++;
           }else{
               right--;
           }
       }

        return maxWater;
    }
}
