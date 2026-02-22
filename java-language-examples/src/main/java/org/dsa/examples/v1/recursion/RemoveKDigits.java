package org.dsa.examples.v1.recursion;

import java.util.Stack;

public class RemoveKDigits {
  public static void main(String[] args) {
    int num = 1432219;
    String output = new RemoveKDigits().solution(num + "", "", 0, 4);
    System.out.println("----------");
    System.out.println(output);
  }

  public String solution(String nums, String result, int index, int k) {
    Stack<Integer> stack = new Stack<>();
    if (stack.isEmpty()) {
      stack.push(Character.digit(nums.charAt(0), 10));
    }

    for (int i = 1; i < nums.length(); i++) {
      int current = Character.digit(nums.charAt(i), 10);
      while (!stack.isEmpty() && stack.peek() > current) {
        stack.pop();
      }
      stack.push(current);
      if (stack.size() == k) {
        break;
      }
    }
    return stack.toString();
  }
}
