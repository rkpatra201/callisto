package org.dsa.examples.v1.trees.ex1;

import org.dsa.examples.v1.trees.ex1.MinDepth_BFS;
import org.dsa.examples.v1.trees.traversal.TreeUtils;
import org.junit.Test;

public class MinDepth_BFSTest {

  @Test
  public void solution() {
    int result = MinDepth_BFS.solution(TreeUtils.getTree());
    System.out.println(result);
  }
}