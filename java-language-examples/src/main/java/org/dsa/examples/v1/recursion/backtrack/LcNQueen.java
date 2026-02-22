package org.dsa.examples.v1.recursion.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// leetcode: hard
// backtracking
public class LcNQueen {

  private static class Position {
    int row;
    int col;

    public Position(int row, int col) {
      this.row = row;
      this.col = col;
    }

    @Override
    public String toString() {
      return "Position{" +
          "row=" + row +
          ", col=" + col +
          '}';
    }
  }

  public static void main(String[] args) {
    new LcNQueen().solution(4);
  }

  private List<List<String>> result = new ArrayList<>();
  public List<Position> solution(int n) {
    List<Position> positions = new ArrayList<>();
    solveNQueenAllSolns(n, 0, positions);
    //  System.out.println(positions);
    return positions;
  }

  private boolean isUnderAttack(List<Position> positions, int row, int col) {
    for (Position p : positions) {
      if (p.row == row) { // check same row
        return true;
      }
      if (p.col == col) { // check same column
        return true;
      }
      if (Math.abs(p.row - row) == Math.abs(p.col - col)) { // check same diagonal: tricky
        return true;
      }
    }
    return false;
  }

  public void solveNQueenAllSolns(int n, int row, List<Position> positionList) {

    if (row == n) {

      System.out.println(positionList);

      List<String> x = new ArrayList<>();
      for(Position p: positionList){
        char[] str = new char[n];
        Arrays.fill(str,'.');
        str[p.col] = 'Q';
        x.add(new String(str));
      }

      if(!x.isEmpty()){
        result.add(x);
      }
//      return true;
    }

    for (int col = 0; col < n; col++) {

      if (isUnderAttack(positionList, row, col)) {
        //state = state +".";
        continue;
      }

      Position p = new Position(row, col);
      positionList.add(p);
      solveNQueenAllSolns(n, row + 1, positionList);
//      if (flag) {
//        return true; // as we want to find one solution, so return from here without backtrack
//      }
      positionList.remove(p);
    }

//    return false;
  }
}
