package org.dsa.examples.lc.dp.grids;

import java.util.Arrays;
// count ways path to destination
// https://leetcode.com/problems/unique-paths/submissions/1564480666/
public class Lc_GridUniquePath {

  public int solution(int m, int n) {
    memo = new int[m][n];
    int[] row = new int[n];
    Arrays.fill(row, -1);
    for(int i=0; i< m; i++){
      memo[i] = row.clone();
    }
    return recursive(0, 0, m, n);
  }

  private int[][] memo = null;
  private int recursive(int i, int j, int m, int n) {
    if (i < 0 || j < 0 || i >= m || j >= n) {
      return 0;
    }
    if (memo[i][j] != -1) {
      return memo[i][j];
    }
    if (i == m-1 && j == n-1 ) {
      return 1;
    }
    int result = recursive(i + 1, j, m, n) +  // down
        recursive(i, j + 1, m, n); // right
    System.out.println(i+"_"+j+":"+result);
    memo[i][j] = result;
    return result;
  }
}
