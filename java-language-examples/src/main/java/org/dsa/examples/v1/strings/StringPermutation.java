package org.dsa.examples.v1.strings;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

  public List<String> solution(String input) {
    List<String> result = new ArrayList<>();
    recursive(result, input, "");
    return result;
  }

  private void recursive(List<String> result, String input, String output) {
    if (input.isEmpty()) {
      result.add(output);
      return;
    }

    for (int i = 0; i < input.length(); i++) {
      System.out.println(i);
      String firstPart = input.substring(0, i);
      String secondPart = input.substring(i + 1);
      recursive(result, firstPart + secondPart, output + input.charAt(i));
    }
  }
}
