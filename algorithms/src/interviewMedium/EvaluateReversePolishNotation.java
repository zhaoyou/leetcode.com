package interviewMedium;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    @Test
    public void test() {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens) {
            if (!isSign(token)) {
                stack.add(Integer.parseInt(token));
            } else {
                int first = stack.pop();
                int second = stack.pop();

                if (token.equals("+")) {
                    stack.push(second + first);
                } else if(token.equals("-")) {
                    stack.push(second - first);
                } else if (token.equals("*")) {
                    stack.push(second * first);
                } else {
                    stack.push(second / first);
                }
            }
        }
        return stack.pop();
    }

    private boolean isSign(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}
