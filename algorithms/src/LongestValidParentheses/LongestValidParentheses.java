package LongestValidParentheses;

import java.util.Stack;

public class LongestValidParentheses {

    static int findMaxLen(String str)
    {

        if (str.isEmpty()) return 0;

        int s = str.length();
        int result = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s; i++) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (!stack.isEmpty()) {
                    result = Math.max(result, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "()()";
        System.out.println(findMaxLen(str));

        str = "()(()))))";
        //System.out.println(findMaxLen(str));
    }
}
