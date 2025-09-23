package org.dsa.examples.nc150.stack;

public class _20_ValidParentheses {
    public boolean isValid(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) { // got a closing bracket but stack is empty or top of stack is not matching
                return false;
            }
        }
        return stack.isEmpty();
    }
}
