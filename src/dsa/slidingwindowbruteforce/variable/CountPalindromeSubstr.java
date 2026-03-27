package dsa.slidingwindowbruteforce.variable;

public class CountPalindromeSubstr {
    public static void main(String[] args) {

        String str = "ab";
        System.out.println(countPalindromes(str));

    }

    public static int countPalindromes(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {

                if (isPalindrome(s, i, j)) {
                    printString(s,i,j);
                    count++;
                }
            }
        }
        return count;
    }


    static void printString(String s ,int i, int j){

        for(int k = i; k <= j;k++){
            System.out.print(s.charAt(k));
        }
        System.out.println();
    }

    static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
