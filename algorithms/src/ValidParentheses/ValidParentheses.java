package ValidParentheses;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        System.out.println("(): " + v.isValid("()"));
        System.out.println("()[]{}: " + v.isValid("()[]{}"));
        System.out.println("(]: " + v.isValid("(]"));
        System.out.println("([)]: " + v.isValid("([)]"));
        System.out.println("{[]}: " + v.isValid("{[]}"));
        System.out.println("}: " + v.isValid("}"));

    }

    public boolean isValid2(String s) {
        if (s.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (isBegin(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) return false;
                if (!isMatch(stack.pop(), s.charAt(i))) return false;  
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid(String s) {

        if (s.isEmpty()) return true;

        StringBuffer sb = new StringBuffer("");


        for (int i = 0; i < s.length(); i++) {
            if (isBegin(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else {
                if (sb.toString().isEmpty()) return false;

                if (isMatch(sb.substring(sb.length() - 1, sb.length()).charAt(0), s.charAt(i))) {
                    sb = new StringBuffer(sb.substring(0, sb.length() - 1));
                } else {
                    return false;
                }
            }
        }

        System.out.println("sb: " + sb.toString());
        return sb.toString().isEmpty();
    }

    public boolean isMatch(char c, char e) {
        switch(c) {
            case '(':
                return e == ')';
            case '[':
                return e == ']';
            case '{':
                return e == '}';
        }
        return false;
    }

    public boolean isBegin(char c) {
        return c == '{' || c == '[' || c == '(';
    }
}