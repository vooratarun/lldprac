package dsa.stack;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        String exp = "{()}[{}]";

        if (isValid(exp)) {
            System.out.println("The expression is balanced");
        }
        else {
            System.out.println("The expression is not balanced");
        }
    }

    public  static  boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                st.push(c);
            else {
                if (st.isEmpty()) return false;
                char top = st.pop();

                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '['))
                    return false;
            }
        }
        return st.isEmpty();
    }
}
