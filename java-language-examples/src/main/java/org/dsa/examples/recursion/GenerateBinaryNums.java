package org.dsa.examples.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryNums {

  public static void main(String[] args) {
    List<String> output = new GenerateBinaryNums().solution(4);
    System.out.println(output);
  }

  public List<String> solution(int n) {
    return generate(n,"");
  }

  private List<String> generate(int n, String result) {
    if (n == 0) {
      return new ArrayList<>(List.of(result));
    }
    List<String> left = generate(n-1, result+"0");
    List<String> right = generate(n-1, result+"1");

    left.addAll(right);
    return left;
  }
}
