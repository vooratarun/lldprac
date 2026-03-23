package dsa.array;
// https://www.techiedelight.com/find-minimum-index-repeating-element-array/
public class FindMinIndexOfRepeatEle {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 5};
        System.out.println(findMinIndexOfRepeatEle(arr));
    }

    private static int findMinIndexOfRepeatEle(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return i;
                }
            }
        }

        return -1;

    }
}
