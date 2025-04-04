package org.dsa.examples.v1.trees.ex1;

import org.dsa.examples.v1.trees.ex1.HeightOfTree_DFS;
import org.dsa.examples.v1.trees.traversal.TreeUtils;
import org.junit.Test;

public class HeightOfTree_DFSTest {

  @Test
  public void solution() {
    int result = HeightOfTree_DFS.solution(TreeUtils.getTree());
    System.out.println(result);
  }
}