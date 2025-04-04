package org.dsa.examples.v1.recursion;

import java.util.ArrayList;
import java.util.List;

public class PatternReplacement {

  public static List<String> solution(String input) {
    List<String> list = new ArrayList<>();
    findSolution(input, list);
    return list;
  }

  private static void findSolution(String input, List<String> result) {
    int i = input.indexOf("#");
    if (i == -1) {
      result.add(input);
      return;
    }
    char[] ch1 = input.toCharArray();
    ch1[i] = '1';
    findSolution(new String(ch1), result);
    char[] ch2 = input.toCharArray();
    ch2[i] = '0';
    findSolution(new String(ch2), result);
  }

}
