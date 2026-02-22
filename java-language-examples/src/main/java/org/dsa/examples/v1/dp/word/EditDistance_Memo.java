package org.dsa.examples.v1.dp.word;

import java.util.Arrays;

// https://leetcode.com/problems/edit-distance/submissions/1565633616/
public class EditDistance_Memo extends EditDistance {


  public int solution(String x, String y) {
    return solution(x, y, x.length(), y.length());
  }

  private int[][] memo = null;

  private int solution(String x, String y, int m, int n) {
    if (n == 0) {
      return m;
    }
    if (m == 0) {
      return n;
    }

    if (memo == null) {
      memo = new int[x.length()][y.length()];
      int[] row = new int[memo[0].length];
      Arrays.fill(row, -1);
      for (int i = 0; i < x.length(); i++) {
        memo[i] = row.clone();
      }
    }

    if (memo[m - 1][n - 1] != -1) {
      return memo[m - 1][n - 1];
    }
    if (x.charAt(m - 1) == y.charAt(n - 1)) {
      return solution(x, y, m - 1, n - 1);
    }

    int deleteFromSecondString = solution(x, y, m, n - 1);
    int deleteFromFirstString = solution(x, y, m - 1, n);
    int replaceInBothString = solution(x, y, m - 1, n - 1);
    int minValue = Math.min(deleteFromFirstString, deleteFromSecondString);
    minValue = Math.min(minValue, replaceInBothString);
    int result = 1 + minValue; // adding 1 because one success operation happening
    memo[m - 1][n - 1] = result;
    return result;
  }
}
