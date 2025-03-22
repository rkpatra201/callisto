package org.dsa.examples.blind75.w1;

import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/submissions/1582307554/
public class _5ValidBrackets {
  public boolean isValid(String s) {
    Stack<Integer> stack = new Stack<>();
    boolean flag = false;
    for (int i = 0; i < s.length(); i++) {
      char current = s.charAt(i);
      if (current == '(' || current == '{' || current == '[') {
        stack.push(i);
      } else {

        if (stack.isEmpty()) {
          return false; // invalid brackets: bcz we have open brackets but stack is empty
        }

        int topIndex = stack.peek();
        char topChar = s.charAt(topIndex);
        if (current == ')' && topChar == '(') {
          stack.pop();
        } else if (current == '}' && topChar == '{') {
          stack.pop();
        } else if (current == ']' && topChar == '[') {
          stack.pop();
        } else {// match didnt happen for the open bracket
          return false;
        }
      }
    }

    // System.out.println(s+":"+stack);

    return stack.isEmpty();
  }
}
