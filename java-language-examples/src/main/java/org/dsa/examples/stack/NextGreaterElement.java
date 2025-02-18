package org.dsa.examples.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {

  public List<Integer> findNextGreaterElement(int[] arr) {
    List<Integer> list = new ArrayList<>(arr.length);
    Stack<Integer> stack = new Stack<>();
    for (int i = arr.length - 1; i >= 0; i--) { // traverse from left to make it ordered
      int element = arr[i];
      // when top of stack has small value than the current element, do pop()
      while (!stack.isEmpty() && stack.peek() < element) {
        stack.pop(); // pop once
      }

      if (stack.isEmpty()) { // when stack is empty
        list.add(-1);
      } else {
        // when the stack top() has larger element
        list.add(stack.peek());
      }

      stack.push(element); // push once
    }
    Collections.reverse(list); // reverse to maintain order
    return list;
  }
}
