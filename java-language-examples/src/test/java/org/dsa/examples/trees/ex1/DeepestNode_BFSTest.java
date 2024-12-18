package org.dsa.examples.trees.ex1;

import org.dsa.examples.trees.traversal.TreeNode;
import org.dsa.examples.trees.traversal.TreeUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeepestNode_BFSTest {

  @Test
  public void solution() {
    TreeNode deepNode = DeepestNode_BFS.solution(TreeUtils.getTree());
    System.out.println(deepNode.data);
  }
}