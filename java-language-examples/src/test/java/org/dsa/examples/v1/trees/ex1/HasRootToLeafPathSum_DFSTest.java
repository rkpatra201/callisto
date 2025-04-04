package org.dsa.examples.v1.trees.ex1;

import org.dsa.examples.v1.trees.ex1.HasRootToLeafPathSum_DFS;
import org.dsa.examples.v1.trees.traversal.TreeUtils;
import org.junit.Test;

public class HasRootToLeafPathSum_DFSTest {

  @Test
  public void solution() {
    boolean flag = HasRootToLeafPathSum_DFS.solution(TreeUtils.getTree(), 180);
    System.out.println(flag);
  }
}