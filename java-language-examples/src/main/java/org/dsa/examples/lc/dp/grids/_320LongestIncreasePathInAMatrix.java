package org.dsa.examples.lc.dp.grids;

// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/submissions/1608766049/
public class _320LongestIncreasePathInAMatrix {
  public int longestIncreasingPath(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    visited = new boolean[row][col];
    initMemo(row,col);
    int max = 0;
    int prev = Integer.MIN_VALUE;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        max = Math.max(max, dfs(grid, row, col, i, j, prev));
      }
    }

    return max;
  }

  boolean[][] visited = null;

  private int[][] directions = {
      { 1, 0 },
      { -1, 0 },
      { 0, 1 },
      { 0, -1 }
  };

  private int[][] memo = null;

  private void initMemo(int m, int n){
    memo = new int[m][n];
  }

  public int dfs(int[][] grid, int row, int col, int i, int j, int prev) {
    boolean isValid = i >= 0 && i < row
        && j >= 0 && j < col
        && prev < grid[i][j]
        && !visited[i][j];
    if (!isValid) {
      return 0;
    }
    // memo
    if(memo[i][j] >= 1){
      return memo[i][j];
    }

    int dfsMax = 1; // at least current element;

    int v = grid[i][j];
    visited[i][j] = true;

    int levelMax = 0;
    for (int[] dir : directions) {
      int newRow = i + dir[0];
      int newCol = j + dir[1];

      levelMax = Math.max(levelMax, dfs(grid, row, col, newRow, newCol, v));
    }
    visited[i][j] = false;
    memo[i][j] = 1 + levelMax;
    return memo[i][j];
  }
}
