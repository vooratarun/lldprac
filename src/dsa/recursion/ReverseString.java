package dsa.recursion;

public class ReverseString {

    public static void main(String[] args) {
        String str = "abcde";
        char[] chars = str.toCharArray();
        Reverse(chars,0, str.length() -1);
        System.out.println(chars);
    }

    public static void Reverse(char[] chars, int i, int j){
        if(i > j) return;

        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;

        Reverse(chars,i+1, j-1);

    }
}
