package org.dsa.examples.v1.trees.traversal.dfs;

import org.dsa.examples.v1.trees.ex1.MaxPathSum_DFS;
import org.dsa.examples.v1.trees.traversal.TreeNode;
import org.dsa.examples.v1.trees.traversal.TreeUtils;
import org.junit.Test;

public class MaxPathSumTest {

  @Test
  public void solution() {
    TreeNode treeNode = TreeUtils.getTree();
    int result = MaxPathSum_DFS.solution(treeNode);
    System.out.println(result);
  }
}