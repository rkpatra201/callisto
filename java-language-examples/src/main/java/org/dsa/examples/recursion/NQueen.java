package org.dsa.examples.recursion;

import java.util.ArrayList;
import java.util.List;

// leetcode: hard
// backtracking
public class NQueen {

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

  public List<Position> solution(int n) {
    List<Position> positions = new ArrayList<>();
    solveNQueenCol(n, 0, positions);
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

  private boolean solveNQueenRow(int n, int col, List<Position> positionList) {

    if (col == n) {
      System.out.println(positionList);
      return true;
    }

    for (int row = 0; row < n; row++) {

      if (isUnderAttack(positionList, row, col)) {
        continue;
      }

      Position p = new Position(row, col);
      positionList.add(p);
      boolean flag = solveNQueenRow(n, col + 1, positionList);
      if (flag) {
        return true;
      }
      positionList.remove(p);
    }
    return false;
  }


  private boolean solveNQueenCol(int n, int row, List<Position> positionList) {

    if (row == n) {
      System.out.println(positionList);
      return true;
    }

    for (int col = 0; col < n; col++) {

      if (isUnderAttack(positionList, row, col)) {
        continue;
      }

      Position p = new Position(row, col);
      positionList.add(p);
      boolean flag = solveNQueenCol(n, row + 1, positionList);
      if (flag) {
        return true; // as we want to find one solution, so return from here without backtrack
      }
      positionList.remove(p);
    }
    return false;
  }


  public void solveNQueenAllSolns(int n, int row, List<Position> positionList) {

    if (row == n) {
      System.out.println(positionList);
//      return true;
    }

    for (int col = 0; col < n; col++) {

      if (isUnderAttack(positionList, row, col)) {
        continue;
      }

      Position p = new Position(row, col);
      positionList.add(p);
      solveNQueenAllSolns(n, row + 1, positionList);
      positionList.remove(p);
    }

//    return false;
  }

  public void solveNQueenAllSolns(int n) {
    solveNQueenAllSolns(n, 0, new ArrayList<>());
  }

}
