package dsa.slidingwindowbruteforce.fixed;

public class MaxVowelsInSubstring {


    public static void main(String[] args) {

        String s = "aeee";
        maxVowels(s,2);
    }

    public static void  maxVowels(String str, int k){

        int n = str.length();
        int i = 0;
        int max = 0;
        while (i <= n - k){

            int j = i;
            int count = 0;
            while (j < i + k){
                char c = str.charAt(j);

                if("aeiou".indexOf(c) != -1){
                   count++;
                }
                j++;
            }
            max = Math.max(max, count);
            i++;
        }

        System.out.println(max);
    }
}
