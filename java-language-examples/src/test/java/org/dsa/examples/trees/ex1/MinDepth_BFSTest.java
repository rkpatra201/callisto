package org.dsa.examples.trees.ex1;

import org.dsa.examples.trees.traversal.TreeUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinDepth_BFSTest {

  @Test
  public void solution() {
    int result = MinDepth_BFS.solution(TreeUtils.getTree());
    System.out.println(result);
  }
}