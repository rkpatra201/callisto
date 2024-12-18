package org.dsa.examples.trees.ex1;

import org.dsa.examples.trees.traversal.TreeUtils;
import org.junit.Test;

public class HeightOfTree_DFSTest {

  @Test
  public void solution() {
    int result = HeightOfTree_DFS.solution(TreeUtils.getTree());
    System.out.println(result);
  }
}