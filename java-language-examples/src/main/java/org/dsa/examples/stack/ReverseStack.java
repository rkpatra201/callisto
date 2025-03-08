package org.dsa.examples.stack;

import java.util.Stack;

public class ReverseStack {


  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);

    System.out.println(stack);
    visit(stack);
    System.out.println(stack);
  }

  private static void visit(Stack<Integer> stack) {
    if (stack.isEmpty()) {
      return;
    }
    int v = stack.pop();
    visit(stack);
    // above is general stack iteration
    saveAtBottom(v, stack);
  }

  private static void saveAtBottom(int v, Stack<Integer> stack){
    if(stack.isEmpty()){
      stack.push(v);
    }
    else{
      int top = stack.pop();
      saveAtBottom(v, stack);
      stack.push(top);
    }
  }
}
