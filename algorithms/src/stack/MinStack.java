package stack;

import org.junit.Test;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
        minStack = new Stack<>();
    }

    public void push(int x) {

        stack.push(x);

        if (minStack.isEmpty() || minStack.peek() >= x) minStack.push(x);
    }

    public void pop() {
        if (stack.peek().intValue() == minStack.peek().intValue()) minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
