package org.dsa.examples.v1.dp.grid;

import java.util.Arrays;
// https://leetcode.com/problems/minimum-path-sum/submissions/1564602564/
public class Lc_GridMinPathSum {

  public int solution(int[][] grid) {
    int n = grid[0].length;
    int m = grid.length;
    return recursive(grid, 0, 0, m, n);
  }

  private int[][] memo = null;

  public int recursive(int[][] grid, int i, int j, int m, int n) {
    if (memo == null) {
      memo = new int[m][n];
      int[] row = new int[n];
      Arrays.fill(row, -1);
      for (int index = 0; index < m; index++) {
        memo[index] = row.clone();
      }
    }

    if (i < 0 || j < 0 || i >= m || j >= n) {
      return Integer.MAX_VALUE;
    }

    if (memo[i][j] != -1) {
      return memo[i][j];
    }

    if (i == m - 1 && j == n - 1) {
      return grid[i][j];
    }

    int downSum = recursive(grid, i + 1, j, m, n);
    int rightSum = recursive(grid, i, j + 1, m, n);

    int result = Math.min(downSum, rightSum) + grid[i][j];
    memo[i][j] = result;
    return result;
  }
}