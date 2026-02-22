package org.dsa.examples.v1.trees.traversal.dfs;

import org.dsa.examples.v1.trees.ex1.FindRootToLeafPathWithTargetSum_DFS;
import org.dsa.examples.v1.trees.traversal.TreeNode;
import org.dsa.examples.v1.trees.traversal.TreeUtils;
import org.junit.Test;

import java.util.List;

public class FindPathWithSumRecursionTest {

  @Test
  public void getPaths1() {
    TreeNode root = TreeUtils.getTree();
    int targetSum = 180;
    List<Integer> result = FindRootToLeafPathWithTargetSum_DFS.solution(root, targetSum);
    System.out.println(result);
  }
}