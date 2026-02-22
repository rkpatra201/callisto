package org.dsa.examples.v1.dp.word;

public class EditDistanceTabulation {

  public int solution(String x, String y) {
    int result = solutionRecursive(x, y, x.length(), y.length());
    System.out.println(result);
    return solutionIterative(x, y);
  }

  private int solutionIterative(String x, String y) {
    int[][] dp = new int[x.length()][y.length()];

    int m = x.length();
    int n = y.length();
    // base case initialization
    for (int i = 0; i < m; i++) {
      dp[i][0] = i;
    }

    for (int j = 0; j < n; j++) {
      dp[0][j] = j;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (x.charAt(i - 1) == y.charAt(i - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          int deleteFromFirstString = dp[i-1][j];
          int deleteFromSecondString = dp[i][j-1];
          int replaceString = dp[i-1][j-1];
          dp[i][j] = 1 + Math.min(replaceString, Math.min(deleteFromFirstString, deleteFromSecondString));
        }
      }
    }
    return dp[m - 1][n - 1];
  }

  private int solutionRecursive(String x, String y, int m, int n) {
    if (n == 0) {
      return m;
    }
    if (m == 0) {
      return n;
    }
    if (x.charAt(m - 1) == y.charAt(n - 1)) {
      return solutionRecursive(x, y, m - 1, n - 1);
    }

    int deleteFromSecondString = solutionRecursive(x, y, m, n - 1);
    int deleteFromFirstString = solutionRecursive(x, y, m - 1, n);
    int replaceInBothString = solutionRecursive(x, y, m - 1, n - 1);
    int minValue = Math.min(deleteFromFirstString, deleteFromSecondString);
    minValue = Math.min(minValue, replaceInBothString);
    return 1 + minValue; // adding 1 because one success operation happening
  }
}
