package interviewMedium.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    @Test
    public void test() {
        int n = 5;
        Long start = System.currentTimeMillis();
        System.out.println(generateParenthesis(n));
        System.out.println(System.currentTimeMillis() - start + " ms");

//        System.out.println(isValid("(()())"));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list, "", 0, 0, n);
        return list;
    }

    private void helper(List<String> list, String temp, int left, int right, int n) {

        if (temp.length() == n * 2) {
            list.add(temp);//if (isValid(temp)) list.add(temp);
            return;
        }


        if (right > left) return;


        if (left < n) {
            helper(list, temp + "(", left + 1, right, n);
        }

        if (right < n) {
            helper(list, temp + ")", left , right + 1, n);
        }

    }

    private  boolean isValid(String s) {

        Stack<Character>  stack = new Stack<>();
        for(char c: s.toCharArray()) {

            if (c == '(') stack.push('(');
            else if (stack.isEmpty()) return false;
            else stack.pop();

        }
        return stack.isEmpty();
    }


}
