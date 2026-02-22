package org.dsa.examples.v1.dp.grid;

import java.util.Arrays;

// https://leetcode.com/problems/unique-paths-ii/submissions/1564903485/
public class Lc_GridUniquePath2 {

  public int solution(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    memo = new int[m][n];
    int[] row = new int[n];
    Arrays.fill(row, -1);
    for (int i = 0; i < m; i++) {
      memo[i] = row.clone();
    }
    return recursive(grid, 0, 0, m, n);
  }

  private int[][] memo = null;

  private int recursive(int[][] grid, int i, int j, int m, int n) {
    if (i < 0 || j < 0 || i >= m || j >= n) {
      return 0;
    }
    if (grid[i][j] == 1) {
      return 0;
    }
    if (memo[i][j] != -1) {
      return memo[i][j];
    }
    if (i == m - 1 && j == n - 1) {
      return 1;
    }
    int result = recursive(grid, i + 1, j, m, n) +  // down
        recursive(grid, i, j + 1, m, n); // right
    System.out.println(i + "_" + j + ":" + result);
    memo[i][j] = result;
    return result;
  }
}
