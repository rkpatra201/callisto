package org.dsa.examples.dp.word;

import org.dsa.examples.dp.sum.AppUtils;

public class EditDistance {

  public int solution(String x, String y) {
    return solution(x, y, 0, 0);
  }

  private int solution(String x, String y, int m, int n) {
    if (n == y.length()) {
      return x.length() - m;
    }
    if (m == x.length()) {
      return y.length() - n;
    }
    if (x.charAt(m) == y.charAt(n)) {
      return solution(x, y, m + 1, n + 1);
    }

    int deleteFromSecondString = solution(x, y, m, n + 1);
    int deleteFromFirstString = solution(x, y, m + 1, n);
    int replaceInBothString = solution(x, y, m + 1, n + 1);
    int minValue = AppUtils.min(deleteFromFirstString, deleteFromSecondString, replaceInBothString);

    return 1 + minValue; // adding 1 because one success operation happening
  }
}
