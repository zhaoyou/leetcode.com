package String;

import org.junit.Test;

import java.util.Stack;

public class ValidParenthesisString {

    @Test
    public void test() {
        String s = "(*))";
        System.out.println(s + " isValidString: " + checkValidString(s));
    }

    public boolean checkValidString(String s) {
        if (s.isEmpty()) return true;


        Stack<Integer> stack = new Stack();
        Stack<Integer> starStack = new Stack();

        for(int i = 0;  i < s.length(); i++ ) {
            char c = s.charAt(i);
            if (c == '(') stack.push(i);
            else if (c == ')') {
                if (!stack.isEmpty()) stack.pop();
                else if (!starStack.isEmpty()) starStack.pop();
                else return false;
            } else {
                starStack.push(i);
            }
        }

        // 关键是 *( 这种情况无论如何都是非法的，保证两个stack里面（的索引小于* 就总有办法消掉。
        while(!stack.isEmpty() && !starStack.isEmpty()) {
            if (stack.pop() > starStack.pop()) return false;
        }

        return stack.isEmpty();


    }
}
