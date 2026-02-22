package org.dsa.examples.v1.recursion;

import org.dsa.examples.v1.recursion.backtrack.NQueen;
import org.junit.Test;

public class NQueenTest {

  @Test
  public void solution() {
    new NQueen().solution(4);
//    new NQueen().solveNQueenAllSolns(4);
  }
}