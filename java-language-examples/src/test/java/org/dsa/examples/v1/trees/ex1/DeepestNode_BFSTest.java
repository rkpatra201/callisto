package org.dsa.examples.v1.trees.ex1;

import org.dsa.examples.v1.trees.ex1.DeepestNode_BFS;
import org.dsa.examples.v1.trees.traversal.TreeNode;
import org.dsa.examples.v1.trees.traversal.TreeUtils;
import org.junit.Test;

public class DeepestNode_BFSTest {

  @Test
  public void solution() {
    TreeNode deepNode = DeepestNode_BFS.solution(TreeUtils.getTree());
    System.out.println(deepNode.data);
  }
}