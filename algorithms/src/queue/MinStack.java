package queue;

import java.util.Stack;

/**
 * reference: (更牛逼的方式）
 * https://leetcode.com/problems/min-stack/discuss/49010/Clean-6ms-Java-solution
 */
public class MinStack {


    Stack<Integer> stack = null;
    Stack<Integer> minStack = null;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();

    }

    public void push(int x) {
        stack.push(x);

        if (minStack.isEmpty() || minStack.peek().intValue() > x) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            if (stack.peek().intValue() == minStack.peek().intValue()) {
                minStack.pop();
            }
            stack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
       return minStack.peek();
    }
}
