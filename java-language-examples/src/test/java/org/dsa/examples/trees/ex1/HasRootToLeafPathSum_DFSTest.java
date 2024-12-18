package org.dsa.examples.trees.ex1;

import org.dsa.examples.trees.traversal.TreeUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class HasRootToLeafPathSum_DFSTest {

  @Test
  public void solution() {
    boolean flag = HasRootToLeafPathSum_DFS.solution(TreeUtils.getTree(), 180);
    System.out.println(flag);
  }
}