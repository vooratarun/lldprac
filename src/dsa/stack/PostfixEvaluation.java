package dsa.stack;

import java.util.Stack;

public class PostfixEvaluation {

    public static void main(String[] args) {
        String exp = "138*+";
        System.out.println(evalPostFix(exp));
    }

    public static int evalPostFix(String expr){

        Stack<Integer> stack = new Stack<>();

        for(char ch: expr.toCharArray()){
            if (Character.isDigit(ch)){
                System.out.println(ch);
                stack.push(Character.getNumericValue(ch));
            }else{
                int x = stack.pop();
                int y = stack.pop();

                if( ch == '+'){
                    stack.push(y + x);
                }
                else if( ch == '-'){
                    stack.push(y-x);
                }
                else if( ch == '*'){
                    stack.push(y*x);
                }
                else  if( ch == '/'){
                    stack.push(y/x);
                }
            }
        }
        return stack.pop();
    }
}
