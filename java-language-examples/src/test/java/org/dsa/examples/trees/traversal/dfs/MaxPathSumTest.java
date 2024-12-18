package org.dsa.examples.trees.traversal.dfs;

import org.dsa.examples.trees.ex1.MaxPathSum_DFS;
import org.dsa.examples.trees.traversal.TreeNode;
import org.dsa.examples.trees.traversal.TreeUtils;
import org.junit.Test;

public class MaxPathSumTest {

  @Test
  public void solution() {
    TreeNode treeNode = TreeUtils.getTree();
    int result = MaxPathSum_DFS.solution(treeNode);
    System.out.println(result);
  }
}