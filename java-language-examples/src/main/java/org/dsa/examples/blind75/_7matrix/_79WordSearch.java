package org.dsa.examples.blind75._7matrix;

// https://leetcode.com/problems/word-search/submissions/1591598916/
public class _79WordSearch {
  public boolean exist(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
    visited = new boolean[m][n];

    for(int row=0; row< m; row++){
      for(int col = 0; col < n;col++){
        boolean flag = dfs(board, row, col, m,n, word, 0);
        if(flag){
          return flag;
        }
      }
    }

    return false;

  }

  private boolean[][] visited = null;
  public boolean dfs(char[][] board, int row, int col, int m, int n, String word, int pos) {
    if(pos == word.length()){
      return true;
    }
    boolean valid = row >=0 && row < m && col >=0 && col < n
        && pos < word.length() && word.charAt(pos) == board[row][col]
        && !visited[row][col];

    if(!valid){
      return false;
    }

    visited[row][col] = true;

    boolean found = dfs(board, row+1, col, m, n, word, pos+1)
        || dfs(board, row-1, col, m, n, word, pos+1)
        || dfs(board, row, col+1, m, n, word, pos+1)
        || dfs(board, row, col-1, m, n, word, pos+1) ;

    visited[row][col] = false;

    return found;
  }

}
