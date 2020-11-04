import java.util.*;

public class BaseballGame {

    public int calPoints(String[] ops) {
        java.util.Stack<Integer> stack = new Stack<>();

        int sum = 0;

        for (String op: ops) {
            if (op.equals("C")) {

                sum -= stack.peek();
                stack.pop();

            } else if (op.equals("D")) {

                stack.push(stack.peek() * 2);
                sum += stack.peek();

            } else if (op.equals("+")) {

                int prev = stack.pop();
                int prev2 = stack.pop();

                stack.push(prev2);
                stack.push(prev);
                stack.push(prev + prev2);

                sum += stack.peek();

            } else {
                int i = Integer.valueOf(op);
                stack.push(i);
                sum += i;
            }

        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new BaseballGame().calPoints(new String[]{"5","-2","4","C","D","9","+","+"})); 
    }
}