package dsa.string;

public class StringCount {

    public static void main(String[] args) {
        String input = "This is interview session. This session starts at 2 pm. This is interactive session";

        String[] words = input.split(" ");


        for(int i = 0; i < words.length; i++){
            int count = 1;
            for(int j = i+1; j < words.length; j++){
                if(words[i].equals(words[j])){
                    count++;
                    words[j] = "";
                }
            }
            if(!words[i].isEmpty()){
                System.out.println(words[i] + " -> " + count);
            }
        }


    }
}
