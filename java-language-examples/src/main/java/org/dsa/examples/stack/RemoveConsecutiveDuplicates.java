package org.dsa.examples.stack;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Stack;

// asm: 11th March 2025
public class RemoveConsecutiveDuplicates {

  public static void main(String[] args) {
    int[] arr = {1, 2, 2, 2, 3, 4, 5, 5, 3};

    boolean flag = false;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (!stack.isEmpty() && stack.peek() == arr[i]) {
        flag = true;
        continue;
      }
      if (flag) {
        stack.pop();
        flag = false;
      }
      stack.push(arr[i]);
    }
    System.out.println(stack);
    m1(null);
  }

  public static void m1(String[] args) {
    int[] arr = {1, 2, 2, 2, 3, 4, 5, 5, 3};

    int followUp = 0;
    boolean flag = false;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == arr[i - 1]) {
        arr[i - 1] = 0;
        flag = true;
      } else {
        if (flag) {
          arr[i - 1] = 0;
          flag = false;
        }
      }
    }

    System.out.println(Arrays.toString(arr));

    int index = 0;
    while (index < arr.length) {
      if (arr[index] != 0) {
        ArrayUtils.swap(arr, followUp, index);
        followUp++;
      }
      index++;
    }

    int[] result = Arrays.copyOfRange(arr, 0, followUp);
    System.out.println(Arrays.toString(result));
  }
}
