package org.dsa.examples.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubsetOfSizeK {

  public static void main(String[] args) {
    new GenerateSubsetOfSizeK().solution("abcde", 4);
  }

  public void solution(String s, int k) {
    recursive(s, 0, "", new ArrayList<>(), k);
  }

  public void recursive(String s, int index, String current, List<String> solutions, int k) {
    if (current.length() == k) {
      System.out.println(current);
      solutions.add(current);
      return;
    }
    if (index == s.length()) {
      return;
    }
    String input1 = current + s.charAt(index);
    String input2 = current;
    recursive(s, index + 1, input1, solutions, k);
    recursive(s, index + 1, input2, solutions, k);
  }
}
