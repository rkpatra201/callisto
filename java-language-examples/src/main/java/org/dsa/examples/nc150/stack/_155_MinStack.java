package org.dsa.examples.nc150.stack;

import java.util.Stack;

public class _155_MinStack {

    Stack<Integer> minStack = new Stack<>();
    Stack<Integer> elemStack = new Stack<>();


    public void push(int val) {
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            // always push the min value at the top of minStack
            int msTop = minStack.peek();
            minStack.push(Math.min(msTop, val));
        }
        elemStack.push(val);
    }

    public void pop() {
        elemStack.pop();
        minStack.pop();
    }

    public int top() {
        return elemStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
