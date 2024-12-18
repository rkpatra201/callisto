package org.dsa.examples.trees.ex1;

import org.dsa.examples.trees.traversal.TreeUtils;
import org.junit.Test;

public class Sum_All_Node_ValuesRecursionTest {

  @Test
  public void solution() {
    int result = Sum_All_Node_Values_DFS.solution(TreeUtils.getTree());
    System.out.println(result);
  }
}