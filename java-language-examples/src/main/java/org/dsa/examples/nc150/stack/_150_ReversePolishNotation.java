package org.dsa.examples.nc150.stack;

import java.util.Stack;

public class _150_ReversePolishNotation {
    // Example Input: tokens = ["2","1","+","3","*"]
    // Example Output: 9
    // Explanation: ((2 + 1) * 3) = 9
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        /**
         * For each token in the input:
         *  If the token is a number, push it onto the stack.
         *  If the token is an operator, pop the top two numbers from the stack,
         *  apply the operator, and push the result back onto the stack.
         */
        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int res = applyOperator(a, b, token);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                // truncate towards zero
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
