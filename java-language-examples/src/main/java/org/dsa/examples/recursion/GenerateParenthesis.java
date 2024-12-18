package org.dsa.examples.recursion;

public class GenerateParenthesis {
  public void solution(int count) {
    solution("", count, 0, 0);
  }

  public void solution(String x, int count, int open, int close) {
    // base condition
    if (x.length() == count * 2) { // one of the leaf node having all valid ()
      System.out.println(x);
      return;
    }
    if (open < count) {
      solution(x + "(", count, open + 1, close);
    }

    if (close < open) {
      solution(x + ")", count, open, close + 1);
    }
  }
}
