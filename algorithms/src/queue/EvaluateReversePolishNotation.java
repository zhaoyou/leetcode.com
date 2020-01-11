package queue;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for(String str: tokens) {
            if (str.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (str.equals("-")) {
                stack.push(-(stack.pop() - stack.pop()));
            } else if (str.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (str.equals("/")) {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                stack.push(b / a);
            } else {
                stack.push(Integer.valueOf(str));
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
