package org.dsa.examples.v1.trees.ex1;

import org.dsa.examples.v1.trees.ex1.Sum_All_Node_Values_DFS;
import org.dsa.examples.v1.trees.traversal.TreeUtils;
import org.junit.Test;

public class Sum_All_Node_ValuesRecursionTest {

  @Test
  public void solution() {
    int result = Sum_All_Node_Values_DFS.solution(TreeUtils.getTree());
    System.out.println(result);
  }
}