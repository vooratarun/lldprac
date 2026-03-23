package dsa.string;

public class StringRotation {

    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "CDAB";

        if(s1.length() != s2.length()){
            System.out.println("Not a rotation");
        } else {

            int n = s1.length();
            String temp = s1;
            for(int i =0;i <n ;i++){
                temp = temp.substring(1) + temp.charAt(0);
                System.out.println(temp);

                if(temp.equals(s2)){
                    System.out.println("Rotation");
                    return;
                }
            }
        }

    }
}
