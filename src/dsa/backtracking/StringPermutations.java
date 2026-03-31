package dsa.backtracking;

// https://www.youtube.com/watch?v=va3NEycUxsg
public class StringPermutations {

    static char[] chararray = {'a','b','c','d'};
    public static void main(String[] args) {
//        String str = "abc";
       // System.out.println("permuteRecurse(0)");
        permute( 0);
    }

    public static void permute(int index) {

//        System.out.print("permuteBase(" + (index)+")");
//        System.out.println();

        // Base case
        if (index == chararray.length) {
            System.out.println(new String(chararray));
            return;
        }

        for (int i = index; i < chararray.length; i++) {

            // Choose (swap)
//            System.out.print("      swap(" + index + "," +i + ")");
//            System.out.println();
            swap(index, i);

            // Explore
//            System.out.print("      permuteRecurse(" + (index + 1)+")");
//            System.out.println();

            permute(index + 1);
//            System.out.print("      swap(" + index + "," +i + ")");
//            System.out.println();
            // Backtrack (undo swap)
            swap( index, i);
        }
    }

    public static void swap( int i, int j) {
        char temp = chararray[i];
        chararray[i] = chararray[j];
        chararray[j] = temp;
       // System.out.println(chararray);
    }
}