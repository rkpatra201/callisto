package org.dsa.examples.recursion;

import org.dsa.examples.recursion.backtrack.NQueen;
import org.junit.Test;

import static org.junit.Assert.*;

public class NQueenTest {

  @Test
  public void solution() {
    new NQueen().solution(4);
//    new NQueen().solveNQueenAllSolns(4);
  }
}