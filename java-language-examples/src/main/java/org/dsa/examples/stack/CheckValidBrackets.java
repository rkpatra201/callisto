package org.dsa.examples.stack;

import java.util.Stack;

// https://leetcode.com/problems/valid-parenthesis-string/submissions/1579702963/
//
public class CheckValidBrackets {
  public boolean checkValidString(String s) {
    Stack<Integer> brackets = new Stack<>();
    Stack<Integer> stars = new Stack<>();
    for(int i=0; i < s.length(); i++){
      char current = s.charAt(i);
      if(current=='('){
        brackets.push(i);
      }
      else if(current=='*'){
        stars.push(i);
      }
      else {
        // closing: current = )
        if(!brackets.isEmpty()){
          brackets.pop();
        }
        else if(!stars.isEmpty()){
          stars.pop(); // here * is behave like (
        }
        else{
          // both stacks empty but we are seeing ) brackets
          return false;
        }
      }
    }

    while(!brackets.isEmpty()){
      if(stars.isEmpty()){
        return false; // because brackets has some (
      }
      // * (
      int openAt = brackets.pop();
      int starIndex = stars.pop();
      if(starIndex < openAt){
        return false;
      }
    }

    return brackets.isEmpty();
  }
}
