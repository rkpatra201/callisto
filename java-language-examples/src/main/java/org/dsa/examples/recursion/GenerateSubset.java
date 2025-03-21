package org.dsa.examples.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubset {

  public static void main(String[] args) {
    new GenerateSubset().solution("abcd");
  }
  public void solution(String s){
    recursive(s, 0, "", new ArrayList<>());
  }

  public void recursive(String s, int index, String current, List<String> solutions){
    if(index == s.length()){
      System.out.println(current);
      solutions.add(current);
      return;
    }
    String input1 = s.charAt(index) + current;
    String input2 = current;
    recursive(s, index+1, input1, solutions);
    recursive(s, index+1, input2, solutions);
  }
}
