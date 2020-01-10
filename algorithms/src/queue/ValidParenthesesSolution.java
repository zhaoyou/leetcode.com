package queue;

import java.util.Stack;

public class ValidParenthesesSolution {
    public boolean isValid(String s) {
        if (s == null || "".equals(s)) return true;
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for(char c: arr) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}') {
                if (stack.isEmpty()) return false;
                if (!stack.pop().equals('{')) return false;
            } else if (c == ']') {
                if (stack.isEmpty()) return false;
                if (!stack.pop().equals('[')) return false;
            } else if (c == ')') {
                if (stack.isEmpty()) return false;
                if (!stack.pop().equals('(')) return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        if (s == null || "".equals(s)) return true;
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for(char c: arr) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else  {
                if (stack.isEmpty() || stack.pop() != 'c') return false;
            }
        }
        return stack.isEmpty();
    }
}
